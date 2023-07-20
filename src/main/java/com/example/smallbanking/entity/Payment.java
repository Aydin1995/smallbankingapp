package com.example.smallbanking.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "REFERRAL_TRANSACTION_ID")
    private String referralTransactionId;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "TRANSACTION_STATUS")
    private String transactionStatus;

    @Column(name = "TRANSACTION_AMOUNT")
    private BigDecimal transactionAmount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Payment setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Payment setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public Payment setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public Payment setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Payment setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }


    public String getReferralTransactionId() {
        return referralTransactionId;
    }

    public Payment setReferralTransactionId(String referralTransactionId) {
        this.referralTransactionId = referralTransactionId;
        return this;
    }

}
