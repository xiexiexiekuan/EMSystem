package com.demo.service.admin;

import com.demo.controller.UrlController;
import com.demo.dao.admin.Admin;
import com.demo.entity.exam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    /*
     查询所有评卷计划信息
    */
    public List<JudgingPlan> findAllJudgingPlan(){
        return admin.findAllJudgingPlan();
    }

    /*
    添加评卷计划信息
     */
    public Integer addJudgingPlan(JudgingPlan judgingPlan){
        return admin.addJudgingPlan(judgingPlan);
    }

    /*
    根据ID查询对应的评卷计划信息
     */
    public JudgingPlan findJudgingPlanByCode(int planCode){
        return admin.findJudgingPlanByCode(planCode);
    }

    /*
    更新评卷计划信息
     */
    public Integer updateJudgingPlan(JudgingPlan judgingPlan){
        return admin.updateJudgingPlan(judgingPlan);
    }

    /*
    删除评卷计划信息
     */
    public Integer deleteJudgingPlan(int planCode){
        return admin.deleteJudgingPlan(planCode);
    }

    /*
     查询所有违纪编码库
    */
    public List<ViolationsCode> findAllViolationsCode(){
        return admin.findAllViolationsCode();
    }

    /*
     查询所有处罚编码库
    */
    public List<PenaltyCode> findAllPenaltyCode(){
        return admin.findAllPenaltyCode();
    }

    /*
     查询所有违纪记录管理
    */
    public List<ViolationInfo> findAllViolationInfo(){
        return admin.findAllViolationInfo();
    }

    /*
    处理市州上报的违纪记录
    本操作仅更新previewStatus,punishmentCode,punishDescription,punishMan,punishTime,processing_state
     */
    public Integer handleViolationInfo(ViolationInfo violationInfo){
        violationInfo.setPreviewStatus(1);//1代表已审核
        violationInfo.setProcessing_state("1");//1代表已处理
        violationInfo.setPunishMan(UrlController.currentUser.getUserName());//本处审核人为用户名
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        violationInfo.setPunishTime(timeStamp);
        return admin.handleViolationInfo(violationInfo);
    }

    /*
    查询所有考试成绩信息
     */
    public List<ApplicationInformation> findAllGradesInfo(){
        return admin.findAllGradesInfo();
    }

    /*
    查询一种考试成绩信息
     */
    public List<ApplicationInformation> findOneGradesInfo(int typeId){
        return admin.findOneGradesInfo(typeId);
    }

    /*
    查询考试类型菜单
     */
    public List<ExamType> findExamMenu(){
        return admin.findExamMenu();
    }

    /*
    根据考生Id查询是否有违规记录
     */
    public Integer findViolationInfoByUserId(int userId){
        return admin.findViolationInfoByUserId(userId);
    }

    /*
    录入考生的成绩，并将开考状态设为1
     */
    public Integer gradesManage(int enterId, String grades){
        int examStatus = 1;//开考状态设为1
        return admin.gradesManage(enterId, grades, examStatus);
    }
}
