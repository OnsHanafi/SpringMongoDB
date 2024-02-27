package com.esprit.springmongodb.services;

import com.esprit.springmongodb.entities.Review;
import com.esprit.springmongodb.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    /**
     * Internal logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReviewService.class);
    private  static  final String ERROR_NULL_ID = "ID is NULL";
    private static final String ERROR_NON_PRESENT_ID = " cannot find a review with id : %s";
    private static final String ERROR_UPDATE= "Error occured while updating";

    private final ReviewRepository reviewRepository;

    public Review save(Review review){
        return this.reviewRepository.save(review);
    }
    public Review findReviewById(String id){
        Review review = null;
        if(id != null){
            final Optional<Review> optionalReview = this.reviewRepository.findById(id);
            if(optionalReview.isPresent()){
                review = optionalReview.get();
            }else {
                LOG.info(String.format(ERROR_NON_PRESENT_ID,id));
            }
        }else {
            LOG.error(ERROR_NULL_ID);
        }
        return review;
    }

    public List<Review> findAll(){
        return this.reviewRepository.findAll();
    }

    public Review updateRoom(Review book) {
        Review updatedBook = null;
        if(book != null){
            updatedBook = this.reviewRepository.save(book);
        }else {
            LOG.error(ERROR_UPDATE);
        }
        return  updatedBook;
    }


    public void delete(String id){
        Review book = null;
        if(id != null){
            book = findReviewById(id);
            if(book != null){
                this.reviewRepository.deleteById(id);
            }else {
                LOG.info(String.format(ERROR_NON_PRESENT_ID,id));
            }
        }else {
            LOG.error(ERROR_NULL_ID);
        }

    }

}
