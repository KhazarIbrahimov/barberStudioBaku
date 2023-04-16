package com.example.barberstudiobaku.controller;

import com.example.barberstudiobaku.business.PaymentRequest;
import com.example.barberstudiobaku.business.PaymentService;
import com.example.barberstudiobaku.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentRestController {
    private PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.makePayment(paymentRequest.getAppointmentId(), paymentRequest.getCustomerId(), paymentRequest.getPaymentAmount(), paymentRequest.getPaymentMethod(), paymentRequest.getPaymentDetails());
        return ResponseEntity.ok(payment);
    }
}

