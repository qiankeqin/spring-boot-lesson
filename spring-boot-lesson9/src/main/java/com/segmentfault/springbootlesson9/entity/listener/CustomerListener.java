package com.segmentfault.springbootlesson9.entity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * @program: spring-boot-lesson
 * @description: 客户持久化监听器
 * @author: qiankeqin
 * @create: 2018-12-05 20:24
 **/
public class CustomerListener {

    @PrePersist
    public void prePersist(Object source){
        System.out.println("@PrePersist:"+source);
    }

    @PostPersist
    public void postPersist(Object source){
        System.out.println("@PostPersist:"+source);
    }
}
