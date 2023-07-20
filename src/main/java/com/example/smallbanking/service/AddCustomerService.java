package com.example.smallbanking.service;

import com.example.smallbanking.dto.request.AddCustomerRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;

public interface AddCustomerService {
    PaymentResponseDto addCustomerWithInitialBalance(AddCustomerRequestDto addCustomerRequestDto);
}
