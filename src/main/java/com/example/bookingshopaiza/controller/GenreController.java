package com.example.bookingshopaiza.controller;

import com.example.bookingshopaiza.entity.Genre;
import com.example.bookingshopaiza.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAll() {
        return genreService.findAll();
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreService.save(genre);
    }
}