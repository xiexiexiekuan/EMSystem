package com.demo.controller.examinee;

import com.demo.entity.exam.ExamType;
import com.demo.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class ExamineeControl {

    /*
    考生查看所有已发布的考试列表
     */
    @RequestMapping("/examList")
    public String examList(Map<String,Object> map)
    {
        PageBean<ExamType> examPage = new PageBean<ExamType>();
        map.put("examPage",examPage);
        return "/Examinee/exam-list";
    }

    /*
    选择一个考试去报名
     */
    @RequestMapping("/toSignUp")
    public String toSignUp()
    {
        return "/Examinee/sign-up";
    }

    /*
    确认报名，即向后台提交报名信息
     */
    @RequestMapping("/signUp")
    public String signUp()
    {
        return "/Examinee/exam-list";
    }

    /*
    进入考试管理列表    待审核
     */
    @RequestMapping("/toWaitAudit")
    public String toWaitAudit()
    {
        return "/Examinee/wait-audit";
    }

    /*
    进入考试管理列表    已审核
     */
    @RequestMapping("/toAlreadyAudit")
    public String toAlreadyAudit()
    {
        return "/Examinee/already-audit";
    }

    /*
    进入考试管理列表    未支付
     */
    @RequestMapping("/toWaitPay")
    public String toWaitPay()
    {
        return "/Examinee/wait-pay";
    }

    /*
    进入考试管理列表    已支付
     */
    @RequestMapping("/toAlreadyPay")
    public String toAlreadyPay()
    {
        return "/Examinee/already-pay";
    }

    /*
    成绩查询
     */
    @RequestMapping("/inquireGrades")
    public String inquireGrades()
    {
        return "/Examinee/inquire-grades";
    }

    /*
    违纪查询
     */
    @RequestMapping("/inquireViolation")
    public String inquireViolation()
    {
        return "/Examinee/inquire-violation";
    }

    /*
    准考证
     */
    @RequestMapping("/admissionTicket")
    public String admissionTicket()
    {
        return "/Examinee/admission-ticket";
    }

    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo()
    {
        return "/Examinee/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate()
    {
        return "/Examinee/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate()
    {
        return "/Examinee/personal-info";
    }
}
