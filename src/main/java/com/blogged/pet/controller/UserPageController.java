package com.blogged.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.blogged.pet.service.impl.AccountServiceImpl;

@Controller
public class UserPageController {

    @Autowired
    private AccountServiceImpl service;

    @GetMapping("/user/personal/info")
    public String getPersonalInfoPage() {
        return "user/personal_info_page";
    }

    @GetMapping("/user/content/create")
    public String getPostRedactorPage() {
        return "user/content_create_page";
    }
}
