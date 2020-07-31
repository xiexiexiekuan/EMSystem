package com.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/examoffice")
public class AdminControl {

    /*
    查询所有考试类型信息
     */
    @RequestMapping("examType")
    public String examType(){
        return "/administrator/exam-type";
    }

    /*
    前往添加考试类型信息
     */
    @RequestMapping("toExamTypeAdd")
    public String toExamTypeAdd(){
        return "/administrator/exam-type-add";
    }

    /*
    添加考试类型信息
     */
    @RequestMapping("examTypeAdd")
    public String examTypeAdd(){
        return "/administrator/exam-type";
    }

    /*
    前往更新考试类型信息页面
     */
    @RequestMapping("toExamTypeUpdate")
    public String toExamTypeUpdate(){
        return "/administrator/exam-type-update";
    }

    /*
    更新考试类型信息
     */
    @RequestMapping("examTypeUpdate")
    public String examTypeUpdate(){
        return "/administrator/exam-type";
    }

    /*
    删除考试类型信息
     */
    @RequestMapping("examTypeDelete")
    public String examTypeDelete(){
        return "/administrator/exam-type";
    }

    /*
    前往发布考试信息页面
     */
    @RequestMapping("toPublishExam")
    public String toPublishExam(){
        return "/administrator/publish-exam";
    }

    /*
    发布考试信息
     */
    @RequestMapping("publishExam")
    public String publishExam(){
        return "/administrator/exam-info";
    }

    /*
    查询所有发布的考试信息
     */
    @RequestMapping("examInfo")
    public String examInfo(){
        return "/administrator/exam-info";
    }

    /*
    前往评卷管理页面
     */
    @RequestMapping("toTestPaperPlan")
    public String toTestPaperPlan(){
        return "/administrator/test-paper-plan";
    }

    /*
    前往添加评卷管理页面
     */
    @RequestMapping("toTestPaperPlanAdd")
    public String toTestPaperPlanAdd(){
        return "/administrator/test-paper-plan-add";
    }

    /*
    前往更新评卷管理页面
     */
    @RequestMapping("toTestPaperPlanUpdate")
    public String toTestPaperPlanUpdate(){
        return "/administrator/test-paper-plan-update";
    }

    /*
    添加评卷管理
     */
    @RequestMapping("testPaperPlanAdd")
    public String testPaperPlanAdd(){
        return "/administrator/test-paper-plan";
    }

    /*
    更新评卷管理
     */
    @RequestMapping("testPaperPlanUpdate")
    public String testPaperPlanUpdate(){
        return "/administrator/test-paper-plan";
    }

    /*
    删除评卷管理
     */
    @RequestMapping("testPaperPlanDelete")
    public String testPaperPlanDelete(){
        return "/administrator/test-paper-plan";
    }

    /*
    违纪编码库查询
     */
    @RequestMapping("violateCode")
    public String violateCode(){
        return "/administrator/violate-code";
    }

    /*
    处罚编码库查询
     */
    @RequestMapping("punishCode")
    public String punishCode(){
        return "/administrator/punish-code";
    }

    /*
    前往违纪记录管理
     */
    @RequestMapping("violateRecords")
    public String violateRecords(){
        return "/administrator/violate-records";
    }

    /*
    违纪记录管理
     */
    @RequestMapping("violateHandle")
    public String violateHandle(){
        return "/administrator/violate-records";
    }

    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo()
    {
        return "/administrator/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate()
    {
        return "/administrator/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate()
    {
        return "/administrator/personal-info";
    }

    /*
    市州信息
     */
    @RequestMapping("/mayorInfo")
    public String mayorInfo()
    {
        return "/administrator/mayor-info";
    }

    /*
    去更新市州信息页面
     */
    @RequestMapping("/toMayorInfoUpdate")
    public String toMayorInfoUpdate()
    {
        return "/administrator/mayor-info-update";
    }

    /*
    更新市州信息
     */
    @RequestMapping("/mayorInfoUpdate")
    public String mayorInfoUpdate()
    {
        return "/administrator/mayor-info";
    }

    /*
    去添加市州信息页面
     */
    @RequestMapping("/toMayorInfoAdd")
    public String toMayorInfoAdd()
    {
        return "/administrator/mayor-info-add";
    }

    /*
    添加市州信息
     */
    @RequestMapping("/mayorInfoAdd")
    public String mayorInfoAdd()
    {
        return "/administrator/mayor-info";
    }

    /*
    删除市州信息
     */
    @RequestMapping("/mayorInfoDelete")
    public String mayorInfoDelete()
    {
        return "/administrator/mayor-info";
    }

    /*
    院校老师信息
     */
    @RequestMapping("/teacherInfo")
    public String teacherInfo()
    {
        return "/administrator/teacher-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo()
    {
        return "/administrator/student-info";
    }

    /*
    前往成绩管理页面
     */
    @RequestMapping("/toGradesManage")
    public String toGradesManage()
    {
        return "/administrator/grades-manage";
    }

    /*
    成绩管理
     */
    @RequestMapping("/gradesManage")
    public String gradesManage()
    {
        return "/administrator/grades-manage";
    }
}
