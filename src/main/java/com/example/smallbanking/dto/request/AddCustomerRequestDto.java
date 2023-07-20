package com.example.smallbanking.dto.request;

import java.time.LocalDate;

public class AddCustomerRequestDto {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gsmNumber;

    public String getName() {
        return name;
    }

    public AddCustomerRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public AddCustomerRequestDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public AddCustomerRequestDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public AddCustomerRequestDto setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
        return this;
    }
}
