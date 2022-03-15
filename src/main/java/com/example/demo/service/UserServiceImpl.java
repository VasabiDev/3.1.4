package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service

public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userDao;
    private final RoleRepository roleDao;

    @Autowired
    public UserServiceImpl(UserRepository userDao, RoleRepository roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);

    }

    public void userAdd(User user) {
        userDao.save(user);
    }


    public void userEdit(User user) {
        userDao.save(user);
    }


    public User getById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public Iterable<User> getAll() {
        return userDao.findAll();

    }

    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }


}
