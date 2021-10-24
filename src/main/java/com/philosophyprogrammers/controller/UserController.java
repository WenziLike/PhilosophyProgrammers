package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.service.users.UserServiceImpl;
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

    @GetMapping("/edit/user/{id}")
    public String showUpdateFormUser(
            @PathVariable("id") long id,
            ModelMap modelMap) {
        User user = userServiceImpl.findById(id)
                .orElseThrow();

        modelMap.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit/user/{id}")
    public String updateUser(
            @PathVariable(value = "id") long id,
            @ModelAttribute("user")
            User user) {
        User userFromDb = userServiceImpl.findById(id).orElseThrow();

        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());

//        userServiceImpl.editUser(user);
        userServiceImpl.createdNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userServiceImpl.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        userServiceImpl.deleteUser(user);
        return "redirect:/users";
    }
}
