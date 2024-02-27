package com.esprit.springmongodb.entities;

import com.esprit.springmongodb.enums.Rating;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Review {

    @Id
    private String id;
    private String content;
    private Rating rating;
    private Book book;

    public Review(String content, Rating rating,Book book) {
        this.content = content;
        this.rating = rating;
        this.book = book;
    }
}
