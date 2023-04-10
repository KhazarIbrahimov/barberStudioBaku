package com.example.barberstudiobaku.business;

public class PaymentRequest {
    private String appointmentId;
    private String customerId;
    private double paymentAmount;
    private String paymentMethod;
    private String paymentDetails;

    public PaymentRequest() {}

    public PaymentRequest(String appointmentId, String customerId, double paymentAmount, String paymentMethod, String paymentDetails) {
        this.appointmentId = appointmentId;
        this.customerId = customerId;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}

