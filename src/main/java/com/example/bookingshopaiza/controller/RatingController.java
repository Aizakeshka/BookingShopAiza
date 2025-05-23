package com.example.bookingshopaiza.controller;

import com.example.bookingshopaiza.service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/rate")
    public void rateBook(@RequestParam Long userId,
                         @RequestParam Long bookId,
                         @RequestParam int score) {
        ratingService.rateBook(userId, bookId, score);
    }

    @GetMapping("/average")
    public double getAverage(@RequestParam Long bookId) {
        return ratingService.getAverageRating(bookId);
    }
}
