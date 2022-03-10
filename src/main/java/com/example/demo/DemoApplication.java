package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            if(userService.getUsers().size() == 0) {
//                userService.saveRole(new Role(null, "USER"));
//                userService.saveRole(new Role(null, "ADMIN"));
//User user = new User("name","passs",new ArrayList<>());
//                userService.userAdd());
//                userService.userAdd(new User("Polina","polina","1234", "123123@yandex.ru", new ArrayList<>()));
//                userService.userAdd(new User("Andrei","andrei","1234", "123123@yandex.ru", new ArrayList<>()));
//
//                userService.addRoleToUser("ivan","ROLE_USER");
//                userService.addRoleToUser("polina","ROLE_ADMIN");
//            }
//        };
//    }

}
