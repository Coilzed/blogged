package com.blogged.pet.controller;

import java.security.Principal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogged.pet.dto.PersonalInfoDto;
import com.blogged.pet.service.UserService;

@Controller
public class PersonalInfoController {

    @Autowired
    private UserService userService;

    @ModelAttribute("info")
    public PersonalInfoDto personalInfoDto() {
        return new PersonalInfoDto();
    }

    @PostMapping("/user/personal/info")
    public String changeUserInfo(@ModelAttribute("info") PersonalInfoDto personalInfoDto, Principal principal) {
        if (Objects.nonNull(userService.changeUserInfo(personalInfoDto, principal.getName()))) {
            return "redirect:/user/personal/info?success";
        }
        return "/user/personal/info";
    }
}
