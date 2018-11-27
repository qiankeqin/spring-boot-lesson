package com.segmentfault.springbootlesson8.controller;

import com.segmentfault.springbootlesson8.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-27 13:21
 **/
@RestController
public class UserController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/user/{id}")
    public User user(@PathVariable(value="id") int id){
        User user = sqlSessionTemplate.selectOne("com.segmentfault.springbootlesson8.mapper.UserMapper.selectOneUser", 2);
        return user;
    }
}
