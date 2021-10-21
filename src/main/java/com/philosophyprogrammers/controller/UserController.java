package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap) {
        List<User> users = userService.getAllUsers();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/signup")
    public String showRegistrationForm(User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/signup")
    public String registerUserAccount(@ModelAttribute("user") User user) {

        userService.saveRegisteredUser(user);
        return "redirect:/users";
    }

}
