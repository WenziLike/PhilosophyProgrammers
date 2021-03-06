package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showFormLogin(ModelMap modelMap) {
        modelMap.addAttribute("formLogin", new UserDTO());
        return "accountApp/login";
    }
}
