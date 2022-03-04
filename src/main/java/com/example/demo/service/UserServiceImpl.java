package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userDao;

    @Autowired
    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }

    public void userAdd(String name, String email, String pass) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPass(pass);
        userDao.save(user);
    }

    public void userEdit(int id, String name, String email, String pass) {
        User user = getById(id);
        user.setName(name);
        user.setEmail(email);
        user.setPass(pass);
        userDao.save(user);
    }


    public User getById(int id) {
        return userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public Iterable<User> getAll() {
        return userDao.findAll();
    }

}
