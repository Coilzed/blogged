package com.blogged.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blogged.pet.domain.Content;
import com.blogged.pet.service.ContentService;

@Controller
public class BlogPageController {

    @Autowired
    private ContentService contentService;

    @GetMapping({"/", "/blog"})
    public String getBlogPage(Model model) {
        Iterable<Content> contentList = contentService.getAllContent();
        model.addAttribute("contentList", contentList);
        return "blog";
    }
}
