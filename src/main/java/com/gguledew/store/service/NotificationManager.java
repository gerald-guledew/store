package com.gguledew.store.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
    private final NotificationService notificationService;

    public NotificationManager(@Qualifier("email") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message, String recipientEmail) {
        notificationService.send(message, recipientEmail);
    }
}
