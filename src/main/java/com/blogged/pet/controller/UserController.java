package com.blogged.pet.controller;

import com.blogged.pet.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/user")
    public String index() {
        return "index";
    }
}
