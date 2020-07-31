package com.demo.controller.examinee;

import com.demo.entity.Exam;
import com.demo.entity.exam.ExamType;
import com.demo.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class ExamineeControl {

    /*
    考生查看所有已发布的考试列表
     */
    @RequestMapping("/examtypelist")
    public String examTypeList(Map<String,Object> map)
    {
        PageBean<ExamType> examPage = new PageBean<ExamType>();
        map.put("examPage",examPage);
        return "/Examinee/exam-list";
    }

    @RequestMapping("/signup")
    public String examTypeList()
    {
        return null;
    }
}
