package com.demo.service.examinee;

import com.demo.controller.UrlController;
import com.demo.dao.ExamDao;
import com.demo.dao.examinee.Examinee;
import com.demo.entity.Exam;
import com.demo.entity.exam.ApplicationInformation;
import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.PublishExam;
import com.demo.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ExamineeServe {

    @Autowired
    private Examinee examineeDao;

    /**
     * 分页查找已发布考试信息
     */
    public PageBean<ExamType> findByPage(int currentPage, int pageSize){
        List<ExamType> list=examineeDao.findExamListAll();
        Integer totalNum=examineeDao.countExamList();
        PageBean<ExamType> page=new PageBean<ExamType>(currentPage,pageSize,totalNum);
        page.setItems(list);
        return page;
    }

    /*
    查询已发布的考试类型--通过考试类型
     */
    public PublishExam findPublishExamByTypeId(int typeId){
        return examineeDao.findPublishExamByTypeId(typeId);
    }

    /*
    查找白名单是否含有本考生
     */
    public Integer findWhitelistHaveStu(int userId){
        return examineeDao.findWhitelistHaveStu(userId);
    }

    /*
    添加报名信息
     */
    public Integer addApplicationInformation(ApplicationInformation applicationInfo){
        applicationInfo.setAdminNumber("000");
        applicationInfo.setExamStatus(0);
        applicationInfo.setApplyStatus(0);
        applicationInfo.setPayStatus(0);
        applicationInfo.setPreviewStatus(0);
        return examineeDao.addApplicationInformation(applicationInfo);
    }

    /*
    查询--未审核
     */
    public List<ApplicationInformation> findWaitAuditApplication(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.findWaitAuditApplication(userId);
    }

    /*
    查询--已审核
     */
    public List<ApplicationInformation> findAlreadyAuditApplication(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.findAlreadyAuditApplication(userId);
    }

    /*
    选择报考后，确认报考
     */
    public Integer confirmApply(int enterId, String wantSchool){
        return examineeDao.confirmApply(enterId, wantSchool);
    }

    /*
    查询--未支付
     */
    public List<ApplicationInformation> findWaitPayApplication(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.findWaitPayApplication(userId);
    }

    /*

     */
    public Integer payForExam(int enterId){
        return examineeDao.payForExam(enterId);
    }

    /*
    查询--已支付
     */
    public List<ApplicationInformation> findAlreadyPayApplication(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.findAlreadyPayApplication(userId);
    }

    /*
    查询考试成绩
     */
    public List<ApplicationInformation> inquireGrades(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.inquireGrades(userId);
    }

    /*
    查询违纪情况
     */
    public List<ApplicationInformation> inquireViolation(){
        int userId = UrlController.currentUser.getUserId();
        return examineeDao.inquireViolation(userId);
    }


}
