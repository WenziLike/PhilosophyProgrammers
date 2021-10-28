package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.entity.User;
import com.philosophyprogrammers.service.users.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterAndLoginController {

    private UserServiceImpl userServiceImpl;

    public RegisterAndLoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * ================ Create New User Register
     */
    @GetMapping("/signup")
    public String showRegistrationForm(User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/signup")
    public String createdNewUser(
            @PathVariable(value = "id") long id,
            @ModelAttribute("user") User user) {
        user.setActive(true);
        userServiceImpl.createdNewUser(user);
        return "profile-user";
    }

    /**
     * ================ Login
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

}
