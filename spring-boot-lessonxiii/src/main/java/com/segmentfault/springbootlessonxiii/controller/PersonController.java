package com.segmentfault.springbootlessonxiii.controller;

import com.segmentfault.springbootlessonxiii.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-27 20:31
 **/
@RestController
public class PersonController {

    @PostMapping("/person/save")
    public Person save(@Valid @RequestBody Person person){
        return person;
    }
}
