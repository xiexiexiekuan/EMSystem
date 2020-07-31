package com.demo.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
public class ManagerControl {
    
    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo()
    {
        return "/Manager/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate()
    {
        return "/Manager/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate()
    {
        return "/Manager/personal-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo()
    {
        return "/Manager/student-info";
    }

    /*
    去更新考生信息页面
     */
    @RequestMapping("/toStudentInfoUpdate")
    public String toStudentInfoUpdate()
    {
        return "/Manager/student-info-update";
    }

    /*
    更新考生信息
     */
    @RequestMapping("/studentInfoUpdate")
    public String studentInfoUpdate()
    {
        return "/Manager/student-info";
    }

    /*
    去添加考生信息页面
     */
    @RequestMapping("/toStudentInfoAdd")
    public String toStudentInfoAdd()
    {
        return "/Manager/student-info-add";
    }

    /*
    添加考生信息
     */
    @RequestMapping("/studentInfoAdd")
    public String studentInfoAdd()
    {
        return "/Manager/student-info";
    }

    /*
    删除考生信息
     */
    @RequestMapping("/studentInfoDelete")
    public String studentInfoDelete()
    {
        return "/Manager/student-info";
    }

    /*
    前往集体报名页面
     */
    @RequestMapping("/toGroupEnter")
    public String toGroupEnter()
    {
        return "/Manager/group-enter";
    }

    /*
   集体报名
    */
    @RequestMapping("/groupEnter")
    public String groupEnter()
    {
        return "/Manager/group-enter";
    }

    /*
    前往集体报考页面
     */
    @RequestMapping("/toGroupApply")
    public String toGroupApply()
    {
        return "/Manager/group-apply";
    }

    /*
   集体报考
    */
    @RequestMapping("/groupApply")
    public String groupApply()
    {
        return "/Manager/group-apply";
    }

    /*
   前往集体缴费页面
    */
    @RequestMapping("/toGroupPay")
    public String toGroupPay()
    {
        return "/Manager/group-pay";
    }

    /*
   集体缴费
    */
    @RequestMapping("/groupPay")
    public String groupPay()
    {
        return "/Manager/group-pay";
    }

    /*
    报考信息查询
   */
    @RequestMapping("/examInformation")
    public String examInformation()
    {
        return "/Manager/exam-information";
    }

    /*
    白名单信息
     */
    @RequestMapping("/whitelist")
    public String whitelist()
    {
        return "/Manager/whitelist";
    }

    /*
    去更新白名单信息页面
     */
    @RequestMapping("/toWhitelistUpdate")
    public String toWhitelistUpdate()
    {
        return "/Manager/whitelist-update";
    }

    /*
    更新白名单信息
     */
    @RequestMapping("/whitelistUpdate")
    public String whitelistUpdate()
    {
        return "/Manager/whitelist";
    }

    /*
    去添加白名单信息页面
     */
    @RequestMapping("/toWhitelistAdd")
    public String toWhitelistAdd()
    {
        return "/Manager/whitelist-add";
    }

    /*
    添加白名单信息
     */
    @RequestMapping("/whitelistAdd")
    public String whitelistAdd()
    {
        return "/Manager/whitelist";
    }

    /*
    删除白名单信息
     */
    @RequestMapping("/whitelistDelete")
    public String whitelistDelete()
    {
        return "/Manager/whitelist";
    }

    /*
    考场信息
     */
    @RequestMapping("/examRoom")
    public String examRoom()
    {
        return "/Manager/exam-room";
    }

    /*
    去更新考场信息页面
     */
    @RequestMapping("/toExamRoomUpdate")
    public String toExamRoomUpdate()
    {
        return "/Manager/exam-room-update";
    }

    /*
    更新考场信息
     */
    @RequestMapping("/examRoomUpdate")
    public String examRoomUpdate()
    {
        return "/Manager/exam-room";
    }

    /*
    去添加考场信息页面
     */
    @RequestMapping("/toExamRoomAdd")
    public String toExamRoomAdd()
    {
        return "/Manager/exam-room-add";
    }

    /*
    添加考场信息
     */
    @RequestMapping("/examRoomAdd")
    public String examRoomAdd()
    {
        return "/Manager/exam-room";
    }

    /*
    删除考场信息
     */
    @RequestMapping("/examRoomDelete")
    public String examRoomDelete()
    {
        return "/Manager/exam-room";
    }

    /*
    考务老师信息
     */
    @RequestMapping("/examteacherInfo")
    public String examTeacherInfo()
    {
        return "/Manager/examteacher-info";
    }

    /*
    去更新考务老师信息页面
     */
    @RequestMapping("/toExamteacherInfoUpdate")
    public String toExamTeacherInfoUpdate()
    {
        return "/Manager/examteacher-info-update";
    }

    /*
    更新考务老师信息
     */
    @RequestMapping("/examteacherInfoUpdate")
    public String examTeacherInfoUpdate()
    {
        return "/Manager/examteacher-info";
    }

    /*
    去添加考务老师信息页面
     */
    @RequestMapping("/toExamteacherInfoAdd")
    public String toExamteacherInfoAdd()
    {
        return "/Manager/examteacher-info-add";
    }

    /*
    添加考务老师信息
     */
    @RequestMapping("/examteacherInfoAdd")
    public String examteacherInfoAdd()
    {
        return "/Manager/examteacher-info";
    }

    /*
    删除考务老师信息
     */
    @RequestMapping("/examteacherInfoDelete")
    public String examteacherInfoDelete()
    {
        return "/Manager/examteacher-info";
    }
}
