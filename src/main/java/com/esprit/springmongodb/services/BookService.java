package com.esprit.springmongodb.services;

import com.esprit.springmongodb.entities.Book;
import com.esprit.springmongodb.repositories.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //to auto generate constructors for all final fields in our class
public class BookService {

    /**
     * Internal logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(BookService.class);
    private  static  final String ERROR_NULL_ID = "ID is NULL";
    private static final String ERROR_NON_PRESENT_ID = " cannot find a book with id : %s";
    private static final String ERROR_UPDATE= "Error occured while updating";

    private final BookRepository bookRepository;

    public Book save(Book book){
        return this.bookRepository.save(book);
    }
    public Book findBookById(String id){
        Book book = null;
        if(id != null){
            final Optional<Book> optionalbook = this.bookRepository.findById(id);
            if(optionalbook.isPresent()){
                book = optionalbook.get();
            }else {
                LOG.info(String.format(ERROR_NON_PRESENT_ID,id));
            }
        }else {
            LOG.error(ERROR_NULL_ID);
        }
        return book;
    }

    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }

    public Book updateRoom(Book book) {
        Book updatedBook = null;
        if(book != null){
            updatedBook = this.bookRepository.save(book);
        }else {
            LOG.error(ERROR_UPDATE);
        }
        return  updatedBook;
    }


    public void delete(String id){
        Book book = null;
        if(id != null){
            book = findBookById(id);
            if(book != null){
                this.bookRepository.deleteById(id);
            }else {
                LOG.info(String.format(ERROR_NON_PRESENT_ID,id));
            }
        }else {
            LOG.error(ERROR_NULL_ID);
        }

    }


}
