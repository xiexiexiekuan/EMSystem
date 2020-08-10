package com.demo.controller.mayor;

import com.demo.entity.exam.*;
import com.demo.service.mayor.MayorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mayor")
public class MayorController {

    @Autowired
    private MayorService mayorService;
    /**
     * 考点列表
     * @return
     */
    @RequestMapping("/roomManage")
    public String roomManage(Map<String,Object> map) {
        List<RoomManage> roomManage = mayorService.findAllRoomManage();
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
        Integer i = mayorService.addRoomManage(roomManage);
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
        RoomManage updateRoom = mayorService.findRoomManageById(roomId);
        map.put("updateRoom",updateRoom);
        return "/Mayor/room-manage-update";
    }

    /*
     更新考点
     */
    @RequestMapping("/roomManageUpdate")
    public String roomManageUpdate(Map<String,Object> map, RoomManage roomManage) {
        Integer i = mayorService.updateRoomManage(roomManage);
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
        Integer i = mayorService.deleteRoomManage(roomId);
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
        List<ExamRoomInformation> examRoomInformation = mayorService.findAllExamRoomInformation();
        map.put("examRoomInformation",examRoomInformation);
        return "/Mayor/exam-room-manage";

    }

    /*
     考场编排管理,给考场分配考生
     输出：考点，考场，学生座位分配
     */
    @RequestMapping("/examRoomManage")
    public String examRoomManage(int examRoomId, Map<String,Object> map) {
        Integer i = mayorService.updateExamRoom(examRoomId);
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
        List<ApplicationInformation> admit = mayorService.findAllApplicationInfo();
        for(int i=0; i<admit.size(); i++) {
            String ticket = "1600"+"00"+"00"+"00"+"00";
            ApplicationInformation temp = admit.get(i);
            String ticket0 = temp.getUserId()<10?"0"+temp.getUserId():String.valueOf(temp.getUserId());

            String ticket1;
            RoomManage room = mayorService.findRoomManageByName(temp.getCurSchool());
            if(room!=null){
                ticket1=room.getRoomId()<10?"0"+room.getRoomId():String.valueOf(room.getRoomId());
            }
            else ticket1="08";

            long l = System.currentTimeMillis();
            int a = (int)( l % 30 )+1;
            String ticket2=a<10?"0"+a:String.valueOf(a);

            l = System.currentTimeMillis();
            a = (int)( l % 30 )+1;
            String ticket3=a<10?"0"+a:String.valueOf(a);

            l = System.currentTimeMillis();
            a = (int)( l % 98 )+1;
            String ticket4=a<10?"0"+a:String.valueOf(a);

            ticket="16"+ticket0+ticket1+ticket2+ticket3+ticket4;
            temp.setExamineeNumber(ticket);
            System.out.println("userId: "+temp.getUserId()+"   生成准考证号："+temp.getExamineeNumber());
            mayorService.setAdminTicket(temp);
        }
        map.put("msg","准考证号生成成功");
        return lookTicket(map);
    }

    /*
   查看生成的准考证
   */
    @RequestMapping("/lookTicket")
    public String lookTicket(Map<String,Object> map)
    {
        List<ApplicationInformation> applicationInfo = mayorService.findAllApplicationInfo();
        map.put("applicationInfo",applicationInfo);
        return "/Mayor/create-permit";
    }

    /**
     * 去监考老师管理
     * @return
     */
    @RequestMapping("/toExamTeacher")
    public String toExamTeacher(Map<String,Object> map) {
        List<String> roomNameList = new ArrayList<>();

        List<ExamTeacher> examTeacher = mayorService.findAllExamTeacher();
        for(ExamTeacher e:examTeacher) {
            String roomName = mayorService.findExamName(e.getRoomId());
            if (roomName!=null) roomNameList.add(roomName);
        }
        map.put("roomNameList",roomNameList);
        map.put("examTeacher",examTeacher);
        return "/Mayor/exam-teacher";
    }

    /**
     * 监考老师管理
     * @return
     */
    @RequestMapping("/examTeacher")
    public String examTeacher(int teacherId, int examRoomId, Map<String,Object> map) {
        Integer i = mayorService.updateExamTeacher(teacherId,examRoomId);
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
        return "Mayor/report-violate";
    }

    /**
     * 报告违规信息
     * @return
     */
    @RequestMapping("/reportViolate")
    public String reportViolate(ViolationInfo violationInfo, Map<String,Object> map) {
        Integer i = mayorService.addViolationInfo(violationInfo);
        if(i>0){
            map.put("msg","违规信息上报成功！");
            return violateInfo(map);
        }
        map.put("msg","违规信息上报失败，请重试！");
        return toReportViolate();
    }

    /*
   违纪编码库查询
    */
    @RequestMapping("violateCode")
    public String violateCode(Map<String,Object> map){
        List<ViolationsCode> violationsCode = mayorService.findAllViolationsCode();
        map.put("violationsCode",violationsCode);
        return "administrator/violate-code";
    }

    /**
     * 违规信息查询
     * @return
     */
    @RequestMapping("/violateInfo")
    public String violateInfo(Map<String,Object> map) {
        List<ViolationInfo> violationInfo = mayorService.findAllViolationInfo();
        map.put("violationInfo",violationInfo);
        return "Mayor/violate-info";
    }

    /**
     * 去现场审核
     */
    @RequestMapping("/toPreview")
    public String toPreview(Map<String,Object> map) {
        List<ApplicationInformation> preview = mayorService.findAllApplicationInfo();
        for(int i=0; i<preview.size(); i++) {
            UserInformation user = mayorService.findUserInformationById(preview.get(i).getUserId());
            preview.get(i).setExamineeNumber(user.getUserName());//做个替换
        }
        map.put("preview",preview);
        return "Mayor/preview";
    }

    /**
     * 现场审核
     */
    @RequestMapping("/preview")
    public String preview(int enterId, int status, Map<String,Object> map) {
        Integer i = mayorService.updatePreview(enterId,status);
        if(i>0){
            map.put("msg","现场审核成功！");
            return toPreview(map);
        }
        map.put("msg","现场审核失败，请重试！");
        return toPreview(map);
    }
    
}


