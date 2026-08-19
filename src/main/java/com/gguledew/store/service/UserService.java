package com.gguledew.store.service;

import com.gguledew.store.domain.Address;
import com.gguledew.store.domain.User;
import com.gguledew.store.repository.AddressRepository;
import com.gguledew.store.repository.ProductRepository;
import com.gguledew.store.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, NotificationService notificationService, AddressRepository addressRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
    }

    public void registerUser (User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("User already exist. Cannot save user.");
            throw new IllegalArgumentException("User with email "+user.getEmail()+" already exist");
        }
        userRepository.save(user);
        notificationService.send("You're now registered", user.getEmail());
    }

    public void deleteRelatedRecord(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteAddressOfUser(Long id) {
        var user =  userRepository.findById(id).get();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void populateUsers() {
        var user = User.builder().name("name3").email("email3").password("password3").build();
        userRepository.save(user);
        var address = Address.builder().street("street3").city("city3").zip("zip3").state("state3").build();
        user.addAddresses(address);
        addressRepository.save(address);
        user = User.builder().name("name4").email("email4").password("password4").build();
        userRepository.save(user);
        address = Address.builder().street("street4").city("city4").zip("zip4").state("state4").build();
        user.addAddresses(address);
        addressRepository.save(address);
        user = User.builder().name("name5").email("email5").password("password5").build();
        userRepository.save(user);
        address = Address.builder().street("street5").city("city5").zip("zip5").state("state5").build();
        user.addAddresses(address);
        addressRepository.save(address);
        user = User.builder().name("name6").email("email6").password("password6").build();
        userRepository.save(user);
        address = Address.builder().street("street6").city("city6").zip("zip6").state("state6").build();
        user.addAddresses(address);
        addressRepository.save(address);
    }

    @Transactional
    public void setAllProductsToUserWishlist() {
        var user = userRepository.findById(2L).orElseThrow(); //I've deleted User 1, so use 2 instead.
        productRepository.findAll().forEach(user::addProduct);
        userRepository.save(user);
    }
}
