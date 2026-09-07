package com.gguledew.store.repository;

import com.gguledew.store.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
    public List<User> findUserByProductsId(Long id);
    @EntityGraph(attributePaths = "tags")
    public Optional<User> findUserAndTagByEmail(String email);
}