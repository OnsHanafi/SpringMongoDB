package com.esprit.springmongodb.entities;

import com.esprit.springmongodb.enums.Rating;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
public class Review implements Serializable {

    @Id
    private String id;
    private String content;
    private Rating rating;
    @JsonIgnore
    private Book book;







    /**
    public Review(String content, Rating rating) {
        this.content = content;
        this.rating = rating;
        this.book = book;
    }
    public Review(String content, Rating rating,Book book) {
        this.content = content;
        this.rating = rating;
        this.book = book;
    }
     **/
}
