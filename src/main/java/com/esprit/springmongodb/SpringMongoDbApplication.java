package com.esprit.springmongodb;

import com.esprit.springmongodb.entities.Book;
import com.esprit.springmongodb.entities.Review;
import com.esprit.springmongodb.enums.Rating;
import com.esprit.springmongodb.repositories.BookRepository;
import com.esprit.springmongodb.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ReviewRepository reviewRepository){
		return args -> {
			Book book = new Book(
					"Prisoner of Azkaban",
					"J. K. Rowling"
			);
		 Review review1 = new Review(
				 "wow",
				 Rating.GOOD,
				 book
		 )	;
			Review review2 = new Review(
					"Beep",
					Rating.EXCELLENT,
					book
					)	;



		 reviewRepository.insert(review1);
		 reviewRepository.insert(review2);
		};

	}

}
