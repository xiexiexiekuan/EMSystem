package com.demo.controller.mayor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mayor")
public class MayorControl {

    /**
     * 考点列表
     * @return
     */
    @RequestMapping("/roomManage")
    public String roomManage() {

        return "/Mayor/room-manage";
    }

    /*
     前往添加考点页面
     */
    @RequestMapping("/toRoomManageAdd")
    public String toRoomManageAdd() {

        return "/Mayor/room-manage-add";
    }

    /*
     添加考点
     */
    @RequestMapping("/roomManageAdd")
    public String roomManageAdd() {

        return "/Mayor/room-manage";
    }

    /*
     前往更新考点页面
     */
    @RequestMapping("/toRoomManageUpdate")
    public String toRoomManageUpdate() {

        return "/Mayor/room-manage-update";
    }

    /*
     更新考点
     */
    @RequestMapping("/roomManageUpdate")
    public String roomManageUpdate() {

        return "/Mayor/room-manage";
    }

    /*
     删除考点
     */
    @RequestMapping("/roomManageDelete")
    public String roomManageDelete() {

        return "/Mayor/room-manage";
    }

    /*
     考场编排管理
     */
    @RequestMapping("/examRoomManage")
    public String examRoomManage() {

        return "/Mayor/exam-room-manage";
    }

    /*
   生成准考证号
   */
    @RequestMapping("/admitTicket")
    public String admitTicket() {

        return "/Mayor/exam-room-manage";
    }

    /**
     * 监考老师管理
     * @return
     */
    @RequestMapping("/examTeacher")
    public String examTeacher() {

        return "/Mayor/exam-teacher";
    }

    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo()
    {
        return "/Mayor/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate()
    {
        return "/Mayor/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate()
    {
        return "/Mayor/personal-info";
    }

    /*
    考务老师信息
     */
    @RequestMapping("/teacherInfo")
    public String teacherInfo()
    {
        return "/Mayor/teacher-info";
    }

    /*
    去更新考务老师信息页面
     */
    @RequestMapping("/toTeacherInfoUpdate")
    public String toTeacherInfoUpdate()
    {
        return "/Mayor/teacher-info-update";
    }

    /*
    更新考务老师信息
     */
    @RequestMapping("/teacherInfoUpdate")
    public String teacherInfoUpdate()
    {
        return "/Mayor/teacher-info";
    }

    /*
    去添加考务老师信息页面
     */
    @RequestMapping("/toTeacherInfoAdd")
    public String toTeacherInfoAdd()
    {
        return "/Mayor/teacher-info-add";
    }

    /*
    添加考务老师信息
     */
    @RequestMapping("/teacherInfoAdd")
    public String teacherInfoAdd()
    {
        return "/Mayor/teacher-info";
    }

    /*
    删除考务老师信息
     */
    @RequestMapping("/teacherInfoDelete")
    public String teacherInfoDelete()
    {
        return "/Mayor/teacher-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo()
    {
        return "/Mayor/student-info";
    }

    /**
     * 前往报告违规信息页面
     * @return
     */
    @RequestMapping("/toReportViolate")
    public String toReportViolate() {

        return "/Mayor/report-violate";
    }

    /**
     * 报告违规信息
     * @return
     */
    @RequestMapping("/reportViolate")
    public String reportViolate() {

        return "/Mayor/violate-info";
    }

    /**
     * 违规信息查询
     * @return
     */
    @RequestMapping("/violateInfo")
    public String violateInfo() {

        return "/Mayor/violate-info";
    }
    
}


