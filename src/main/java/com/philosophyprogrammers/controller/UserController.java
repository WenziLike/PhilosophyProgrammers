package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        Optional<User> user = userServiceImpl.findById(id);

        modelMap.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(
            @PathVariable(value = "id") long id,
            @ModelAttribute("user") User user,ModelMap modelMap) {
        User userFromDb = userServiceImpl.findById(id).orElseThrow();

        userFromDb.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());

        userServiceImpl.createdNewUser(user);

//        userServiceImpl.editUser(user);
        return "redirect:/users";
    }
}
