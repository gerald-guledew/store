package com.gguledew.store.service;

import com.gguledew.store.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public void showRelatedEntities () {
        var profile = profileRepository.findById(1L).orElseThrow();
        System.out.println("Profile: "+profile);
    }
}
