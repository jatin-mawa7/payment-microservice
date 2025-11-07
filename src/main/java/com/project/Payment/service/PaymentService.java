package com.project.Payment.service;

import com.project.Payment.entity.Payment;
import com.project.Payment.model.PaymentRequest;
import com.project.Payment.model.PaymentResponse;
import com.project.Payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setPaymentMode(request.getPaymentMode());
        payment.setAmount(request.getAmount());

        // Simulate payment logic
        boolean success = new Random().nextBoolean();
        payment.setStatus(success ? "SUCCESS" : "FAILED");

        Payment savedPayment = paymentRepository.save(payment);

        return new PaymentResponse(
                savedPayment.getId(),
                savedPayment.getOrderId(),
                savedPayment.getPaymentMode(),
                savedPayment.getAmount(),
                savedPayment.getStatus(),
                success ? "Payment processed successfully" : "Payment failed"
        );
    }

    public PaymentResponse getPaymentByOrderId(Long orderId) {
        Optional<Payment> optionalPayment = paymentRepository.findByOrderId(orderId);
        if (optionalPayment.isEmpty()) return null;

        Payment payment = optionalPayment.get();
        return new PaymentResponse(
                payment.getId(),
                payment.getOrderId(),
                payment.getPaymentMode(),
                payment.getAmount(),
                payment.getStatus(),
                "Payment retrieved successfully"
        );
    }
}
