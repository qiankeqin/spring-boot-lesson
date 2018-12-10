package com.segmentfault.springbootlessonx.repository;

import com.segmentfault.springbootlessonx.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepository2")
public interface BookRepository extends CrudRepository<Book,String>{

    List<Book> findByName(String name);
}
