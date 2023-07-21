package com.example.smallbanking.service.impl;

import com.example.smallbanking.builder.PaymentBuilder;
import com.example.smallbanking.builder.ResponseBuilder;
import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Customer;
import com.example.smallbanking.entity.repository.CustomerRepository;
import com.example.smallbanking.entity.Payment;
import com.example.smallbanking.service.TopUpService;
import com.example.smallbanking.enums.PaymentTypeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TopUpServiceImpl implements TopUpService {
    private final CustomerRepository customerRepository;

    public TopUpServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentResponseDto topUpBalance(PaymentRequestDto paymentRequestDto) {
        Customer customer = customerRepository.findById(paymentRequestDto.getCustomerId()).orElseThrow(
                ()->new RuntimeException("Customer Not found")
        );
        BigDecimal addedBalance = customer.getBalance().add(paymentRequestDto.getAmount());
        Payment payment =  PaymentBuilder.build(paymentRequestDto.getAmount(), PaymentTypeEnum.TOP_UP);
        customer.addPayment(payment);
        customer.setBalance(addedBalance);
        customerRepository.save(customer);
        return ResponseBuilder.successResponse(customer.getId(), payment);
    }
}
