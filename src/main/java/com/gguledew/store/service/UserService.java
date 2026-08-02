package com.gguledew.store.service;

import com.gguledew.store.domain.User;
import com.gguledew.store.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser (User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("User already exist. Cannot save user.");
            throw new IllegalArgumentException("User with email "+user.getEmail()+" already exist");
        }
        userRepository.save(user);
        notificationService.send("You're now registered", user.getEmail());
    }
}
