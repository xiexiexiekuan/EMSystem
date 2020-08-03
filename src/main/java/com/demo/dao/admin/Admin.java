package com.demo.dao.admin;

import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.PublishExam;
import com.demo.entity.exam.UserInformation;
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

    @Insert("insert PublishExam(typeId,registrationStarts,registrationDeadline,applyStarts,applyDeadline,confirmationStarts," +
            "confirmationDeadline,admissioncardPrintStarts,admissioncardPrintDeadline,userId,publishTime) values(#{typeId}," +
            "#{registrationStarts},#{registrationDeadline},#{applyStarts},#{applyDeadline},#{confirmationStarts}," +
            "#{confirmationDeadline},#{admissioncardPrintStarts},#{admissioncardPrintDeadline},#{userId},#{publishTime})")
    @Options(useGeneratedKeys=true, keyProperty="publishId,", keyColumn="publishId,")
    public Integer publishExam(PublishExam exam);

    @Select("select * from PublishExam")
    public List<PublishExam> findAllPublishExam();
}
