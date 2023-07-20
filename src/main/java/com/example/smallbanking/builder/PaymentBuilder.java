package com.example.smallbanking.builder;

import com.example.smallbanking.entity.Payment;
import com.example.smallbanking.enums.PaymentTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentBuilder {

    public static Payment build(BigDecimal amount, PaymentTypeEnum typeEnum){
        return new Payment()
                .setTransactionType(typeEnum.name())
                .setTransactionStatus("SUCCESS")
                .setTransactionDate(LocalDateTime.now())
                .setTransactionId(UUID.randomUUID().toString())
                .setTransactionAmount(amount);
    }
}
