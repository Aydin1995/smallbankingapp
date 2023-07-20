package com.example.smallbanking.service.impl;

import com.example.smallbanking.builder.CustomerBuilder;
import com.example.smallbanking.builder.PaymentBuilder;
import com.example.smallbanking.builder.ResponseBuilder;
import com.example.smallbanking.dto.request.AddCustomerRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Customer;
import com.example.smallbanking.entity.repository.CustomerRepository;
import com.example.smallbanking.entity.Payment;
import com.example.smallbanking.service.AddCustomerService;
import com.example.smallbanking.enums.PaymentTypeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddCustomerServiceImpl implements AddCustomerService {
    private final CustomerRepository customerRepository;

    public AddCustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentResponseDto addCustomerWithInitialBalance(AddCustomerRequestDto addCustomerRequestDto) {
        Customer customer = CustomerBuilder.build(addCustomerRequestDto);
        Payment payment = PaymentBuilder.build(new BigDecimal(100), PaymentTypeEnum.ADD_BALANCE);
        customer.addPayment(payment);
        customerRepository.save(customer);
        return ResponseBuilder.successResponse(payment);
    }
}
