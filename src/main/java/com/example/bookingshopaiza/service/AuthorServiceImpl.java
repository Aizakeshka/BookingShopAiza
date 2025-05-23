package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.entity.Author;
import com.example.bookingshopaiza.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}