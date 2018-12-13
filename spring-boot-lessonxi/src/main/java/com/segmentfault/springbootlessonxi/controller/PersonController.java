package com.segmentfault.springbootlessonxi.controller;

import com.segmentfault.springbootlessonxi.domain.Person;
import com.segmentfault.springbootlessonxi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 16:45
 **/
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person){
        personRepository.savePerson(person);
        return person;
    }

    @GetMapping("/find/{id}")
    public Person getPerson(@PathVariable String id){
        return personRepository.findPerson(id);
    }
}
