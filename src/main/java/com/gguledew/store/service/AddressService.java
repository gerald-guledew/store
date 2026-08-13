package com.gguledew.store.service;

import com.gguledew.store.domain.Address;
import com.gguledew.store.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public void extractAddress (Long id) {
        var address = addressRepository.findById(id).orElseThrow();
        System.out.println("Address toString() is: "+address.toString());
        System.out.println("Address is: "+address.getStreet()+
                ", "+address.getCity()+
                ", "+address.getState()+
                ", "+address.getZip());
    }
}
