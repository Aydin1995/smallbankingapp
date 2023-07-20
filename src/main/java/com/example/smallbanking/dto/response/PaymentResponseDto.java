package com.example.smallbanking.dto.response;

import com.example.smallbanking.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDto  {

    private String status;
    private String transactionId;
    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;


    public String getStatus() {
        return status;
    }

    public PaymentResponseDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public PaymentResponseDto setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentResponseDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public PaymentResponseDto setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public PaymentResponseDto setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static PaymentResponseDto successResponse(Payment payment) {
        return new PaymentResponseDto()
                .setStatus("SUCCESS")
                .setTransactionId(payment.getTransactionId())
                .setAmount(payment.getTransactionAmount())
                .setTransactionType(payment.getTransactionType())
                .setTimestamp(LocalDateTime.now());
    }
}
