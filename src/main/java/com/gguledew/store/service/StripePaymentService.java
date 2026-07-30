package com.gguledew.store.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String stripeApiUrl;

    @Value("${stripe.enabled}")
    private boolean stripeEnabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> currency;

    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("Amount:"+amount);
        System.out.println("stripe.apiUrl:" + stripeApiUrl);
        System.out.println("stripe.enabled:" + stripeEnabled);
        System.out.println("timeout:" + timeout);
        System.out.println("Supported Currencies:" + currency.toString());
    }
}
