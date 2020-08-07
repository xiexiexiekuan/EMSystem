package com.demo.service.mayor;

import com.demo.controller.UrlController;
import com.demo.dao.mayor.Mayor;
import com.demo.entity.exam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MayorServe {

    @Autowired
    private Mayor mayor;


    /*
     查询所有考点信息
    */
    public List<RoomManage> findAllRoomManage(){
        return mayor.findAllRoomManage();
    }

    /*
    添加考点信息
     */
    public Integer addRoomManage(RoomManage roomManage){
        roomManage.setNumberEnd(0);
        roomManage.setNumberStart(0);
        roomManage.setRoomNumber(0);
        return mayor.addRoomManage(roomManage);
    }

    /*
    根据ID查询对应的考点信息
     */
    public RoomManage findRoomManageById(int roomId){
        return mayor.findRoomManageById(roomId);
    }

    /*
    根据NAME查询对应的考点信息
     */
    public RoomManage findRoomManageByName(String name){
        return mayor.findRoomManageByName(name);
    }

    /*
    更新考点信息---考点的编号和名字不可修改
     */
    public Integer updateRoomManage(RoomManage roomManage){
        return mayor.updateRoomManage(roomManage);
    }

    /*
    删除考点信息
     */
    public Integer deleteRoomManage(int roomId){
        return mayor.deleteRoomManage(roomId);
    }

    /*
     查询所有违纪信息
    */
    public List<ViolationInfo> findAllViolationInfo(){
        return mayor.findAllViolationInfo();
    }

    /*
        查询所有违纪编码库
       */
    public List<ViolationsCode> findAllViolationsCode(){
        return mayor.findAllViolationsCode();
    }

    /*
    上报违纪信息
     */
    public Integer addViolationInfo(ViolationInfo violationInfo){
        violationInfo.setPreviewStatus(0);
        violationInfo.setReportMan(UrlController.currentUser.getUserName());
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        violationInfo.setReportTime(timeStamp);
        return mayor.addViolationInfo(violationInfo);
    }

    /*
    现场审核时----查询所有报名信息
     */
    public List<ApplicationInformation> findAllApplicationInfo(){
        return mayor.findAllApplicationInfo();
    }

    /*
    现场审核时----根据Id查找学生
     */
    public UserInformation findUserInformationById(int userId){
        return mayor.findUserInformationById(userId);
    }

    /*
    现场审核
     */
    public Integer updatePreview(int enterId, int status){
        return mayor.updatePreview(enterId,status);
    }

    /*
     查询所有考场信息
    */
    public List<ExamRoomInformation> findAllExamRoomInformation(){
        return mayor.findAllExamRoomInformation();
    }

    /*
    更新考场信息
     */
    public Integer updateExamRoom(int examRoomId){
        int status = 1;
        return mayor.updateExamRoom(examRoomId, status);
    }

    /*
     查询所有老师信息
    */
    public List<ExamTeacher> findAllExamTeacher(){
        return mayor.findAllExamTeacher();
    }

    /*
    更新考务老师
     */
    public Integer updateExamTeacher(int teacherId, int examRoomId){
        return mayor.updateExamTeacher(teacherId,examRoomId);
    }

    /*
    更新准考证号
     */
    public void setAdminTicket(ApplicationInformation temp){
        mayor.setAdminTicket(temp);
    }
}
