package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Application Controller class for {@link UserEntity}
 * show pages Application
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Controller
@RequestMapping("/account")
public class ApplicationController {

    @GetMapping("/home")
    public String showUsersList(ModelMap modelMap) {
        modelMap.addAttribute("userDTO", new UserDTO());
        return "home";
    }

    @GetMapping("/profile")
    public String showProfileUser() {
        return "accountApp/profile";
    }

}
