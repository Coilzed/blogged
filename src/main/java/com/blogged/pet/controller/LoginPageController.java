package com.blogged.pet.controller;


import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication) {
        return Objects.isNull(authentication) ? "common/login" : "redirect:/";
    }

}
