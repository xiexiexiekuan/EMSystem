package com.demo.service;

import com.demo.dao.LoginDao;
import com.demo.entity.exam.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;



    public UserInformation validate(UserInformation user) {
        return loginDao.validate(user.getUserName(),user.getPassword());
    }

    public Integer regist(UserInformation user) {
        return loginDao.regist(user);
    }
}
