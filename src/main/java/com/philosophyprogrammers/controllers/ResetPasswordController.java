package com.philosophyprogrammers.controllers;

import com.philosophyprogrammers.dto.ResetPasswordDTO;
import com.philosophyprogrammers.exceptions.InvalidTokenException;
import com.philosophyprogrammers.exceptions.UnknownIdentifierException;
import com.philosophyprogrammers.service.account.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/password")
public class ResetPasswordController {

    private static final String REDIRECT_LOGIN = "redirect:/login";
    private static final String MSG = "resetPasswordMsg";

    private final MessageSource messageSource;
    private final AccountService accountService;

    public ResetPasswordController(MessageSource messageSource, AccountService accountService) {
        this.messageSource = messageSource;
        this.accountService = accountService;
    }

    @GetMapping("/request")
    public String resetPassword(ResetPasswordDTO forgotPasswordForm,
                                RedirectAttributes redirectAttributes) {
        try {
            accountService.forgottenPassword(forgotPasswordForm.getEmail());
        } catch (UnknownIdentifierException e) {
            // the errors
        }

        redirectAttributes.addFlashAttribute(MSG,
                messageSource.getMessage("user.forgotPwd.msg", null, LocaleContextHolder.getLocale()));
        return REDIRECT_LOGIN;
    }

    @GetMapping("/change")
    public String changePassword(@RequestParam(required = false) String token,
                                 RedirectAttributes redirectAttributes, Model model) {
        if (StringUtils.isEmpty(token)) {
            redirectAttributes.addFlashAttribute("tokenError",
                    messageSource.getMessage("user.registration.verification.missing.token", null, LocaleContextHolder.getLocale())
            );
            return REDIRECT_LOGIN;
        }

        ResetPasswordDTO dto = new ResetPasswordDTO();
        dto.setToken(token);
        setResetPasswordForm(model, dto);

        return "accountApp/changePassword";
    }

    @PostMapping("/change")
    public String changePassword(ResetPasswordDTO dto, Model model) {
        try {
            accountService.updatePassword(dto.getPassword(), dto.getToken());
        } catch (InvalidTokenException | UnknownIdentifierException e) {
            // log error statement
            model.addAttribute("tokenError",
                    messageSource.getMessage("user.registration.verification.invalid.token", null, LocaleContextHolder.getLocale())
            );

            return "accountApp/changePassword";
        }
        model.addAttribute("passwordUpdateMsg",
                messageSource.getMessage("user.password.updated.msg", null, LocaleContextHolder.getLocale())
        );
        setResetPasswordForm(model, new ResetPasswordDTO());
        return "accountApp/changePassword";
    }

    private void setResetPasswordForm(Model model, ResetPasswordDTO dto) {
        model.addAttribute("forgotPassword", dto);
    }
}
