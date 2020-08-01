package com.demo.dao.admin;

import com.demo.entity.exam.ExamType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin {

    @Select("select * from ExamType")
    public ExamType findAllExamType();

    @Insert("insert ExamType(typeName,certificate,userId,createTime) values(#{typeName},#{certificate},#{userId},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="typeId", keyColumn="typeId")
    public Integer addExamType(ExamType examType);
}
