package com.esprit.springmongodb.controllers;

import com.esprit.springmongodb.entities.Book;
import com.esprit.springmongodb.entities.Review;
import com.esprit.springmongodb.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    @Autowired
    private final ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody Review review){
        return this.reviewService.save(review);
    }
    @GetMapping
    public List<Review> findAllReviews(){
        return this.reviewService.findAll();
    }

    @GetMapping("/{review-id}")
    public Review findReviewById(@PathVariable("review-id") String id ){
        return id != null ? this.reviewService.findReviewById(id) : null ;
    }

    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review review) {
        return review != null ? this.reviewService.updateReview(review) : null;
    }

    @DeleteMapping("/delete/{review-id}")
    public void deleteReview(@PathVariable("review-id") String id ){
         this.reviewService.deleteReview(id) ;

    }


}
