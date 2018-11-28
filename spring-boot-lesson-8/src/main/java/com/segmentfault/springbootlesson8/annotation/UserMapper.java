package com.segmentfault.springbootlesson8.annotation;

import com.segmentfault.springbootlesson8.entity2.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

//    @ResultMap("UserResultMap2")
    @Results(value={
            @Result(property = "id",column = "id", id=true ),
            @Result(property = "name",column = "name"),
            @Result(property = "ages",column = "age"),
            @Result(property = "description",column = "desc")
    })
    @Select("select id,name,age,desc from user where id=#{id} ")
    User selectUser(int id);

}
