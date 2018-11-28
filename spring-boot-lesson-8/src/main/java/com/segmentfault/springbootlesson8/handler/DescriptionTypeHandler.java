package com.segmentfault.springbootlesson8.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.segmentfault.springbootlesson8.entity.Description;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-28 12:49
 **/
public class DescriptionTypeHandler implements TypeHandler{
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {

        try {
            StringWriter stringWriter = new StringWriter();
            objectMapper.writeValue(stringWriter,o);
            String desc = stringWriter.toString();
            preparedStatement.setString(1,desc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        String desc = resultSet.getString(s);
        Description description = null;

        try {
            if(StringUtils.hasText(desc)){
                description = objectMapper.readValue(desc,Description.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return description;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        String desc = resultSet.getString(i);
        Description description = null;

        try {
            if(StringUtils.hasText(desc)){
                description = objectMapper.readValue(desc,Description.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return description;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
