package com.example.smallbanking.controller;

import com.example.smallbanking.dto.request.PaymentRequestDto;
import com.example.smallbanking.dto.response.PaymentResponseDto;
import com.example.smallbanking.service.PurchaseService;
import com.example.smallbanking.service.RefundService;
import com.example.smallbanking.service.TopUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
    private final TopUpService topUpService;
    private final PurchaseService purchaseService;
    private final RefundService refundService;

    public PaymentController(TopUpService topUpService, PurchaseService purchaseService, RefundService refundService) {
        this.topUpService = topUpService;
        this.purchaseService = purchaseService;
        this.refundService = refundService;
    }

    @PostMapping("top-up")
    public ResponseEntity<PaymentResponseDto> topUp(@RequestBody PaymentRequestDto paymentRequestDto){
        return ResponseEntity.ok( topUpService.topUpBalance(paymentRequestDto));
    }

    @PostMapping("purchase")
    public ResponseEntity<PaymentResponseDto> purchaseMoney(@RequestBody PaymentRequestDto paymentRequestDto){
        return ResponseEntity.ok(purchaseService.purchaseMoney(paymentRequestDto));
    }

    @PostMapping("refund")
    public ResponseEntity<PaymentResponseDto> refund(@RequestBody PaymentRequestDto paymentRequestDto) {
        return ResponseEntity.ok((refundService.refundBalance(paymentRequestDto)));
    }
}
