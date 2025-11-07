package com.project.Payment.controller;

import com.project.Payment.model.PaymentRequest;
import com.project.Payment.model.PaymentResponse;
import com.project.Payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment Service", description = "APIs for processing and retrieving payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse response = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(response);
}


    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable Long orderId) {
        PaymentResponse response = paymentService.getPaymentByOrderId(orderId);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
