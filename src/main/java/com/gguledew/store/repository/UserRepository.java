package com.gguledew.store.repository;

import com.gguledew.store.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}