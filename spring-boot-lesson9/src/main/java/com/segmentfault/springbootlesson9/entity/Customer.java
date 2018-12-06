package com.segmentfault.springbootlesson9.entity;

import com.segmentfault.springbootlesson9.entity.listener.CustomerListener;

import javax.persistence.*;
import java.util.Collection;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-30 12:48
 **/
@Entity
@Access(value= AccessType.FIELD)
@Table(name="customers")
@EntityListeners(value={CustomerListener.class})
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 32)
    private String name;

    @OneToOne
    private CreditCard creditCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private Collection<Book> books;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creditCard=" + creditCard +
                ", store=" + store +
                ", books=" + books +
                '}';
    }
}
