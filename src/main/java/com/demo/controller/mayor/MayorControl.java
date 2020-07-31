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
    @RequestMapping("/roommanage")
    public String roomManage() {

        return "/Mayor/room-manage";
    }

    /*
     前往添加考点页面
     */
    @RequestMapping("/roommanageadd")
    public String roomManageAdd() {

        return "/Mayor/room-manage-add";
    }

    /*
     添加考点
     */
    @RequestMapping("/roomadd")
    public String roomAdd() {

        return "/Mayor/room-manage";
    }

    /*
     前往更新考点页面
     */
    @RequestMapping("/roommanageupdate")
    public String roomManageupdate() {

        return "/Mayor/room-manage-update";
    }

    /*
     更新考点
     */
    @RequestMapping("/roomupdate")
    public String roomupdate() {

        return "/Mayor/room-manage";
    }

    /*
     删除考点
     */
    @RequestMapping("/roomdelete")
    public String roomdelete() {

        return "/Mayor/room-manage";
    }

    /*
     考场编排管理
     */
    @RequestMapping("/examroommanage")
    public String examroomManage() {

        return "/Mayor/exam-room-manage";
    }

    /*
   生成准考证号
   */
    @RequestMapping("/admitticket")
    public String admitticket() {

        return "/Mayor/exam-room-manage";
    }

    /**
     * 监考老师管理
     * @return
     */
    @RequestMapping("/examteacher")
    public String examTeacher() {

        return "/Mayor/exam-teacher";
    }

    /*
    个人信息
     */
    @RequestMapping("/personalinfo")
    public String personalInfo()
    {
        return "/Mayor/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/personalinfoupdate")
    public String personalInfoUpdate()
    {
        return "/Mayor/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalupdate")
    public String personalUpdate()
    {
        return "/Mayor/personal-info";
    }

    /*
    考务老师信息
     */
    @RequestMapping("/teacherinfo")
    public String teacherinfo()
    {
        return "/Mayor/teacher-info";
    }

    /*
    去更新考务老师信息页面
     */
    @RequestMapping("/teacherinfoupdate")
    public String teacherinfoUpdate()
    {
        return "/Mayor/teacher-info-update";
    }

    /*
    更新考务老师信息
     */
    @RequestMapping("/teacherupdate")
    public String teacherUpdate()
    {
        return "/Mayor/teacher-info";
    }

    /*
    去添加考务老师信息页面
     */
    @RequestMapping("/teacherinfoadd")
    public String teacherinfoadd()
    {
        return "/Mayor/teacher-info-add";
    }

    /*
    添加考务老师信息
     */
    @RequestMapping("/teacheradd")
    public String teacheradd()
    {
        return "/Mayor/teacher-info";
    }

    /*
    删除考务老师信息
     */
    @RequestMapping("/teacherdelete")
    public String teacherdelete()
    {
        return "/Mayor/teacher-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentinfo")
    public String studentinfo()
    {
        return "/Mayor/student-info";
    }

    /**
     * 前往报告违规信息页面
     * @return
     */
    @RequestMapping("/reportviolate")
    public String reportViolate() {

        return "/Mayor/report-violate";
    }

    /**
     * 报告违规信息
     * @return
     */
    @RequestMapping("/reportingviolate")
    public String reportingViolate() {

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


