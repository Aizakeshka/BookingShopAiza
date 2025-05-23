package com.example.bookingshopaiza.service;


import com.example.bookingshopaiza.dto.BookFilterDto;
import com.example.bookingshopaiza.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book save(Book book);
    Book update(Long id, Book book);
    void delete(Long id);
    List<Book> filterBooks(BookFilterDto filter);
    Book findById(Long id);
}