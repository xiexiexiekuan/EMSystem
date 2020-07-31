package com.demo.service;

import com.demo.dao.LoginDao;
import com.demo.dao.examinee.ExamineeDao;
import com.demo.entity.User;
import com.demo.entity.exam.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zrq on 2018-4-23.
 */
@Service
public class LoginService {
    @Autowired
    private ExamineeDao examineeDao;
    private LoginDao loginDao;

    public User findUser(User user) {
        return examineeDao.findByUser(user.getUsername(),user.getPassword());
    }

    public Integer registUser(User user) {
        return examineeDao.registUser(user);
    }

    public Integer saveUserImage(String fileName,Integer id) {
        return examineeDao.saveUserImage(fileName,id);
    }

    public User findUserById(Integer id) {
        return examineeDao.findById(id);
    }

    public UserInformation validate(UserInformation user) {
        return loginDao.validate(user.getUserName(),user.getPassword());
    }

    public Integer regist(UserInformation user) {
        return loginDao.regist(user);
    }
}
