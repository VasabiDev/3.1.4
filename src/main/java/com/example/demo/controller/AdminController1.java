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
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController1 {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleService;

    @GetMapping("")
    public String showUserList(Model model,
                               @ModelAttribute("user") User user, Principal principal) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userThis", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("userDB", user);
        return "users";
    }


    @PostMapping("")
    public String userAddProcess(@ModelAttribute("user") @Valid User user,
                                 @RequestParam(name = "role", required = false) String[] roles) {
        List<Role> roleList = new ArrayList<>();
        for (String stringRoles : roles) {
            roleList.add(roleService.findByName(stringRoles));
        }
        userService.userAdd(user);
        return "redirect:/admin";
    }

    // вызвать форму добавления пользователя
    @GetMapping("/users/add")
    public String createUserForm(@ModelAttribute("user") @Valid User user, Model model) {
        model.addAttribute("userNew", new User());

        return "createUserForm";
    }


    // вызвать форму редактирования пользователя
    @GetMapping("users/edit/{id}")
    public String showUserEditForm(@PathVariable("id") Long id, Model model, Principal principal) {

        User user = userService.getById(id);
        model.addAttribute("userThis", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("userDB", user);
        return "editUser";
    }

    // обработать данные из формы редактирования пользователя
    @PostMapping("users/edit/{id}")
    public String userEditProcess(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userService.userEdit(user);
        return "redirect:/";
    }

    // удаление пользователя из базы
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin";
    }
}