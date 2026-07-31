package com.gguledew.store.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
    private final PaymentService paymentService;

    public OrderService (PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    @PostConstruct
    public void init () {
        System.out.println("In OrderService, called PostConstruct");
    }

    @PreDestroy
    public void cleanup () {
        System.out.println("In OrderService, called PreDestroy");
    }

    public void placeOrder () {
        paymentService.processPayment(10);
    }

}
