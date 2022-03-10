package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userDao;


    @Autowired
    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByName(name);

    }
    public void userAdd(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPass(password);
    //    authorities.add(role);
       userDao.save(user);
    }

    public void userEdit(Long id, String name, String email, String password) {
        User user = getById(id);
        user.setName(name);
        user.setEmail(email);
        user.setPass(password);
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

//    public void addRoleToUser(String username, String roleName) {
//        User user = userDao.findByName(username);
//        Role role = userDao.findByName(roleName);
//        Collection<Role> roles = user.getRoles();
//        if(!roles.contains(role)) {
//            user.get().add(role);
//        }
//    }

}
