package com.gguledew.store;

import com.gguledew.store.domain.User;
import com.gguledew.store.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//        context.close();

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        UserService userService = context.getBean(UserService.class);
//        userService.registerUser(new User(1L, "gerald.g@gmail.com","1234","Gerald"));
//        userService.registerUser(new User(1L, "gerald.g@gmail.com","1234","Gerald"));

    }

}
