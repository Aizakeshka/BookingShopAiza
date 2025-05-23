package com.example.bookingshopaiza.service;


import com.example.bookingshopaiza.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author save(Author author);
    Author findByName(String name);
    Author findById(Long id);
}