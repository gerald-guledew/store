package com.gguledew.store;

import com.gguledew.store.domain.Address;
import com.gguledew.store.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        User user = User.builder().name("Gerald").password("pass").email("g.g@g.com").build();
        Address address = Address.builder().street("streetpart").city("citypart").zip("123").state("hired").build();
        user.addAddresses(address);
        System.out.println(user);

    }

}
