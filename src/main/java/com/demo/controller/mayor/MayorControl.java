package com.demo.controller.mayor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mayor")
public class MayorControl {

    /**
     * 考场列表
     * @return
     */

    @RequestMapping("/examRoomManage")
    public String examRoomManage() {

        return "/Mayor/exam-room-manage";
    }
    /**
     * 添加考场
     * @return
     */
    @RequestMapping("/examRoomManageAdd")
    public String examRoomManageAdd() {

        return "/Mayor/exam-room-manage-add";
    }

    /**
     * 更新考场
     * @return
     */
    @RequestMapping("examRoomManageUpdate")
    public String examRoomManageUpdate() {

        return "/Mayor/exam-room-manage-update";
    }

    /**
     * 监考老师
     * @return
     */
    @RequestMapping("/examTeacher")
    public String examTeacher() {

        return "/Mayor/exam-teacher";
    }

    /**
     * 个人信息
     * @return
     */
    @RequestMapping("/personalInfo")
    public String personalInfo() {

        return "/Mayor/personal-info";
    }

    /**
     * 更新个人信息
     * @return
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate() {

        return "/Mayor/personal-info-update";
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
     * 考场管理
     * @return
     */
    @RequestMapping("/roomManage")
    public String roomManage() {

        return "/Mayor/room-manage";
    }

    /**
     * 学生信息查看
     * @return
     */
    @RequestMapping("/studentInfo")
    public String studentInfo() {

        return "/Mayor/student-info";
    }

    /**
     * 老师列表
     * @return
     */
    @RequestMapping("/teacherInfo")
    public String teacherInfo() {

        return "/Mayor/teacher-info";
    }

    /**
     * 增加老师
     * @return
     */
    @RequestMapping("/teacherInfoAdd")
    public String teacherInfoAdd() {

        return "/Mayor/teacher-info-add";
    }

    /**
     * 更新老师信息
     * @return
     */
    @RequestMapping("/teacherInfoUpdate")
    public String teacherInfoUpdate() {

        return "/Mayor/teacher-info-update";
    }

    /**
     * 违规信息
     * @return
     */
    @RequestMapping("/violateInfo")
    public String violateInfo() {

        return "/Mayor/violate-info";
    }



}


