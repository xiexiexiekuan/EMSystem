package com.demo.dao.mayor;

import com.demo.entity.exam.*;
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

    @Select("select * from RoomManage where roomName = #{name}")
    public RoomManage findRoomManageByName(String name);

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

    @Select("select * from ExamRoomInformation")
    public List<ExamRoomInformation> findAllExamRoomInformation();

    @Update("update ExamRoomInformation set useStatus=#{status} where examRoomId=#{examRoomId}")
    public Integer updateExamRoom(int examRoomId, int status);

    @Select("select * from ExamTeacher")
    public List<ExamTeacher> findAllExamTeacher();

    @Update("update ExamTeacher set examRoomId=#{examRoomId} where teacherId=#{teacherId}")
    public Integer updateExamTeacher(int teacherId, int examRoomId);

    @Update("update ApplicationInformation set examineeNumber=#{examineeNumber} where enterId=#{enterId}")
    public void setAdminTicket(ApplicationInformation temp);
}
