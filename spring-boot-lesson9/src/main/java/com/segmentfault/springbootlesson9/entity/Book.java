package com.segmentfault.springbootlesson9.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-03 12:54
 **/
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String isbn;

    private String publicDate;

    @ManyToMany(mappedBy = "books")
    private Collection<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
