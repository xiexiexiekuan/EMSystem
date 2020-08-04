package com.demo.dao.manager;

import com.demo.entity.Exam;
import com.demo.entity.User;
import com.demo.entity.exam.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Manager {

    //所有白名单
    @Select("select * from Whitelist")
    public List<Whitelist> findAllWhiteList();

    //查准考证号
    @Select("select certificateId from UserInformation where userId=#{userId}")
    public String findCertificateIdById(int userId);

    //插入白名单
    @Insert("insert " + "Whitelist(userId,certificateId) " + "values(#{userId},#{certificateId})")
    @Options(useGeneratedKeys=true, keyProperty="listId", keyColumn="listId")
    public Integer insertWhiteList(int userId,String certificateId);

    //更新白名单
    @Update("update Whitelist set userId = #{userId},certificateId = ${certificateId} where listId = #{listId}")
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
    @Insert("insert ExamRoomInformation(examRoomNum,examRoomLocate,roomId,userStatus)"+
            "values (#{examRoomNum},#{examRoomLocate},#{roomId},#{userStatus})")
    @Options(useGeneratedKeys=true, keyProperty="examRoomId", keyColumn="examRoomId")
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
    @Insert("insert ExamTeacher(teacherName,sex,age,phone,position,roomId,examRoomId)"+
            "values (#{teacherName},#{sex},#{age},#{phone},#{position},#{roomId})")
    @Options(useGeneratedKeys=true, keyProperty="teacherId", keyColumn="teacherId")
    public Integer insertExamTeacher(ExamTeacher examTeacher);

    //更新考务老师信息
    @Update("update ExamTeacher set teacherId=#{teacherId},teacherName=#{teacherName}," +
            "sex=#{sex},age=#{age},phone=#{phone},position=#{position},roomId=#{roomId}")
    public Integer updateExamTeacher(ExamTeacher examTeacher);

    //删除考务老师信息
    @Delete("delete from ExamTeacher where teacherId=#{teacherId}")
    public Integer deleteExamTeacher(int examTeacherId);


    /**
     * 报名报考相关操作
     */

    //查找本院校的所有未报名学生
    @Select("select * from UserInformation where UserInformation.userId not in (select distinct userId from ApplicationInformation" +
            "where publishId = #{publishId})" +
            " and role = '3'  and institute = #{roomName}")
    public List<UserInformation> findStudentNotEnter(String roomName);

    //查找审核状态
    @Select("select UserInformation.*,ApplicationInformation.previewStatus from UserInformation ,ApplicationInformation where UserInformation.userId = ApplicationInformation.userId" +
            " and UserInformation.role = 3  and UserInformation.institute = #{roomName}")
    public List<UserInformation> findStudentPreviewStatus(String rooName);

    //查找本院校所有审核通过的学生
    @Select("select * from ApplicationInformation where ApplicationInformation.userId in (select userId from UserInformation where" +
            " role = 3  and institute = #{roomName}) and previewStatus = 1 ")
    public List<ApplicationInformation> findPassPreview(String roomName);

    @Select("select * from ApplicationInformation where ApplicationInformation.userId in (select userId from UserInformation where" +
            " role = 3  and institute = #{roomName}) and applyStatus = 1 and payStatus = 0")
    //查找本院校所有报考通过而且没有缴费的
    public List<ApplicationInformation> findNotPay(String roomName);


    @Update("update ApplicationInformation set publishId = ${publishId}")
    public void setPublishId(int publishId);

    //插入报名信息
    @Insert("insert ApplicationInformation(userId,examineeNumber,publishId,examineePhoto,curSchool,stuType,previewStatus,applyStatus,payStatus" +
            ",examStatus,wantSchool) values(#{userId},#{examineeNumber},#{publishId},#{examineePhoto},#{curSchool},#{stuType},#{previewStatus}" +
            ",#{applyStatus},#{payStatus},#{examStatus},#{wantSchool})")
    @Options(useGeneratedKeys=true, keyProperty="enterId", keyColumn="enterId")
    public Integer insertEnter(ApplicationInformation applicationInformation);

    //更新报考信息
    @Update("update ApplicationInformation set applyStatus=1 where userId=#{userId}")
    public Integer updateApply(int enterId);

    //更新缴费信息
    @Update("update ApplicationInformation set payStatus=1 where userId=#{userId}")
    public Integer updatePay(int enterId);

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
