package com.demo.dao;

import com.demo.entity.exam.UserInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {

    @Update("update UserInformation set userName=#{userName},password=#{password},sex=#{sex},age=#{age},photo=#{photo},institute=#{institute}," +
            "certificateType=#{certificateType},certificateId=#{certificateId},phone=#{phone},email=#{email} where userId=#{userId}")
    public Integer updatePersonalInfo(UserInformation myInfo);

    @Select("select * from UserInformation where role = 1")
    public List<UserInformation> findAllMayorInfo();

    @Select("select * from UserInformation where role = 2")
    public List<UserInformation> findAllTeacherInfo();

    @Select("select * from UserInformation where role = 3")
    public List<UserInformation> findAllStudentInfo();

    @Select("select * from UserInformation where userId=#{userId}")
    public UserInformation findUserInfoById(int userId);

    @Insert("insert UserInformation(userName,password,sex,age,photo,institute,certificateType,certificateId,phone,email,role) values" +
            "(#{userName},#{password},#{sex},#{age},#{photo},#{institute},#{certificateType},#{certificateId},#{phone},#{email},#{role})")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="userId")
    public Integer addUserInfo(UserInformation userInfo);

    @Delete("delete from UserInformation where userId=#{userId}")
    public Integer deleteUserInfo(int userId);

    @Update("update UserInformation set photo=#{fileName} where userId=#{userId}")
    public Integer saveUserImage(@Param("fileName") String fileName,@Param("id")Integer id);
}
