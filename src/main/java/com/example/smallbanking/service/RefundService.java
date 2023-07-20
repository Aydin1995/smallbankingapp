package com.example.smallbanking.service;

import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;

public interface RefundService {
    PaymentResponseDto refundBalance(PaymentRequestDto paymentRequestDto);
}
