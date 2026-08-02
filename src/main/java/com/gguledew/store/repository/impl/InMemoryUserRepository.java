package com.gguledew.store.repository.impl;

import com.gguledew.store.domain.User;
import com.gguledew.store.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> userData = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("Saving User Information");
        userData.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return userData.getOrDefault(email, null);
    }
}
