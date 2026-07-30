package com.gguledew.store.service;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("Message: "+message);
    }
}
