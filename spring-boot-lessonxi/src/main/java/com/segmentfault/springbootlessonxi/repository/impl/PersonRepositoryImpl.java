package com.segmentfault.springbootlessonxi.repository.impl;

import com.segmentfault.springbootlessonxi.domain.Person;
import com.segmentfault.springbootlessonxi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link PersonRepository} 实现
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 16:32
 **/
@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private final Map<String,Person>  repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public Boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(),person);
//        Person p = repository.putIfAbsent(person.getId(), person);
        return true;
    }
}
