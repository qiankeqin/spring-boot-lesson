package com.segmentfault.springbootlesson9.controller;

import com.segmentfault.springbootlesson9.entity.Customer;
import com.segmentfault.springbootlesson9.repository.CustomerRepository;
import com.segmentfault.springbootlesson9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Customer getOne(@PathVariable(name="id") Long id){
        return customerRepository.findOne(id);
    }

    /**
     * add customer
     * @param customer
     * @return
     */
    @PostMapping("/add")
    @Transactional
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        Long id = customer.getId();
        customerService.getCustomerById(id);
        return customer;
    }
}
