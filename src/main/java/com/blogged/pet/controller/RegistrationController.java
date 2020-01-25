package com.blogged.pet.controller;

import com.blogged.pet.domain.User;
import com.blogged.pet.dto.UserRegistrationDto;
import com.blogged.pet.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "user/register";
    }

    @PostMapping
    public String registerUserAccount
            (@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            LOG.debug("User already exists");
            result.rejectValue("email", "409", "Email is registered already");
        }
        if (result.hasErrors()) {
            LOG.debug("Account contains mistakes: " + result);
            return "user/register";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }
}
