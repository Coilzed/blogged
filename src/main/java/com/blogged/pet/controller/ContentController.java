package com.blogged.pet.controller;

import java.security.Principal;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogged.pet.domain.Account;
import com.blogged.pet.dto.ContentDto;
import com.blogged.pet.service.ContentService;
import com.blogged.pet.service.UserService;

@Controller
public class ContentController {

    private static final Logger LOG = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @ModelAttribute("content")
    public ContentDto contentDto() {
        return new ContentDto();
    }

    @PostMapping("/user/content/create")
    public String createContent
            (@ModelAttribute("content") @Valid ContentDto contentDto, BindingResult result, Principal principal) {
        Account byEmail = userService.findByEmail(principal.getName());
        if (result.hasErrors() || Objects.isNull(contentService.createContent(contentDto, byEmail))) {
            LOG.debug("Content contains errors");
            return "redirect:/user/content/create?fail";
        }
        return "redirect:/user/content/create?success";
    }
}
