package com.__1.demo.controllers;

import com.__1.demo.model.Book;
import com.__1.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.List;

@Controller
public class BookController {


    BookRepository bookRepository;

    BookController(BookRepository br) {
        bookRepository = br;
    }

    // get a  list of Books
    @GetMapping(path = "/books")
    public String getListBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
