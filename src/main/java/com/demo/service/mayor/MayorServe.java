package com.demo.service.mayor;

import com.demo.controller.UrlController;
import com.demo.dao.mayor.Mayor;
import com.demo.entity.exam.ApplicationInformation;
import com.demo.entity.exam.RoomManage;
import com.demo.entity.exam.UserInformation;
import com.demo.entity.exam.ViolationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
    上报违纪信息
     */
    public Integer addViolationInfo(ViolationInfo violationInfo){
        violationInfo.setPreviewStatus(0);
        violationInfo.setReportMan(UrlController.currentUser.getPrimaryKey());
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
}
