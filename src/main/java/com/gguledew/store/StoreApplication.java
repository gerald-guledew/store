package com.gguledew.store;

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
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        System.out.println("Environment Variable DB_USER: "+ user);
        System.out.println("Environment Variable DB_PASSWORD: "+ password);
        System.out.println("Environment Variable db_user: "+ context.getEnvironment().getProperty("db_user"));
//        UserService userService = context.getBean(UserService.class);
//        userService.registerUser(new User(1L, "gerald.g@gmail.com","1234","Gerald"));
//        userService.registerUser(new User(1L, "gerald.g@gmail.com","1234","Gerald"));

    }

}
