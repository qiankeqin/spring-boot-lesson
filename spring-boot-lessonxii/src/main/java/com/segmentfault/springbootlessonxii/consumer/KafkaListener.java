package com.segmentfault.springbootlessonxii.consumer;

import com.segmentfault.springbootlessonxii.domain.User;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-12-26 13:06
 **/
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics={"sf"})
    public void consumer(String message){

        System.out.println(message);
    }


    @org.springframework.kafka.annotation.KafkaListener(topics = {"sf-user"})
    public void consumer(User user){
        System.out.println(user);
    }
}
