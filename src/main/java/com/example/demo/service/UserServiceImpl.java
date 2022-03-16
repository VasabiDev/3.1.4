package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userDao;
    private final RoleRepository roleDao;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userDao, RoleRepository roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);

    }

    public User userAdd(User user) {
        userDao.save(encodePass(user));
        return user;
    }


    public User userEdit(User user) {
        userDao.save(user);
        return user;
    }


    public User getById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public List<User> getAll() {
        return userDao.findAll();

    }

    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User encodePass(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

}
