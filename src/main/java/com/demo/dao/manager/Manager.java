package com.demo.dao.manager;

import com.demo.entity.Exam;
import com.demo.entity.User;
import com.demo.entity.exam.ExamRoomInformation;
import com.demo.entity.exam.ExamTeacher;
import com.demo.entity.exam.UserInformation;
import com.demo.entity.exam.Whitelist;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Manager {

    //所有白名单
    @Select("select * from Whitelist")
    public List<Whitelist> findAllWhiteList();

    //插入白名单
    @Insert("insert" + "Whitelist(listId,userId,adminNumber" + "values(#{listId},#{userId})")
    @Options(useGeneratedKeys=true, keyProperty="listId", keyColumn="listId")
    public Integer insertWhiteList(int userId);

    //更新白名单
    @Update("update Whitelist set userID = #{userId} where listID = #{listId}")
    public Integer updateWhiteList(Whitelist whitelist);

    //删除白名单
    @Delete("delete from Whitelist where listId=#{listId}")
    public Integer deleteWhiteList(int listId);

    //所有考场信息
    @Select("select * from ExamRoomInformation")
    public List<ExamRoomInformation> findAllExamRoom();

    //查找单个考场
    @Select("select * from ExamRoomInformation where examRoomId = #{examRoomId}")
    public ExamRoomInformation findExamRoomById(int examRoomId);

    //查找当前考点
    @Select("select roomId from RoomInformation where roomName = #{roomName}")
    public Integer findRoomIdByName(String roomName);

    //插入考场信息
    @Insert("insert ExamRoomInformation(examRoomId,examRoomNum,examRoomLocate,roomId,userStatus)"+
            "values (#{examRoomId},#{examRoomNum},#{examRoomLocate},#{roomId},#{userStatus})")
    public Integer insertExamRoom(ExamRoomInformation examRoomInformation);

    //更新考场信息
    @Update("update ExamRoomInformation set examRoomId=#{examRoomId},examRoomNum=#{examRoomNum}," +
            "roomId=#{roomId},RoomLocate=#{examRoomLocate},userStatus=#{userStatus}")
    public Integer updateExamRoom(ExamRoomInformation examRoomInformation);

    //删除考场信息
    @Delete("delete from ExamRoomInformation where examRoomId=#{examRoomId}")
    public Integer deleteExamRoom(int examRoomId);

    //所有考务老师信息
    @Select("select * from ExamTeacher")
    public List<ExamTeacher> findAllExamTeacher();

    //查找单个考务老师
    @Select("select * from ExamTeacher where teacherId = #{teacherId}")
    public ExamTeacher findExamTeacherById(int examTeacherId);

    //插入考务老师信息
    @Insert("insert ExamTeacher(teacherId,teacherName,sex,age,phone,position,roomId,examRoomId)"+
            "values (#{teacherId},#{teacherName},#{sex},#{age},#{phone},#{position},#{roomId},#{examRoomId})")
    public Integer insertExamTeacher(ExamTeacher examTeacher);

    //更新考务老师信息
    @Update("update ExamTeacher set teacherId=#{teacherId},teacherName=#{teacherName}," +
            "sex=#{sex},age=#{age},phone=#{phone},position=#{position},roomId=#{roomId},examRoomId=#{examRoomId}")
    public Integer updateExamTeacher(ExamTeacher examTeacher);

    //删除考务老师信息
    @Delete("delete from ExamTeacher where teacherId=#{teacherId}")
    public Integer deleteExamTeacher(int examTeacherId);


    /**
     * 报名报考相关操作
     */

    //查找本院校的所有学生
    public List<UserInformation> findAllStudentInSchool();

    //查找本院校审核通过的学生
    public List<UserInformation> findStudentPassPreview();


    /**
     * 插入一条考生信息，默认密码与用户名一致，返回插入记录主键
     * @param user
     * @return
     */
    @Insert("insert " +
            "user(name,username,password,sex,idnumber,eduback,address,email,phone,role) " +
            "values(#{name},#{username},#{username},#{sex},#{idnumber},#{eduback},#{address.id},#{email},#{phone},2)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertExaminee(User user);

    /**
     * 删除一条考生信息
     */
    @Delete("delete from UserInformation where userId = {userId}" )
    public int deleteExaminee(User user);

    /**
     * 根据用户姓名考试号查询
     * @param name
     * @param examId
     * @return
     */
    @Select("<script>"+
            "select " +
            "distinct u.id as id,u.name as name,u.username as username,u.email as email,u.phone as phone,u.role as role,u.sex as sex,u.idnumber as idnumber,u.eduback as eduback,u.address as address" +
            " from user as u join myexam as me on u.id=me.user_id where 1=1" +
            "<if test='name!=null and name != \"\"'>" +
            "and u.name like CONCAT('%',#{name},'%')" +
            "</if>" +
            "<if test='examId!=null'>" +
            "and me.exam_id=#{examId}" +
            "</if>" +
            "</script>")
    @Results(id="addressOnly",value = {
            @Result(property="address",
                    column = "address",
                    one = @One(select = "com.demo.dao.admin.AdminDao.findAreaById")
            )
    })
    public List<User> searchByNameAndExam(@Param("name") String name, @Param("examId") Integer examId);

    /**
     * 根据用户id查找某用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("addressOnly")
    public User findUserById(@Param("id") Integer id);


    /**
     * 插入一条考生信息并设置为已支付
     * @param userId
     * @param examId
     * @return
     */
    @Insert("insert myexam(user_id,exam_id,pay) values(#{userId},#{examId},1)")
    public int insertExam(@Param("userId") Integer userId,@Param("examId") Integer examId);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set name=#{name},sex=#{sex},email=#{email},phone=#{phone},idnumber=#{idnumber}," +
            "eduback=#{eduback},address=#{address.id} where id=#{id}")
    public int updateUser(User user);
}
