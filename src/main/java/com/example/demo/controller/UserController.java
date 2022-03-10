package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    // дофолтное отображение
//    @GetMapping(value = "/")
//    public String welcome() {
//        return "users";
//    }
//

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
   public String userAddProcess(@ModelAttribute("user") @Valid User user) {
       userService.userAdd(user);
       return "redirect:/";
   }
//    @PostMapping("users/add")
//    public String userAddProcess(@RequestParam String firstName, @RequestParam String lastName,
//                                 @RequestParam Byte age ,@RequestParam String email
//            ,@RequestParam String password, @RequestParam ArrayList<Role> role) {
//        userService.userAdd(firstName,lastName,age,email,password,role);
//        return "redirect:/users";
//    }


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
        return "redirect:/";
    }

    // удаление пользователя из базы
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }
}