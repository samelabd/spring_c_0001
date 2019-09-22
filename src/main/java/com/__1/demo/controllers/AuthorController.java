package com.__1.demo.controllers;

import com.__1.demo.repositories.AuthorRepository;
import com.sun.java.swing.plaf.motif.resources.motif_de;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getListAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "/authors";
    }
}
