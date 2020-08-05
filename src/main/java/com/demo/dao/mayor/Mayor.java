package com.demo.dao.mayor;

import com.demo.entity.exam.ApplicationInformation;
import com.demo.entity.exam.RoomManage;
import com.demo.entity.exam.UserInformation;
import com.demo.entity.exam.ViolationInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mayor {

    @Select("select * from RoomManage")
    public List<RoomManage> findAllRoomManage();

    @Insert("insert RoomManage(roomName,roomAddress,roomNumber,numberStart,numberEnd) values(#{roomName},#{roomAddress},#{roomNumber},#{numberStart},#{numberEnd})")
    @Options(useGeneratedKeys=true, keyProperty="roomId", keyColumn="roomId")
    public Integer addRoomManage(RoomManage roomManage);

    @Select("select * from RoomManage where roomId = #{roomId}")
    public RoomManage findRoomManageById(int roomId);

    @Update("update RoomManage set roomAddress=#{roomAddress},roomNumber=#{roomNumber},numberStart=#{numberStart},numberEnd=#{numberEnd} where roomId=#{roomId}")
    public Integer updateRoomManage(RoomManage roomManage);

    @Delete("delete from RoomManage where roomId=#{roomId}")
    public Integer deleteRoomManage(int roomId);

    @Select("select * from ViolationInfo")
    public List<ViolationInfo> findAllViolationInfo();

    @Insert("insert ViolationInfo(userId,publishId,violationsCode,violateDescription,previewStatus,reportMan,reportTime) " +
            "values(#{userId},#{publishId},#{violationsCode},#{violateDescription},#{previewStatus},#{reportMan},#{reportTime})")
    @Options(useGeneratedKeys=true, keyProperty="violateRecordId", keyColumn="violateRecordId")
    public Integer addViolationInfo(ViolationInfo violationInfo);

    @Select("select * from ApplicationInformation")
    public List<ApplicationInformation> findAllApplicationInfo();

    @Select("select * from UserInformation where userId=#{userId}")
    public UserInformation findUserInformationById(int userId);

    @Update("update ApplicationInformation set previewStatus=#{status} where enterId=#{enterId}")
    public Integer updatePreview(int enterId, int status);
}
