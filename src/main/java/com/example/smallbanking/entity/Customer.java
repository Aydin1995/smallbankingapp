package com.example.smallbanking.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name = "GSM_NUMBER")
    private String gsmNumber;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Payment> payments=new ArrayList<>();

    public List<Payment> getPayments() {
        return payments;
    }

    public Customer setPayments(List<Payment> customerTransactions) {
        this.payments = customerTransactions;
        return this;
    }

    public Customer addPayment(Payment payment){
        this.payments.add(payment);
        return this;
    }
    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public Customer setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }


}
