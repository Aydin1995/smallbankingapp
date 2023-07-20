package com.example.smallbanking.dto.request;

import java.math.BigDecimal;

public class PaymentRequestDto {
    private Long customerId;
    private BigDecimal amount;

    public Long getCustomerId() {
        return customerId;
    }

    public PaymentRequestDto setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentRequestDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
