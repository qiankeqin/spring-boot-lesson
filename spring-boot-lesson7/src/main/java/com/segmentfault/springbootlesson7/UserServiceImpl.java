package com.segmentfault.springbootlesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-15 21:06
 **/
@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(User user) {
        return jdbcTemplate.execute("insert into user(name,age) value(?,?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws DataAccessException, SQLException {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setInt(2, user.getAge());
                int i = preparedStatement.executeUpdate();
                return i > 0;
            }
        });
    }
}
