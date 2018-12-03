package com.segmentfault.springbootlesson9.controller;

import com.segmentfault.springbootlesson9.entity.Customer;
import com.segmentfault.springbootlesson9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-03 13:21
 **/
@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * add customer
     * @param customer
     * @return
     */
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        Long id = customer.getId();
        customerService.getCustomerById(id);
        return customer;
    }
}
