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
//
//    {
//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role("ADMIN"));
//        User user1 = new User();
//        user1.setFirstName("TEST_USER-FROM_CODE");
//        user1.setLastName("last");
//        user1.setAge((byte) 32);
//        user1.setEmail("email");
//        user1.setPassword("dsfgdfgdfgdfg");
//        user1.setRoles(roles);
//        userAdd(user1);
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findByEmail(email);

    }

    public void userAdd(User user) {
        userDao.save(user);
    }


    public void userEdit(User user) {
        User newUser = getById(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        // newUser.setAuthorities((List<Role>) user.getAuthorities());
        userDao.save(newUser);
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
    public User getUserByEmail(String email){
        return userDao.findByEmail(email);
    }


}
