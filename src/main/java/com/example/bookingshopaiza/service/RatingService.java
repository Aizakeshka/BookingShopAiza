package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.entity.Book;
import com.example.bookingshopaiza.entity.Rating;
import com.example.bookingshopaiza.entity.User;
import com.example.bookingshopaiza.repository.BookRepository;
import com.example.bookingshopaiza.repository.RatingRepository;
import com.example.bookingshopaiza.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void rateBook(Long userId, Long bookId, int score) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Rating rating = ratingRepository.findByUserIdAndBookId(userId, bookId)
                .orElse(new Rating());

        rating.setUser(user);
        rating.setBook(book);
        rating.setScore(score);
        ratingRepository.save(rating);
    }

    public double getAverageRating(Long bookId) {
        List<Rating> ratings = ratingRepository.findAllByBookId(bookId);
        return ratings.stream().mapToInt(Rating::getScore).average().orElse(0.0);
    }
}