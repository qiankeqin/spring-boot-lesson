package com.segmentfault.springbootlesson9.repository;

import com.segmentfault.springbootlesson9.entity.Customer;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @program: spring-boot-lesson
 * @description: 客户数据仓储
 * @author: qiankeqin
 * @create: 2018-12-05 20:40
 **/
@Repository
@Transactional(readOnly = false)
public class CustomerRepository extends SimpleJpaRepository<Customer,Long>{

    public CustomerRepository(EntityManager em) {
        super(Customer.class,em);
    }
}
