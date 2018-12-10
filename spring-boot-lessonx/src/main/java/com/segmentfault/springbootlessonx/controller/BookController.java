package com.segmentfault.springbootlessonx.controller;

import com.segmentfault.springbootlessonx.entity.Book;
import com.segmentfault.springbootlessonx.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-09 08:41
 **/
@RestController
public class BookController {

    @Autowired
    @Qualifier("bookRepository1")
    private PagingAndSortingRepository<Book,String> bookRepository;


    @Autowired
    @Qualifier("bookRepository2")
    private BookRepository bookRepository2;

    @GetMapping("/books/{name}")
    public List<Book> findByName(@PathVariable String name){
        return bookRepository2.findByName(name);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable(name="id") String id){
        Book book = bookRepository.findOne(id);
        return book;
    }

    @PostMapping("/book/{id}")
    public Book createBook(@PathVariable String id, @RequestBody Book book){
        book.setId(id);
        book.setPublishedDate(new Date());
        bookRepository.save(book);
        return book;
    }
}
