package com.gguledew.store;

import com.gguledew.store.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) throws ParseException {
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        User user = User.builder().name("Gerald").password("pass").email("g.g@g.com").build();
//
//        String dob = "1985-02-16";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateOfBirth = dateFormat.parse(dob);
//        var profile = Profile.builder()
//                        .bio("This is the bio")
//                                .phoneNumber("1234")
//                                        .dateOfBirth(dateOfBirth)
//                                                .loyaltyPoints(2L).build();
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user);
        Category category = Category.builder().name("Category1").build();
        Product product = Product.builder().name("Product1").price(BigDecimal.valueOf(1234.01)).build();
        category.addProduct(product);
        System.out.println("Product: " + product);
        System.out.println("Category: " + category);

    }

}
