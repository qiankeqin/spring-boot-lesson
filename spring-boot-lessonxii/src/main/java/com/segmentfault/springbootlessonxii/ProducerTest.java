package com.segmentfault.springbootlessonxii;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * @program: spring-boot-lesson
 * @description: 生产者
 * @author: qiankeqin
 * @create: 2018-12-22 11:27
 **/
public class ProducerTest {

    public static void main(String[] args) throws Exception{
        //创建配置proeprties类
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");

    }
}
