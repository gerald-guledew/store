package com.gguledew.store.repositories;

import com.gguledew.store.entities.Profile;
import com.gguledew.store.dtos.UserSummary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths="user")
    List<Profile> findProfilesByLoyaltyPointsGreaterThanOrderByUserEmailDesc(Long points);

    @Query("select p.id as id, u.email as email from Profile p join p.user u where p.loyaltyPoints > :points order by u.email asc")
    List<UserSummary> findByLoyaltyPoints(@Param("points") Long loyaltypoints);
}