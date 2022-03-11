package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleRepository roleService;

    @Autowired
    public UserController(UserService userService, RoleRepository roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String index(Model model, User user) {
        model.addAttribute("user", userService.getUserByEmail(user.getEmail()));
        model.addAttribute("roles", roleService.findAll());
        return "profile";
    }
}


