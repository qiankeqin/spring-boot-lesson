package com.segmentfault.springbootlessonxii.deserializer;

import com.segmentfault.springbootlessonxii.domain.User;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @program: spring-boot-lesson
 * @description: 用户的反序列化
 * @author: qiankeqin
 * @create: 2018-12-26 13:47
 **/
public class UserDeSerializer implements Deserializer<User> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public User deserialize(String topic, byte[] data) {

        Object user = null;

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            user = objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return (User) user;
    }

    @Override
    public void close() {

    }
}
