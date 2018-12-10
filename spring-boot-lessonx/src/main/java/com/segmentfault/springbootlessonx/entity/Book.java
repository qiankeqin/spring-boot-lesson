package com.segmentfault.springbootlessonx.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-09 08:34
 **/
@Document(indexName = "book", type="it")
public class Book {
    private String id;
    private String name;
    private Float price;
    private Date publishedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
