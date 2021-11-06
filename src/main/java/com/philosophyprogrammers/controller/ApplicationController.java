package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Application Controller class for {@link UserEntity}
 * show pages Application
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Controller
public class ApplicationController {

    @GetMapping("/account/home")
    public String showUsersList(ModelMap modelMap) {
        modelMap.addAttribute("userDTO", new UserDTO());
        return "home";
    }

    @GetMapping("/account/profile")
    public String showProfileUser() {
        return "accountApp/profile";
    }

}
