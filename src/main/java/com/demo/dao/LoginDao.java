package com.demo.dao;

import com.demo.entity.User;
import com.demo.entity.exam.UserInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    @Select("select * from user_information where userName=#{userName} and password=#{password}")
    public UserInformation validate(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert user_information(userName,password,phone,role) values(#{userName},#{password},#{phone},3)")
    public Integer regist(UserInformation user);
}
