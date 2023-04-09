package com.example.barberstudiobaku.business;


import com.example.barberstudiobaku.model.Payment;
import com.example.barberstudiobaku.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(String appointmentId, String customerId, double paymentAmount, String paymentMethod, String paymentDetails) {
        String paymentId = generatePaymentId();
        LocalDateTime paymentDate = LocalDateTime.now();
        String paymentStatus = "Pending";
        Payment payment = new Payment(paymentId, appointmentId, customerId, paymentAmount, paymentDate, paymentMethod, paymentStatus, paymentDetails);
        paymentRepository.save(payment);
        return payment;
    }

    private String generatePaymentId() {
        return UUID.randomUUID().toString();
    }
}

