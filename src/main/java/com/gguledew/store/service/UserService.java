package com.gguledew.store.service;

import com.gguledew.store.domain.Address;
import com.gguledew.store.domain.Profile;
import com.gguledew.store.domain.User;
import com.gguledew.store.repository.AddressRepository;
import com.gguledew.store.repository.ProductRepository;
import com.gguledew.store.repository.ProfileRepository;
import com.gguledew.store.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final ProfileRepository profileRepository;

    public UserService(UserRepository userRepository, NotificationService notificationService, AddressRepository addressRepository, ProductRepository productRepository,
                       ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.profileRepository = profileRepository;
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

    @Transactional
    public void fetchUserAndTagsByEmail(String email) {
        var user = userRepository.findUserAndTagByEmail(email).orElseThrow();
        System.out.println(user.getId());
    }

    @Transactional
    public void fetchAllUsersWithAddresses() {
        var user = userRepository.findAllWithAddresses();
        user.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(IO::println);
        });
    }

    @Transactional
    public void fetchProductsByPrice() {
        var products = productRepository.findProductByPrice(BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        products.forEach(IO::println);
    }

    @Transactional
    public void populateUserAndProfile() {
        var user = User.builder().name("name10").email("email10").password("password10").build();
        userRepository.save(user);
        var profile = Profile.builder().bio("bio10").phoneNumber("PN10").dateOfBirth(java.sql.Date.valueOf("1903-02-16")).loyaltyPoints(1L).user(user).build();
        profileRepository.save(profile);
//        user = User.builder().name("name8").email("email8").password("password8").build();
//        userRepository.save(user);
//        profile = Profile.builder().bio("bio8").phoneNumber("PN8").dateOfBirth(java.sql.Date.valueOf("1901-02-16")).loyaltyPoints(10L).user(user).build();
//        profileRepository.save(profile);
//        user = User.builder().name("name9").email("email9").password("password9").build();
//        userRepository.save(user);
//        profile = Profile.builder().bio("bio9").phoneNumber("PN9").dateOfBirth(java.sql.Date.valueOf("1902-02-16")).loyaltyPoints(20L).user(user).build();
//        profileRepository.save(profile);
    }

    public void fetchUserProfilesByLoyaltyPoints() {
        var userProfiles = profileRepository.findProfilesByLoyaltyPointsGreaterThanOrderByUserEmailDesc(2L);
        userProfiles.forEach(p -> System.out.println("PROFILE ID: "+p.getId()+", USER EMAIL: "+p.getUser().getEmail()));
    }

    public void fetchUserSummaryByLoyaltyPoints() {
        var userSummary = profileRepository.findByLoyaltyPoints(2L);
        userSummary.forEach(u -> IO.println("P_ID: "+u.getId()+", UEMAIL: "+u.getEmail()));
    }
}
