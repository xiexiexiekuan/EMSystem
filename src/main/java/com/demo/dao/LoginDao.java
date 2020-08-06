package com.demo.dao;

import com.demo.entity.exam.UserInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    @Select("select * from UserInformation where userName=#{userName} and password=#{password}")
    public UserInformation validate(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert UserInformation(userName,password,phone,role) values(#{userName},#{password},#{phone},3)")
    public Integer regist(UserInformation user);
}
