package com.philosophyprogrammers.controllers;

import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.entity.UserEntity;
import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UserAlreadyExistException;
import com.philosophyprogrammers.service.users.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping("/register")
public class RegisterController {

    private static final String REDIRECT_LOGIN = "redirect:/login";

    private final UserService userService;
    private final MessageSource messageSource;

    public RegisterController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public String showFormRegisterUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "accountApp/registration";
    }

    @PostMapping
    public String userRegister(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {

        if (userDTO.getPassword() != null && !userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            bindingResult.rejectValue("password", "password", "Passwords are different!");
            model.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }

        try {
            userService.register(userDTO);
        } catch (UserAlreadyExistException e) {

            // Duplicate User Error
            bindingResult.rejectValue("email", "email", "An account already exists for this email.");
            model.addAttribute("userDTO", userDTO);
            return "accountApp/registration";
        }
        model.addAttribute("registrationMsg", messageSource.getMessage("user.registration.verification.email.msg", null, LocaleContextHolder.getLocale()));
        return "accountApp/registration";
    }

    @GetMapping("/verify")
    public String verifyAccountUser(@RequestParam(required = false) String token, Model model, RedirectAttributes redirectAttributes) {
        if (StringUtils.isEmpty(token)) {
            redirectAttributes.addFlashAttribute("tokenError", messageSource.getMessage("user.registration.verification.missing.token", null, LocaleContextHolder.getLocale()));
            return REDIRECT_LOGIN;
        }
        try {
            userService.verifyUser(token);
        } catch (InvalidTokenException e) {
            redirectAttributes.addFlashAttribute("tokenError", messageSource.getMessage("user.registration.verification.invalid.token", null, LocaleContextHolder.getLocale()));
            return REDIRECT_LOGIN;
        }
        redirectAttributes.addFlashAttribute("verifiedAccountMsg", messageSource.getMessage("user.registration.verification.success", null, LocaleContextHolder.getLocale()));
        return REDIRECT_LOGIN;
    }
}
