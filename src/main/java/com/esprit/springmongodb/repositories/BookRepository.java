package com.esprit.springmongodb.repositories;

import com.esprit.springmongodb.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
}
