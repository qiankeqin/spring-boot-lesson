 package com.segmentfault.springbootlesson8.demo;

import com.segmentfault.springbootlesson8.annotation.UserMapper;
import com.segmentfault.springbootlesson8.entity2.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-23 12:51
 **/
public class MyBatisAnnotationConfigurationDemo {

    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:/mybatis/mybatis-config.xml");

        //使用字符流，防止有乱码
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
//        InputStream inputStream = resource.getInputStream();

        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUser(2);


//        sqlSession.select("select *  from user where id=#{id}",1);
//        User user = sqlSession.selectOne("com.segmentfault.springbootlesson8.mapper.UserMapper.selectOneUser", 1);
        System.out.println(user);

        sqlSession.close();


    }
}
