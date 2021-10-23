package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap) {
        List<User> users = userServiceImpl.getAll();
        modelMap.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/signup")
    public String showRegistrationForm(User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/signup")
    public String createdNewUser(@ModelAttribute("user") User user) {

        userServiceImpl.createdNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditForm(User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String updateUser( @ModelAttribute("user") User user) {
        userServiceImpl.editUser(user);
        return "redirect:/users";
    }
}
