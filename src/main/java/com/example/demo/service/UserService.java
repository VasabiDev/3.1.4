package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.ArrayList;


public interface UserService {
    void userAdd(User user);

    void userEdit(User user);

    User getById(Long id);

    void delete(User user);

    Iterable<User> getAll();

    User getUserByEmail(String email);
}
