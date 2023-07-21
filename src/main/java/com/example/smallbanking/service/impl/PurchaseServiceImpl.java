package com.example.smallbanking.service.impl;

import com.example.smallbanking.builder.PaymentBuilder;
import com.example.smallbanking.builder.ResponseBuilder;
import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Customer;
import com.example.smallbanking.entity.repository.CustomerRepository;
import com.example.smallbanking.entity.Payment;
import com.example.smallbanking.service.PurchaseService;
import com.example.smallbanking.enums.PaymentTypeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final CustomerRepository customerRepository;

    public PurchaseServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentResponseDto purchaseMoney(PaymentRequestDto paymentRequestDto) {
        Customer customer = customerRepository.findById(paymentRequestDto.getCustomerId())
                .orElseThrow(()->new RuntimeException("Customer Not found"));
        BigDecimal balance = customer.getBalance();
        BigDecimal amount = paymentRequestDto.getAmount();
        if (balance.compareTo(BigDecimal.ZERO) <= 0 || balance.compareTo(amount) < 0){
            throw  new  RuntimeException("insufficient funds");
        }
        BigDecimal subtractedBalance = balance.subtract(amount);
        customer.setBalance(subtractedBalance);
        Payment payment =  PaymentBuilder.build(amount, PaymentTypeEnum.PURCHASE);
        customer.addPayment(payment);
        customerRepository.save(customer);

        return ResponseBuilder.successResponse(customer.getId(), payment);
    }
}
