package com.example.bookingshopaiza.controller;

import com.example.bookingshopaiza.dto.BookFilterDto;
import com.example.bookingshopaiza.entity.Author;
import com.example.bookingshopaiza.entity.Book;
import com.example.bookingshopaiza.entity.Catalog;
import com.example.bookingshopaiza.entity.Genre;
import com.example.bookingshopaiza.service.AuthorService;
import com.example.bookingshopaiza.service.BookService;
import com.example.bookingshopaiza.service.CatalogService;
import com.example.bookingshopaiza.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CatalogService catalogService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, CatalogService catalogService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.catalogService = catalogService;
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/filter")
    public List<Book> filterBooks(@RequestBody BookFilterDto filter) {
        return bookService.filterBooks(filter);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Book create(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("year") int year,
            @RequestParam("pageCount") int pageCount,
            @RequestParam("author") Long authorId,
            @RequestParam("genre") Long genreId,
            @RequestParam("catalog") Long catalogId
    ) throws IOException {
        Author author = authorService.findById(authorId);
        Genre  genre  = genreService.findById(genreId);
        Catalog catalog = catalogService.findById(catalogId);

        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setYear(year);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setCatalog(catalog);

        return bookService.save(book);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Book update(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("year") int year,
            @RequestParam("pageCount") int pageCount,
            @RequestParam("author") Long authorId,
            @RequestParam("genre") Long genreId,
            @RequestParam("catalog") Long catalogId
    ) throws IOException {
        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            throw new RuntimeException("Book not found with id " + id);
        }

        Author author   = authorService.findById(authorId);
        Genre  genre    = genreService.findById(genreId);
        Catalog catalog = catalogService.findById(catalogId);

        existingBook.setTitle(title);
        existingBook.setDescription(description);
        existingBook.setYear(year);
        existingBook.setAuthor(author);
        existingBook.setGenre(genre);
        existingBook.setCatalog(catalog);

        return bookService.save(existingBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}