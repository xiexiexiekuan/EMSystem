package com.demo.dao.admin;

import com.demo.entity.exam.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Admin {

    @Select("select * from ExamType")
    public List<ExamType> findAllExamType();

    @Insert("insert ExamType(typeName,certificate,userId,createTime) values(#{typeName},#{certificate},#{userId},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="typeId", keyColumn="typeId")
    public Integer addExamType(ExamType examType);

    @Select("select * from ExamType where typeId = #{typeId}")
    public ExamType findExamTypeById(int typeId);

    @Update("update ExamType set typeName=#{typeName},certificate=#{certificate},userId=#{userId},createTime=#{createTime} where typeId=#{typeId}")
    public Integer updateExamType(ExamType examType);

    @Delete("delete from ExamType where typeId=#{typeId}")
    public Integer deleteExamType(int typeId);

    @Select("select * from PublishExam where typeId = #{typeId}")
    public Integer findPublishExamByTypeId(int typeId);

    @Insert("insert PublishExam(typeId,registrationStarts,registrationDeadline,applyStarts,applyDeadline,confirmationStarts," +
            "confirmationDeadline,admissioncardPrintStarts,admissioncardPrintDeadline,userId,publishTime) values(#{typeId}," +
            "#{registrationStarts},#{registrationDeadline},#{applyStarts},#{applyDeadline},#{confirmationStarts}," +
            "#{confirmationDeadline},#{admissioncardPrintStarts},#{admissioncardPrintDeadline},#{userId},#{publishTime})")
    @Options(useGeneratedKeys=true, keyProperty="publishId,", keyColumn="publishId,")
    public Integer publishExam(PublishExam exam);

    @Select("select * from PublishExam")
    public List<PublishExam> findAllPublishExam();

    @Select("select * from JudgingPlan")
    public List<JudgingPlan> findAllJudgingPlan();

    @Insert("insert JudgingPlan(publishId,judgingStart,judgingEnd,schoolCode,schoolName,paperCode,paperNum) values" +
            "(#{publishId},#{judgingStart},#{judgingEnd},#{schoolCode},#{schoolName},#{paperCode},#{paperNum})")
    @Options(useGeneratedKeys=true, keyProperty="planCode", keyColumn="planCode")
    public Integer addJudgingPlan(JudgingPlan judgingPlan);

    @Select("select * from JudgingPlan where planCode = #{planCode}")
    public JudgingPlan findJudgingPlanByCode(int planCode);

    @Update("update JudgingPlan set publishId=#{publishId},judgingStart=#{judgingStart},judgingEnd=#{judgingEnd},schoolCode=#{schoolCode}" +
            ",schoolName=#{schoolName},paperCode=#{paperCode},paperNum=#{paperNum} where planCode=#{planCode}")
    public Integer updateJudgingPlan(JudgingPlan judgingPlan);

    @Delete("delete from JudgingPlan where planCode=#{planCode}")
    public Integer deleteJudgingPlan(int planCode);

    @Select("select * from ViolationsCode")
    public List<ViolationsCode> findAllViolationsCode();

    @Select("select * from PenaltyCode")
    public List<PenaltyCode> findAllPenaltyCode();

    @Select("select * from ViolationInfo")
    public List<ViolationInfo> findAllViolationInfo();

    @Update("update ViolationInfo set previewStatus=#{previewStatus},punishmentCode=#{punishmentCode},punishDescription=" +
            "#{punishDescription},punishMan=#{punishMan},punishTime=#{punishTime},processing_state=#{processing_state} " +
            "where violateRecordId=#{violateRecordId}")
    public Integer handleViolationInfo(ViolationInfo violationInfo);

    @Select("select * from ApplicationInformation")
    public List<ApplicationInformation> findAllGradesInfo();

    @Select("select * from ApplicationInformation where publishId in (select publishId from PublishExam where typeId=#{typeId})")
    public List<ApplicationInformation> findOneGradesInfo(int typeId);

    @Select("select * from ExamType where typeId in (select typeId from PublishExam group by typeId)")
    public List<ExamType> findExamMenu();

    @Select("select * from ViolationInfo where userId=#{userId}")
    public Integer findViolationInfoByUserId(int userId);

    @Update("update ApplicationInformation set examStatus=#{examStatus},grades=#{grades} where enterId=#{enterId}")
    public Integer gradesManage(int enterId, String grades, int examStatus);
}