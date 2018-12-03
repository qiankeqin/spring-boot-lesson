package com.segmentfault.springbootlesson9.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @program: spring-boot-lesson
 * @description: 店铺
 * @author: qiankeqin
 * @create: 2018-12-02 22:03
 **/
@Entity
@Table(name="stores")
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 32)
    private String name;

    @OneToMany(mappedBy = "store")
    private List<Customer> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
