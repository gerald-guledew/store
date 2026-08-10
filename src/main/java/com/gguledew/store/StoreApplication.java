package com.gguledew.store;

import com.gguledew.store.domain.*;
import com.gguledew.store.repository.ProfileRepository;
import com.gguledew.store.repository.UserRepository;
import com.gguledew.store.service.EntityStateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userRepository = context.getBean(UserRepository.class);
        var user = userRepository.findById(1L).orElseThrow();
        Profile profile = Profile.builder().bio("1st bio").phoneNumber("1st pn").loyaltyPoints(1L).user(user).build();
        var profileRepo = context.getBean(ProfileRepository.class);
        profileRepo.save(profile);
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
