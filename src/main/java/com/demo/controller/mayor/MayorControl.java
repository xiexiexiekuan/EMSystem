package com.demo.controller.mayor;

import com.demo.entity.exam.*;
import com.demo.service.mayor.MayorServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mayor")
public class MayorControl {

    @Autowired
    private MayorServe mayorServe;
    /**
     * 考点列表
     * @return
     */
    @RequestMapping("/roomManage")
    public String roomManage(Map<String,Object> map) {
        List<RoomManage> roomManage = mayorServe.findAllRoomManage();
        map.put("roomManage",roomManage);
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
    public String roomManageAdd(Map<String,Object> map, RoomManage roomManage) {
        Integer i = mayorServe.addRoomManage(roomManage);
        if(i>0){
            map.put("msg","考点列表添加成功！");
            return roomManage(map);
        }
        map.put("msg","考点列表添加失败，请重试！");
        return toRoomManageAdd();
    }

    /*
     前往更新考点页面
     */
    @RequestMapping("/toRoomManageUpdate")
    public String toRoomManageUpdate(int roomId, Map<String,Object> map) {
        RoomManage updateRoom = mayorServe.findRoomManageById(roomId);
        map.put("updateRoom",updateRoom);
        return "/Mayor/room-manage-update";
    }

    /*
     更新考点
     */
    @RequestMapping("/roomManageUpdate")
    public String roomManageUpdate(Map<String,Object> map, RoomManage roomManage) {
        Integer i = mayorServe.updateRoomManage(roomManage);
        if(i>0){
            map.put("msg","考点列表更新成功！");
            return roomManage(map);
        }
        map.put("msg","考点列表更新失败，请重试！");
        return toRoomManageUpdate(roomManage.getRoomId(),map);
    }

    /*
     删除考点
     */
    @RequestMapping("/roomManageDelete")
    public String roomManageDelete(int roomId, Map<String,Object> map) {
        Integer i = mayorServe.deleteRoomManage(roomId);
        if(i>0){
            map.put("msg","考点列表删除成功！");
            return roomManage(map);
        }
        map.put("msg","考点列表删除失败，请重试！");
        return roomManage(map);
    }

    /*
    去考场管理
     */
    @RequestMapping("/toExamRoomManage")
    public String toExamRoomManage(Map<String,Object> map) {
        List<ExamRoomInformation> examRoomInformation = mayorServe.findAllExamRoomInformation();
        map.put("examRoomInformation",examRoomInformation);
        return "/Mayor/exam-room-manage";

    }

    /*
     考场编排管理,给考场分配考生
     输出：考点，考场，学生座位分配
     */
    @RequestMapping("/examRoomManage")
    public String examRoomManage(int examRoomId, int useStatus, Map<String,Object> map) {
        Integer i = mayorServe.updateExamRoom(examRoomId,useStatus);
        if(i>0){
            map.put("msg","考场安排成功！");
            return toExamRoomManage(map);
        }
        map.put("msg","考场安排失败，请重试！");
        return toExamRoomManage(map);
    }

    /*
   生成准考证号
   市代码（两位）+ 考点
   */
    @RequestMapping("/admitTicket")
    public String admitTicket(Map<String,Object> map) {

        return toExamRoomManage(map);
    }

    /**
     * 去监考老师管理
     * @return
     */
    @RequestMapping("/toExamTeacher")
    public String toExamTeacher(Map<String,Object> map) {
        List<ExamTeacher> examTeacher = mayorServe.findAllExamTeacher();
        map.put("examTeacher",examTeacher);
        return "/Mayor/exam-teacher";
    }

    /**
     * 监考老师管理
     * @return
     */
    @RequestMapping("/examTeacher")
    public String examTeacher(int teacherId, int examRoomId, Map<String,Object> map) {
        Integer i = mayorServe.updateExamTeacher(teacherId,examRoomId);
        if(i>0){
            map.put("msg","监考老师安排成功！");
            return toExamTeacher(map);
        }
        map.put("msg","监考老师安排失败，请重试！");
        return toExamTeacher(map);
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
    public String reportViolate(ViolationInfo violationInfo, Map<String,Object> map) {
        Integer i = mayorServe.addViolationInfo(violationInfo);
        if(i>0){
            map.put("msg","违规信息上报成功！");
            return violateInfo(map);
        }
        map.put("msg","违规信息上报失败，请重试！");
        return toReportViolate();
    }

    /**
     * 违规信息查询
     * @return
     */
    @RequestMapping("/violateInfo")
    public String violateInfo(Map<String,Object> map) {
        List<ViolationInfo> violationInfo = mayorServe.findAllViolationInfo();
        map.put("violationInfo",violationInfo);
        return "/Mayor/violate-info";
    }

    /**
     * 去现场审核
     */
    @RequestMapping("/toPreview")
    public String toPreview(Map<String,Object> map) {
        List<ApplicationInformation> preview = mayorServe.findAllApplicationInfo();
        for(int i=0; i<preview.size(); i++) {
            UserInformation user = mayorServe.findUserInformationById(preview.get(i).getUserId());
            preview.get(i).setExamineeNumber(user.getUserName());//做个替换
        }
        map.put("preview",preview);
        return "/Mayor/preview";
    }

    /**
     * 现场审核
     */
    @RequestMapping("/preview")
    public String preview(int enterId, int status, Map<String,Object> map) {
        Integer i = mayorServe.updatePreview(enterId,status);
        if(i>0){
            map.put("msg","现场审核成功！");
            return toPreview(map);
        }
        map.put("msg","现场审核失败，请重试！");
        return toPreview(map);
    }
    
}


