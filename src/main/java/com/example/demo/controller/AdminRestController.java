package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public List<User> showAllUsers() {
        return (List<User>) userService.getAll();
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        userService.userAdd(user);
        return user;
    }

    @PutMapping("/edit/{id}")
    public User editUser(@RequestBody User user) {
        userService.userAdd(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(userService.getById(id));
        return "User with id: " + id + " was deleted";
    }
}

