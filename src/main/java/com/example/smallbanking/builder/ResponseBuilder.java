package com.example.smallbanking.builder;

import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.entity.Payment;

import java.time.LocalDateTime;

public class ResponseBuilder {
    public static PaymentResponseDto successResponse(Long customerId, Payment payment) {

        return new PaymentResponseDto()
                .setStatus("SUCCESS")
                .setCustomerId(customerId)
                .setTransactionId(payment.getTransactionId())
                .setAmount(payment.getTransactionAmount())
                .setTransactionType(payment.getTransactionType())
                .setTimestamp(LocalDateTime.now());
    }
}
