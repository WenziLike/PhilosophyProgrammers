package com.philosophyprogrammers.controller;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.service.users.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Register Controller class for {@link UserEntity}
 * <p>
 * Validate incoming data.
 * Show an error message on front-end (if any).
 * Call user service for registration.
 * Show error in we find a duplicate user or any other issue while saving the user profile.
 *
 * @author Viacheslav Murakhin
 * @version 1.0
 */

@Controller
public class RegisterAndLoginController {

    private UserServiceImpl userServiceImpl;
    private static final String REDIRECT_LOGIN = "redirect:/login";


    public RegisterAndLoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Registration Users
     */

    @GetMapping("/registration")
    public String showFormRegistrationUser(ModelMap modelMap) {
        modelMap.addAttribute("userDTO", new UserDTO());
        return "accountApp/registration";
    }

    @GetMapping("/login")
    public String showFormLogin(ModelMap modelMap) {
        modelMap.addAttribute("userDTO", new UserDTO());
        return "accountApp/login";
    }

    @PostMapping("/registration")
    public String userRegistration(@Valid UserDTO userDTO, BindingResult bindingResult, ModelMap modelMap) {

        if (userDTO.getPassword() != null && !userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            bindingResult.rejectValue("password", "password", "Passwords are different!");
            modelMap.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }

        try {
            userServiceImpl.register(userDTO);
        } catch (UserAlreadyExistException e) {

            // Duplicate User Error
            bindingResult.rejectValue("email", "email", "An account already exists for this email.");
            modelMap.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }
        return REDIRECT_LOGIN;
    }
}
