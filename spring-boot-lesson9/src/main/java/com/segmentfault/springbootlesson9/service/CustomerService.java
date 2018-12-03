package com.segmentfault.springbootlesson9.service;

import com.segmentfault.springbootlesson9.entity.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-03 13:17
 **/
@Service
public class CustomerService {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * add customer
     * @param customer
     */
    public void addCustomer(Customer customer){
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Long id) {
        return null;
    }
}
