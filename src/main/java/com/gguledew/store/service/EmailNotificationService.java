package com.gguledew.store.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {
    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("Message: "+message);
        System.out.println("Recipient Email: "+recipientEmail);
        System.out.println("mail.host: "+host);
        System.out.println("mail.port: "+port);
    }
}
