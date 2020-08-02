package com.demo.service.admin;

import com.demo.controller.UrlController;
import com.demo.dao.admin.Admin;
import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.PublishExam;
import com.demo.entity.exam.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class AdminServe {

    @Autowired
    private Admin admin;

    /*
    查询所有考试类型信息
     */
    public List<ExamType> findAllExamType(){
        return admin.findAllExamType();
    }

    /*
    添加考试类型信息，其中操作人由全局变量获取，日期取当前时间，需要包装为SQL精确到秒的日期类型
     */
    public Integer addExamType(ExamType examType){
        examType.setUserId(UrlController.currentUser.getPrimaryKey());
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        examType.setCreateTime(timeStamp);
        return admin.addExamType(examType);
    }

    /*
    根据ID查询对应的考试类型信息
     */
    public ExamType findExamTypeById(int typeId){
        return admin.findExamTypeById(typeId);
    }

    /*
    更新考试类型信息
     */
    public Integer updateExamType(ExamType examType){
        examType.setUserId(UrlController.currentUser.getPrimaryKey());
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        examType.setCreateTime(timeStamp);
        return admin.updateExamType(examType);
    }

    /*
    删除考试类型信息
     */
    public Integer deleteExamType(int typeId){
        return admin.deleteExamType(typeId);
    }

    /*
    发布一场考试
     */
    public Integer publishExam(PublishExam exam){
        exam.setUserId(UrlController.currentUser.getPrimaryKey());
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        exam.setPublishTime(timeStamp);
        return admin.publishExam(exam);
    }

    /*
    查询所有已经发的考试信息
     */
    public List<PublishExam> findAllPublishExam(){
        return admin.findAllPublishExam();
    }
}
