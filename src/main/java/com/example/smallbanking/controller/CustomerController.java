package com.example.smallbanking.controller;

import com.example.smallbanking.dto.request.AddCustomerRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.service.AddCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("customer")
public class CustomerController {
    private final AddCustomerService addCustomerService;

    public CustomerController(AddCustomerService addCustomerService) {
        this.addCustomerService = addCustomerService;
    }


    @PostMapping("add")
    public ResponseEntity<PaymentResponseDto> add(@RequestBody AddCustomerRequestDto addCustomerRequestDto) {
        return ResponseEntity.ok(addCustomerService.addCustomerWithInitialBalance(addCustomerRequestDto));
    }
}
