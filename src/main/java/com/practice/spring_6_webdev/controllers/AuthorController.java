package com.practice.spring_6_webdev.controllers;

import com.practice.spring_6_webdev.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;



    public AuthorController(AuthorService authorService1 ) {
        this.authorService = authorService1 ;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }
}
