package com.example.smallbanking.builder;

import com.example.smallbanking.dto.request.AddCustomerRequestDto;
import com.example.smallbanking.entity.Customer;

import java.math.BigDecimal;

public class CustomerBuilder {

    public static Customer build(AddCustomerRequestDto addCustomerRequestDto){
        return new Customer()
                .setBalance(BigDecimal.valueOf(100))
                .setBirthDate(addCustomerRequestDto.getBirthDate())
                .setName(addCustomerRequestDto.getName())
                .setSurname(addCustomerRequestDto.getSurname())
                .setGsmNumber(addCustomerRequestDto.getGsmNumber());

    }
}
