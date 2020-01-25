package com.blogged.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String loginPage() {
        return "admin/admin";
    }

    @PostMapping("/admin")
    public String accessAfterLogin() {
        return "admin/admin";
    }

}
