package com.blogged.pet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/admin/manager/account")
    public String getAccountManagerPage() {
        return "admin/account_manager";
    }

    @GetMapping("/admin/manager/content")
    public String getContentManagerPage() {
        return "admin/content_manager";
    }

}
