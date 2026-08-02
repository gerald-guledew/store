package com.gguledew.store.repository;

import com.gguledew.store.domain.User;

public interface UserRepository {
    void save (User user);
    User findByEmail(String email);
}
