package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomePageController {
    @Autowired
    private  UserService userService;
    // показать главную страницу
    @GetMapping("/")

    public String showHomePage() {
        return "users";
    }

}
