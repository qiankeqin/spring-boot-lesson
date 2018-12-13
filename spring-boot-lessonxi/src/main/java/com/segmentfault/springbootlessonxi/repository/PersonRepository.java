package com.segmentfault.springbootlessonxi.repository;

import com.segmentfault.springbootlessonxi.domain.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-13 16:21
 **/
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);

    Boolean savePerson(Person person);
}
