package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleService;

    @GetMapping()
    public User getUser(Principal principal) {
        return userService.getUserByEmail(principal.getName());
    }
}
