package com.demo.service;


import com.demo.controller.UrlController;
import com.demo.dao.UserInfoDao;
import com.demo.entity.exam.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /*
    更新个人信息
     */
    public Integer updatePersonalInfo(UserInformation myInfo){
        return userInfoDao.updatePersonalInfo(myInfo);
    }

    /*
    查找所有市州人员信息
     */
    public List<UserInformation> findAllMayorInfo(){
        return userInfoDao.findAllMayorInfo();
    }

    /*
    查找所有院校人员信息
     */
    public List<UserInformation> findAllTeacherInfo(){
        return userInfoDao.findAllTeacherInfo();
    }

    /*
    查找所有考生人员信息
     */
    public List<UserInformation> findAllStudentInfo(){
        return userInfoDao.findAllStudentInfo();
    }

    /*
    根据人员Id查找对应用户
     */
    public UserInformation findUserInfoById(int userId){
        return userInfoDao.findUserInfoById(userId);
    }

    /*
    添加用户信息
     */
    public Integer addUserInfo(UserInformation userInfo){
        int role = UrlController.currentUser.getRole();
        userInfo.setRole(role+1);//本角色只能给下一级的角色添加用户信息
        return userInfoDao.addUserInfo(userInfo);
    }

    /*
    删除用户信息
     */
    public Integer deleteUserInfo(int userId){
        return userInfoDao.deleteUserInfo(userId);
    }
}
