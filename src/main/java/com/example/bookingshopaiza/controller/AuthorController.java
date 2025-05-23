package com.example.bookingshopaiza.controller;

import com.example.bookingshopaiza.entity.Author;
import com.example.bookingshopaiza.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.save(author);
    }
}