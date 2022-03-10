package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {



User user1 = new User();
user1.setFirstName("first");
            user1.setLastName("last");
            user1.setAge((byte)32);
            user1.setEmail("email");
            user1.setPassword("dsfgdfgdfgdfg");
            user1.setRoles(new ArrayList<>());
                userService.userAdd(user1);


           //   userService.addRoleToUser("ivan","ROLE_USER");
            //    userService.addRoleToUser("polina","ROLE_ADMIN");

        };
    }

}
