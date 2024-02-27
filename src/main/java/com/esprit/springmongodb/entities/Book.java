package com.esprit.springmongodb.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data //equivalent to getter,setter,@RequiredArgsConstructor,ToString,EqualsAndHashCode
@Document
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private List<Review> reviews;

}
