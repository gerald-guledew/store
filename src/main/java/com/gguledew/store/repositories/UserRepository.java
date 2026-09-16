package com.gguledew.store.repositories;

import com.gguledew.store.entities.User;
import com.gguledew.store.dtos.UserSummary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
    public List<User> findUserByProductsId(Long id);
    @EntityGraph(attributePaths = "tags")
    public Optional<User> findUserAndTagByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    public List<User> findAllWithAddresses();

    @Query("select u.profile.id as id, u.email as email from User u where u.profile.loyaltyPoints > :point")
    @EntityGraph (attributePaths="profile")
    List<UserSummary> findUsersByProfileLoyaltyPoints(@Param("point") Long point);
}