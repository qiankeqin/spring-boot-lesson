package com.segmentfault.springbootlessonxii;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;


import java.util.Properties;
import java.util.concurrent.Future;

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
        //设置key和value的序列化类
        properties.put("key.serializer",StringSerializer.class);
        properties.put("value.serializer",StringSerializer.class);

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("sf",0,"hello","world");
        Future<RecordMetadata> future = kafkaProducer.send(producerRecord);
        RecordMetadata recordMetadata = future.get();

        System.out.println(recordMetadata);
    }
}
