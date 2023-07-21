package com.example.smallbanking.service.impl;

import com.example.smallbanking.builder.PaymentBuilder;
import com.example.smallbanking.builder.ResponseBuilder;
import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Customer;
import com.example.smallbanking.entity.repository.CustomerRepository;
import com.example.smallbanking.entity.Payment;
import com.example.smallbanking.service.RefundService;
import com.example.smallbanking.enums.PaymentTypeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RefundServiceImpl implements RefundService {
    private final CustomerRepository customerRepository;

    public RefundServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentResponseDto refundBalance(PaymentRequestDto paymentRequestDto) {
        Customer customer = customerRepository.findById(paymentRequestDto.getCustomerId()).orElseThrow(
                () -> new RuntimeException("customer not found")
        );
        List<Payment> payments = customer.getPayments();
        Payment purchasedPayment =
                payments
                        .stream()
                        .filter(data -> data.getTransactionType().equals(PaymentTypeEnum.PURCHASE.name()))
                        .max(Comparator.comparing(Payment::getTransactionDate)).orElseThrow(
                                () -> new RuntimeException("not found  purchased transaction"));

        String transactionId = purchasedPayment.getTransactionId();
        BigDecimal purchaseAmount = purchasedPayment.getTransactionAmount();

        List<Payment> refundTransactions = customer.getPayments()
                .stream()
                .filter(data -> data.getReferralTransactionId() != null
                        &&
                        data.getReferralTransactionId().equals(transactionId)
                        &&
                        data.getTransactionType().equals(PaymentTypeEnum.REFUND.name()))
                .collect(Collectors.toList());

        BigDecimal inputAmount = paymentRequestDto.getAmount();
        if (refundTransactions.isEmpty()) {
            if (inputAmount.compareTo(purchaseAmount) > 0) {
                throw new RuntimeException("exceeds refund amount");
            }
            return saveAndReturnPaymentResponseDto(customer, transactionId, inputAmount);
        } else {
            BigDecimal refundAmount =
                    refundTransactions
                            .stream()
                            .map(Payment::getTransactionAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

            if (refundAmount.compareTo(purchaseAmount) == 0) {
                throw new RuntimeException("payment already refunded");
            }

            if (inputAmount.add(refundAmount).compareTo(purchaseAmount) <= 0) {
                return saveAndReturnPaymentResponseDto(customer, transactionId, inputAmount);
            } else {
                throw new RuntimeException("exceeds refund amount");
            }

        }
    }

    private PaymentResponseDto saveAndReturnPaymentResponseDto(Customer customer, String transactionId, BigDecimal inputAmount) {
        Payment refundPayment;
        refundPayment = PaymentBuilder.build(inputAmount, PaymentTypeEnum.REFUND);
        refundPayment.setReferralTransactionId(transactionId);
        customer.setBalance(customer.getBalance().add(inputAmount));
        customer.addPayment(refundPayment);
        customerRepository.save(customer);
        return ResponseBuilder.successResponse(customer.getId(), refundPayment);
    }
}
