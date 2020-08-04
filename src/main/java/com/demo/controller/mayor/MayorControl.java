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


