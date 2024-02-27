package com.esprit.springmongodb.controllers;

import com.esprit.springmongodb.entities.Book;
import com.esprit.springmongodb.entities.Review;
import com.esprit.springmongodb.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //used instead of the combination of @Controller and @ResponseBody
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return this.bookService.save(book);
    }
    @GetMapping
    public List<Book> findAllBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/delete/{book-id}")
    public Book findBookById(@PathVariable("book-id") String id ){
        return id != null ? this.bookService.findBookById(id) : null ;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return book != null ? this.bookService.updateBook(book) : null;
    }

    @DeleteMapping("/{book-id}")
    public void deleteBook(@PathVariable("book-id") String id ){
        this.bookService.deleteBook(id); ;

    }


}
