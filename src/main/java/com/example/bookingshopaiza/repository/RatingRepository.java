package com.example.bookingshopaiza.repository;

import com.example.bookingshopaiza.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByUserIdAndBookId(Long userId, Long bookId);
    List<Rating> findAllByBookId(Long bookId);
}
