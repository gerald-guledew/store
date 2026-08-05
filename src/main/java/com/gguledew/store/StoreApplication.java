package com.gguledew.store;

import com.gguledew.store.domain.Address;
import com.gguledew.store.domain.Tag;
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
        Tag tag = new Tag("Tag1");
        user.getTags().add(tag);
        tag.getUsers().add(user);
        System.out.println(user);

    }

}
