package com.example.bookingshopaiza.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.example.bookingshopaiza.dto.BookFilterDto;
import com.example.bookingshopaiza.entity.Book;
import com.example.bookingshopaiza.repository.BookRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setCatalog(updatedBook.getCatalog());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> filterBooks(BookFilterDto filter) {
        return bookRepository.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getTitle() != null) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
            }
            if (filter.getGenreId() != null) {
                predicates.add(cb.equal(root.get("genre").get("id"), filter.getGenreId()));
            }
            if (filter.getAuthorId() != null) {
                predicates.add(cb.equal(root.get("author").get("id"), filter.getAuthorId()));
            }
            if (filter.getCatalogId() != null) {
                predicates.add(cb.equal(root.get("catalog").get("id"), filter.getCatalogId())); // исправлено
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}