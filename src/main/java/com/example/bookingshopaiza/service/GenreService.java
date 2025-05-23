package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    Genre save(Genre genre);
    Genre findById(Long id);
}