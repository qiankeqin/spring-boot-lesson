package com.segmentfault.springbootlessonxii.serializer;

import com.segmentfault.springbootlessonxii.domain.User;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.tomcat.util.buf.ByteChunk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @program: spring-boot-lesson
 * @description: 用户的序列化
 * @author: qiankeqin
 * @create: 2018-12-26 13:32
 **/
public class UserSerializer implements Serializer<User> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, User data) {
        System.out.println("topic :"+topic + ", data:"+data);

        //将data写入到outputStream中
        byte[] userData = null;
        ByteOutputStream outputStream = new ByteOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(data);
            userData = outputStream.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userData;
    }

    @Override
    public void close() {

    }
}
