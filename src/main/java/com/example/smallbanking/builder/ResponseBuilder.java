package com.example.smallbanking.builder;

import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Payment;

import java.time.LocalDateTime;

public class ResponseBuilder {
    public static PaymentResponseDto successResponse(Payment payment) {

        return new PaymentResponseDto()
                .setStatus("SUCCESS")
                .setTransactionId(payment.getTransactionId())
                .setAmount(payment.getTransactionAmount())
                .setTransactionType(payment.getTransactionType())
                .setTimestamp(LocalDateTime.now());
    }
}
