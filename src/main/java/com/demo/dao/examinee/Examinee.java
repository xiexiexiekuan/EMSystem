package com.demo.dao.examinee;

import com.demo.entity.exam.ApplicationInformation;
import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.PublishExam;
import com.demo.entity.exam.ViolationInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Examinee {

    @Select("select * from ExamType where typeId in (select typeId from PublishExam group by typeId)")
    public List<ExamType> findExamListAll();

    @Select("select count(*) from PublishExam")
    public Integer countExamList();

    @Select("select * from PublishExam where typeId=#{typeId}")
    public PublishExam findPublishExamByTypeId(int typeId);

    @Select("select * from PublishExam where publishId=#{publishId}")
    public PublishExam findPublishExamByPublishId(int publishId);

    @Select("select * from Whitelist where userId=#{userId}")
    public Integer findWhitelistHaveStu(int userId);

    @Insert("insert ApplicationInformation(userId,adminNumber,publishId,examineePhoto,curSchool,stuType,previewStatus,applyStatus,payStatus" +
            ",examStatus) values(#{userId},#{adminNumber},#{publishId},#{examineePhoto},#{curSchool},#{stuType},#{previewStatus}" +
            ",#{applyStatus},#{payStatus},#{examStatus})")
    @Options(useGeneratedKeys=true, keyProperty="enterId", keyColumn="enterId")
    public Integer addApplicationInformation(ApplicationInformation applicationInfo);

    @Select("select * from ApplicationInformation where previewStatus=-1 and userId=#{userId}")
    public List<ApplicationInformation> findWaitAuditApplication(int userId);

    @Select("select * from ApplicationInformation where previewStatus<>-1 and userId=#{userId}")
    public List<ApplicationInformation> findAlreadyAuditApplication(int userId);

    @Update("update ApplicationInformation set wantSchool=#{wantSchool},applyStatus=1 where enterId=#{enterId}")
    public Integer confirmApply(int enterId, String wantSchool);

    @Select("select * from ApplicationInformation where payStatus=0 and applyStatus=1 and userId=#{userId}")
    public List<ApplicationInformation> findWaitPayApplication(int userId);

    @Update("update ApplicationInformation set payStatus=1 where enterId=#{enterId}")
    public Integer payForExam(int enterId);

    @Select("select * from ApplicationInformation where payStatus=1 and applyStatus=1 and userId=#{userId}")
    public List<ApplicationInformation> findAlreadyPayApplication(int userId);

    @Select("select * from ApplicationInformation where examStatus=1 and userId=#{userId}")
    public List<ApplicationInformation> inquireGrades(int userId);

    @Select("select * from ViolationInfo where userId=#{userId}")
    public List<ViolationInfo> inquireViolation(int userId);

    @Select("select * from ApplicationInformation where payStatus=1 and examStatus=0 and userId=#{userId}")
    public List<ApplicationInformation> admissionTicket(int userId);

    @Select("select * from ApplicationInformation where enterId=#{enterId}")
    public ApplicationInformation findApplicationInfoById(int enterId);

    @Select("select * from ExamType where typeId=#{typeId}")
    public ExamType findExamTypeById(int typeId);
}
