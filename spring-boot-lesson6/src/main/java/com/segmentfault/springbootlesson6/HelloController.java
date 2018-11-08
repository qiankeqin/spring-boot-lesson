package com.segmentfault.springbootlesson6;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-08 20:34
 **/
@RestController
public class HelloController {

    @RequestMapping("/tomcat-test")
    public String hello(){
        return "hello Embedded tomcat";
    }
}
