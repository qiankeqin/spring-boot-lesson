package com.segmentfault.springbootlessonxii.controller;

import com.segmentfault.springbootlessonxii.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-26 13:02
 **/
@RestController
public class KafkaController {
    private final KafkaTemplate kafkaTemplate;

    //构造器注入
    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value="/message/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("sf",0,message);

        return message;
    }

    @PostMapping(value="/user/save")
    public User saveUser(@RequestBody User user){

        kafkaTemplate.send("sf-user",0,user);

        return user;
    }


}
