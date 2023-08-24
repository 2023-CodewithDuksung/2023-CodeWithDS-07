package com.example.hackathon07.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "Order_Payment_Method")

public class OrderPaymentMethod {
    @Id @GeneratedValue
    @Column(name = "PAYMENT_METHOD_ID")
    private Long paymentMethodId;

    @Column(name = "Method")
    private String method;

    public OrderPaymentMethod(Long paymentMethodId, String method) {
        this.paymentMethodId = paymentMethodId;
        this.method = method;
    }

}

