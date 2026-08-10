package com.gguledew.store.service;

import com.gguledew.store.domain.User;
import com.gguledew.store.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntityStateService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityStates () {
        var user = User.builder().name("g4").email("g4.g4@g4").password("pass").build();

        if (entityManager.contains(user)) {
            System.out.println("1: Persistent");
        } else {
            System.out.println("1: Transient or Detached");
        }

        userRepository.save(user);

        if (entityManager.contains(user)) {
            System.out.println("2: Persistent");
        } else {
            System.out.println("2: Transient or Detached");
        }
    }

    public void showRelatedEntities () {
        var user = userRepository.findById(3L).orElseThrow();
        System.out.println("User: "+user.getEmail());
    }
}
