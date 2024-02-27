package com.esprit.springmongodb.repositories;

import com.esprit.springmongodb.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review,String> {

}
