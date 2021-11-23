package com.philosophyprogrammers.controllers;

import com.philosophyprogrammers.dto.ResetPasswordDTO;
import com.philosophyprogrammers.dto.UserDTO;
import com.philosophyprogrammers.service.account.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    public static final String LAST_USERNAME_KEY = "LAST_USERNAME";

    @Resource(name = "accountService")
    private final AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String login(@RequestParam(value = "error",defaultValue = "false")boolean loginError,
                        @RequestParam(value = "invalid-session", defaultValue = "false") boolean invalidSession,
                         Model model, HttpSession session) {
//
        String userName = getUserName(session);
        if (loginError) {
            if (StringUtils.isNotEmpty(userName) && accountService.loginDisabled(userName)) {
                model.addAttribute("accountLocked", Boolean.TRUE);
                model.addAttribute("forgotPassword", new ResetPasswordDTO());
                model.addAttribute("formLogin", new UserDTO());
                return "accountApp/login";
            }
        }
        if (invalidSession) {
            model.addAttribute("invalidSession", "You already have an active session. We do not allow multiple active sessions");
        }
        model.addAttribute("forgotPassword", new ResetPasswordDTO());
        model.addAttribute("accountLocked", Boolean.FALSE);
        model.addAttribute("formLogin", new UserDTO());
        return "accountApp/login";
    }


    final String getUserName(HttpSession session) {
        final String username = (String) session.getAttribute(LAST_USERNAME_KEY);
        if (StringUtils.isNotEmpty(username)) {
            session.removeAttribute(LAST_USERNAME_KEY); // we don't need it and removing it.
        }
        return username;
    }
}
