package com.blogged.pet.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogged.pet.domain.Account;
import com.blogged.pet.dto.AccountRegistrationDto;
import com.blogged.pet.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService accountService;

    @ModelAttribute("account")
    public AccountRegistrationDto accountRegistrationDto() {
        return new AccountRegistrationDto();
    }

    @GetMapping
    public String getRegistrationPage() {
        return "common/register";
    }

    @PostMapping
    public String registerUserAccount
            (@ModelAttribute("user") @Valid AccountRegistrationDto userDto, BindingResult result) {
        Account account = accountService.findByEmail(userDto.getEmail());
        if (account != null) {
            LOG.debug("User already exists");
            return "redirect:/register?exists";
        }
        if (result.hasErrors() || Objects.isNull(accountService.createAccount(userDto))) {
            LOG.debug("Account contains mistakes: " + result);
            return "redirect:/register?invalidcredentials";
        }
        LOG.debug("Registration success");
        return "redirect:/login?success";
    }
}
