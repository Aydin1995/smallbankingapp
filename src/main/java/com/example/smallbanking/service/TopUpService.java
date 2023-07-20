package com.example.smallbanking.service;

import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;

public interface TopUpService {
     PaymentResponseDto topUpBalance(PaymentRequestDto paymentRequestDto);
}
