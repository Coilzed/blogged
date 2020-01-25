package com.blogged.pet.controller;

import com.blogged.pet.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public String loginPage() {
        return "common/login";
    }

    @PostMapping("/login")
    public String loginAction() {
        return "blog";
    }
}
