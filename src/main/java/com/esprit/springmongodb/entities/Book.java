package com.esprit.springmongodb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data //equivalent to getter,setter,RequiredArgsConstructor,ToString,EqualsAndHashCode
@Document
public class Book implements Serializable {

    @Id
    private String id;
    private String title;
    private String author;
    private List<Review> reviews;







    /**
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
    }
    public Book(String title, String author,List<Review> reviews) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
    }
     **/
}
