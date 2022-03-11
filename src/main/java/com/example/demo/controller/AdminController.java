package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleService;

    // показать всех пользователей
    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());

        return "users";
    }

    // вызвать форму добавления пользователя
    @GetMapping("/users/add")
    public String createUserForm(@ModelAttribute("user") @Valid User user, Model model) {
        model.addAttribute("user", new User());
        return "createUserForm";
    }

    // добавить пользователя в базу из формы
    @PostMapping("/users/add")
    public String userAddProcess(@ModelAttribute("user") @Valid User user,
                                 @RequestParam(name = "role", required = false) String[] roles) {
        List<Role> roleList = new ArrayList<>();
        for(String stringRoles: roles){
            roleList.add(roleService.findByName(stringRoles));
        }
        user.setRoles(roleList);
        userService.userAdd(user);
        return "redirect:/admin/";
    }


    // вызвать форму редактирования пользователя
    @GetMapping("users/edit/{id}")
    public String showUserEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    // обработать данные из формы редактирования пользователя
    @PostMapping("users/edit/{id}")
    public String userEditProcess(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userService.userEdit(user);
        return "redirect:/admin/";
    }

    // удаление пользователя из базы
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin/";
    }
}