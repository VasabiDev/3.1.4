package com.example.demo.service;

import com.example.demo.model.User;


public interface UserService {
    void userAdd(String name, String email, String pass);
    void userEdit(Long id, String name, String email, String pass);
    User getById(Long id);
    void delete(User user);
    Iterable<User> getAll();
}
