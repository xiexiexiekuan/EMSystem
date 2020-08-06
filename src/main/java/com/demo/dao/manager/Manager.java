package com.demo.dao.manager;

import com.demo.entity.exam.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Manager {

    //报考信息
    @Select("select * from ApplicationInformation")
    List<ApplicationInformation> findApplicationInformation();
    //所有白名单
    @Select("select * from Whitelist")
    List<Whitelist> findAllWhiteList();

    //查准考证号
    @Select("select certificateId from UserInformation where userId=#{userId}")
    String findCertificateIdById(int userId);

    //插入白名单
    @Insert("insert " + "Whitelist(userId,certificateId) " + "values(#{userId},#{certificateId})")
    @Options(useGeneratedKeys=true, keyProperty="listId", keyColumn="listId")
    Integer insertWhiteList(int userId, String certificateId);

    //更新白名单
    @Update("update Whitelist set userId = #{userId},certificateId = ${certificateId} where listId = #{listId}")
    Integer updateWhiteList(Whitelist whitelist);

    //删除白名单
    @Delete("delete from Whitelist where listId=#{listId}")
    Integer deleteWhiteList(int listId);

    //所有考场信息
    @Select("select * from ExamRoomInformation")
    List<ExamRoomInformation> findAllExamRoom();

    //查找单个考场
    @Select("select * from ExamRoomInformation where examRoomId = #{examRoomId}")
    ExamRoomInformation findExamRoomById(int examRoomId);

    //查找当前考点
    @Select("select roomId from RoomInformation where roomName = #{roomName}")
    Integer findRoomIdByName(String roomName);

    //插入考场信息
    @Insert("insert ExamRoomInformation(examRoomNum,examRoomLocate,roomId,userStatus)"+
            "values (#{examRoomNum},#{examRoomLocate},#{roomId},#{userStatus})")
    @Options(useGeneratedKeys=true, keyProperty="examRoomId", keyColumn="examRoomId")
    Integer insertExamRoom(ExamRoomInformation examRoomInformation);

    //更新考场信息
    @Update("update ExamRoomInformation set examRoomId=#{examRoomId},examRoomNum=#{examRoomNum}," +
            "roomId=#{roomId},RoomLocate=#{examRoomLocate},userStatus=#{userStatus}")
    Integer updateExamRoom(ExamRoomInformation examRoomInformation);

    //删除考场信息
    @Delete("delete from ExamRoomInformation where examRoomId=#{examRoomId}")
    Integer deleteExamRoom(int examRoomId);

    //所有考务老师信息
    @Select("select * from ExamTeacher")
    List<ExamTeacher> findAllExamTeacher();

    //查找单个考务老师
    @Select("select * from ExamTeacher where teacherId = #{teacherId}")
    ExamTeacher findExamTeacherById(int examTeacherId);

    //插入考务老师信息
    @Insert("insert ExamTeacher(teacherName,sex,age,phone,position,roomId,examRoomId)"+
            "values (#{teacherName},#{sex},#{age},#{phone},#{position},#{roomId})")
    @Options(useGeneratedKeys=true, keyProperty="teacherId", keyColumn="teacherId")
    Integer insertExamTeacher(ExamTeacher examTeacher);

    //更新考务老师信息
    @Update("update ExamTeacher set teacherId=#{teacherId},teacherName=#{teacherName}," +
            "sex=#{sex},age=#{age},phone=#{phone},position=#{position},roomId=#{roomId}")
    Integer updateExamTeacher(ExamTeacher examTeacher);

    //删除考务老师信息
    @Delete("delete from ExamTeacher where teacherId=#{teacherId}")
    Integer deleteExamTeacher(int examTeacherId);


    /**
     * 报名报考相关操作
     */

    //查找本院校的所有未报名学生
    @Select("select * from UserInformation where UserInformation.userId not in (select distinct userId from ApplicationInformation" +
            " where publishId = #{publishId}) and role = 3  and institute = #{roomName}")
    List<UserInformation> findStudentNotEnter(int publishId, String roomName);

    //查找审核状态
    @Select("select UserInformation.*,ApplicationInformation.previewStatus from UserInformation ,ApplicationInformation where UserInformation.userId = ApplicationInformation.userId" +
            " and UserInformation.role = 3  and UserInformation.institute = #{roomName}")
    List<UserInformation> findStudentPreviewStatus(String rooName);

    //查找本院校所有审核通过的学生
    @Select("select * from ApplicationInformation where ApplicationInformation.userId in (select userId from UserInformation where" +
            " role = 3  and institute = #{roomName}) and previewStatus = 1 ")
    List<ApplicationInformation> findPassPreview(String roomName);

    @Select("select * from ApplicationInformation where ApplicationInformation.userId in (select userId from UserInformation where" +
            " role = 3  and institute = #{roomName}) and applyStatus = 1 and payStatus = 0")
    //查找本院校所有报考通过而且没有缴费的
    List<ApplicationInformation> findNotPay(String roomName);


    @Update("update ApplicationInformation set publishId = ${publishId}")
    void setPublishId(int publishId);

    //插入报名信息
    @Insert("insert ApplicationInformation(userId,examineeNumber,publishId,examineePhoto,curSchool,stuType,previewStatus,applyStatus,payStatus" +
            ",examStatus,wantSchool) values(#{userId},#{examineeNumber},#{publishId},#{examineePhoto},#{curSchool},#{stuType},#{previewStatus}" +
            ",#{applyStatus},#{payStatus},#{examStatus},#{wantSchool})")
    @Options(useGeneratedKeys=true, keyProperty="enterId", keyColumn="enterId")
    Integer insertEnter(ApplicationInformation applicationInformation);

    //更新报考信息
    @Update("update ApplicationInformation set applyStatus=1 where userId=#{userId}")
    Integer updateApply(int enterId);

    //更新缴费信息
    @Update("update ApplicationInformation set payStatus=1 where userId=#{userId}")
    Integer updatePay(int enterId);


}
