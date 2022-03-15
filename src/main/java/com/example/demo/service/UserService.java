package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;


public interface UserService {
    void userAdd(User user);

    void userEdit(User user);

    UserDetails loadUserByUsername(String email);

    User getById(Long id);

    void delete(User user);

    Iterable<User> getAll();

    User getUserByEmail(String email);
}
