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

	/**
	@Bean

	public CommandLineRunner runner(BookRepository bookRepository){
		return args -> {

		 Review review1 = new Review(
				 "wow",
				 Rating.GOOD
		 )	;
			Review review2 = new Review(
					"Beep",
					Rating.EXCELLENT
					)	;

			Book book = new Book(
					"Prisoner of Azkaban",
					"J. K. Rowling",
					List.of(review1,review2)
			);

			bookRepository.insert(book);

		// reviewRepository.insert(review1);
		// reviewRepository.insert(review2);
		};

	}
	 **/

}
