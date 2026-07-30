package com.gguledew.store.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS NOTIFICATION");
        System.out.println("Message: "+message);
    }
}
