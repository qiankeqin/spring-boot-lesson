package com.segmentfault.springbootlesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-15 19:18
 **/
@RestController
public class JdbcController {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;


    @RequestMapping("/getUsers")
    public List<Map<String,Object>> getUsers(){
        return jdbcTemplate.execute(new StatementCallback<List<Map<String,Object>>>() {
            @Override
            public List<Map<String, Object>> doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet resultSet = statement.executeQuery("select * from user");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                List<String> columnNames = new ArrayList<>(columnCount);
                for(int i=1;i<=columnCount;i++){
                    String columnName = metaData.getColumnName(i);
                    columnNames.add(columnName);
                }

                List<Map<String,Object>> data = new LinkedList<>();
                while(resultSet.next()){
                    Map<String,Object> columnData = new LinkedHashMap<>();
                    for(String columnName:columnNames){
                        Object object = resultSet.getObject(columnName);
                        columnData.put(columnName,object);
                    }
                    data.add(columnData);
                }

                return data;
            }
        });
    }

    /**
     * 判断是否支持事务
     * @return
     */
    @RequestMapping(value="/jdbc/meta/transaction/supported")
    public Boolean supportedtransaction(){
        boolean supported = false;
        Connection connection = null;

        try{
            connection = dataSource.getConnection();

            DatabaseMetaData metaData = connection.getMetaData();

            supported = metaData.supportsTransactions();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return supported;
    }

    @RequestMapping("/user/get")
    public Map<String,Object> getUser(@RequestParam(value="id",defaultValue = "") int id){

        Map<String,Object> data = new HashMap<>();

        Connection connection = null;
        Savepoint savepoint = null;
        try {
            connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            PreparedStatement statement = connection.prepareStatement("select id,name,age from user where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                data.put("id",id);
                data.put("name",name);
                data.put("age",age);
            }

            connection.commit();
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping(value="/user/add",method= RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody User user){
        Map<String,Object> data = new HashMap<>();

        userService.save(user);
        return data;
    }
}
