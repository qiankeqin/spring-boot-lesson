package com.segmentfault.springbootlesson9.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-30 13:09
 **/
@Entity
@Table(name="credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String number;

    @Column(name="register_date")
    private Date registerDate;

    @OneToOne(mappedBy = "creditCard",cascade = CascadeType.REMOVE)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
