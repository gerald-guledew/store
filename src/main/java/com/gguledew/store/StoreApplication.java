package com.gguledew.store;

import com.gguledew.store.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.text.ParseException;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(StoreApplication.class, args);
    }

}
