package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


public interface UserService {
    User userAdd(User user);

    User userEdit(User user);

    UserDetails loadUserByUsername(String email);

    User getById(Long id);

    void delete(User user);

    List<User> getAll();

    User getUserByEmail(String email);

    User encodePass(User user);
}
