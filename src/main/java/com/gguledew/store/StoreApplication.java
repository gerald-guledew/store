package com.gguledew.store;

import com.gguledew.store.domain.*;
import com.gguledew.store.repository.AddressRepository;
import com.gguledew.store.repository.ProfileRepository;
import com.gguledew.store.repository.UserRepository;
import com.gguledew.store.service.AddressService;
import com.gguledew.store.service.CatalogService;
import com.gguledew.store.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.time.LocalDate;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        //===
        //Adding all products to user's wishlist
        var userService = context.getBean(UserService.class);
        userService.setAllProductsToUserWishlist();

        //===
        //Adding new Products and Category
//        var catalogService = context.getBean(CatalogService.class);
//        catalogService.addProduct(); //Create 4 new products and 2 new categories

//        var catalogService = context.getBean(CatalogService.class);
//        catalogService.addProductToAExistingCategory();

        //===
        //Implementation of Delete Related Entities (1708261308)
//        var userService = context.getBean(UserService.class);
//        //userService.deleteRelatedRecord(1L);
//        //userService.populateUsers();
//        userService.deleteAddressOfUser(2L);


        //== Implementation of Persist Related Entities (User<->Address) (1408261122)
//        var userRepository = context.getBean(UserRepository.class);
//        var user = User.builder().name("name2").email("email2").password("password2").build();
//        var address = Address.builder().street("street2").city("city2").zip("zip2").state("state2").build();
//        user.addAddresses(address);
//        userRepository.save(user);

        //=== Implementation of Address Repository
//        var userRepository = context.getBean(UserRepository.class);
//        var addressRepository = context.getBean(AddressRepository.class);
//        var addressService = context.getBean(AddressService.class);
//        var profileRepository = context.getBean(ProfileRepository.class);
//
//        var user = User.builder().name("name1").email("email1").password("password1").build();
//        userRepository.save(user);
//
//        var profile = Profile.builder().bio("bio1").phoneNumber("phonenumber1").dateOfBirth(java.sql.Date.valueOf("1918-05-20")).loyaltyPoints(1L).user(user).build();
//        profileRepository.save(profile);
//
//
//        var address = Address.builder().street("Street 1").city("City 1").zip("1051").state("State 1").build();
//        user.addAddresses(address);
//        addressRepository.save(address);
//        addressService.extractAddress(1L);
//
        //===
        //130826 12:28
//        var entityStateService = context.getBean(EntityStateService.class);
//        entityStateService.showRelatedEntities();
//        var userRepository = context.getBean(UserRepository.class);
//        userRepository.save(User.builder().name("Gerald1").email("g1.g1@g1.com").password("pass1").build());
//        userRepository.save(User.builder().name("Gerald2").email("g2.g2@g2.com").password("pass2").build());
//        userRepository.save(User.builder().name("Gerald3").email("g3.g3@g3.com").password("pass3").build());
//        var user = userRepository.findById(1L).orElseThrow();
//        Profile profile = Profile.builder().id(user.getId()).bio("1st bio").phoneNumber("1st pn").loyaltyPoints(1L).user(user).build();
//        var profileRepo = context.getBean(ProfileRepository.class);
//        var profile = profileRepo.findById(1L).get();

//        if (profileRepo.findById(profile.getId()).isEmpty()) {
//            profileRepo.save(profile);
//        } else {
//            System.out.println("Profile with ID: "+profile.getId()+" already exist.");
//        }
//        System.out.println(profile.getBio());
//        System.out.println("Email from the User: "+profile.getUser().getEmail());
//        var profileService = context.getBean(ProfileService.class);
//        profileService.showRelatedEntities();
        //===
//        var entityStateService = context.getBean(EntityStateService.class);
//        entityStateService.showEntityStates();
//        entityStateService.showRelatedEntities();
        //===
//        var repository = context.getBean(UserRepository.class);
//        repository.deleteById(2L);
        //===
//        repository.findAll().forEach(us -> System.out.println(us.getEmail()));
//        var user = repository.findById(1L).orElseThrow();
//        System.out.println("User Email: " + user.getEmail());

        //===
//        String gname = context.getEnvironment().getProperty("nuser.uname");
//        System.out.println("nuser.uname: "+ gname);
//        var repository = context.getBean(UserRepository.class);
//        User user = User.builder().name("Gerald").email("g.g@g.com").password("pass").build();
//        repository.save(user);
        // ===
////        User user = User.builder().name("Gerald").password("pass").email("g.g@g.com").build();
////
////        String dob = "1985-02-16";
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        Date dateOfBirth = dateFormat.parse(dob);
////        var profile = Profile.builder()
////                        .bio("This is the bio")
////                                .phoneNumber("1234")
////                                        .dateOfBirth(dateOfBirth)
////                                                .loyaltyPoints(2L).build();
////        user.setProfile(profile);
////        profile.setUser(user);
////        System.out.println(user);
//        Category category = Category.builder().name("Category1").build();
//        Product product = Product.builder().name("Product1").price(BigDecimal.valueOf(1234.01)).build();
//        category.getProducts().add(product);
//        System.out.println("Product: " + product);
//        System.out.println("Category: " + category);

    }

}
