package com.project.Payment.model;

public class PaymentRequest {
    private Long orderId;
    private String paymentMode;
    private Double amount;

    public PaymentRequest() {}

    public PaymentRequest(Long orderId, String paymentMode, Double amount) {
        this.orderId = orderId;
        this.paymentMode = paymentMode;
        this.amount = amount;
    }

    // Getters and Setters
    public Long getOrderId()
    {
        return orderId;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public String getPaymentMode()
    {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode)
    {
        this.paymentMode = paymentMode;
    }

    public Double getAmount()
    {
        return amount;
    }
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
}
