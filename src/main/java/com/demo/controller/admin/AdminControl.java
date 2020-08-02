package com.demo.controller.admin;

import com.demo.controller.UrlController;
import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.UserInformation;
import com.demo.service.admin.AdminServe;
import com.demo.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/examOffice")
public class AdminControl {

    @Autowired
    private AdminServe adminServe;

    @RequestMapping(value = {"","index"})
    public String index(){return "common/home";}

    /*
    查询所有考试类型信息
     */
    @RequestMapping("examType")
    public String examType(Map<String,Object> map){
        List<ExamType> examType = adminServe.findAllExamType();
        map.put("examType",examType);
        return "/administrator/exam-type";
    }

    /*
    前往添加考试类型信息
     */
    @RequestMapping("toExamTypeAdd")
    public String toExamTypeAdd(){
        return "/administrator/exam-type-add";
    }

    /*
    添加考试类型信息
     */
    @RequestMapping("examTypeAdd")
    public String examTypeAdd(Map<String,Object> map, ExamType examType){
        Integer i = adminServe.addExamType(examType);
        if(i>0){
            map.put("msg","考试类型信息添加成功！");
            return "/administrator/exam-type";
        }
        map.put("msg","考试类型信息添加失败，请重试！");
        return "/administrator/exam-type-add";
    }

    /*
    前往更新考试类型信息页面
     */
    @RequestMapping("toExamTypeUpdate")
    public String toExamTypeUpdate(int typeId, Map<String,Object> map){
        ExamType updateType = adminServe.findExamTypeById(typeId);
        map.put("updateType",updateType);
        return "/administrator/exam-type-update";
    }

    /*
    更新考试类型信息
     */
    @RequestMapping("examTypeUpdate")
    public String examTypeUpdate(Map<String,Object> map, ExamType examType){
        Integer i = adminServe.updateExamType(examType);
        if(i>0){
            map.put("msg","考试类型信息更新成功！");
            return "/administrator/exam-type";
        }
        map.put("msg","考试类型信息更新失败，请重试！");
        return toExamTypeUpdate(examType.getTypeId(),map);
    }

    /*
    删除考试类型信息
     */
    @RequestMapping("examTypeDelete")
    public String examTypeDelete(int typeId, Map<String,Object> map){
        Integer i = adminServe.deleteExamType(typeId);
        if(i>0){
            map.put("msg","考试类型信息删除成功！");
            return "/administrator/exam-type";
        }
        map.put("msg","考试类型信息删除失败，请重试！");
        return "/administrator/exam-type";
    }

    /*
    前往发布考试信息页面
     */
    @RequestMapping("toPublishExam")
    public String toPublishExam(){
        return "/administrator/publish-exam";
    }

    /*
    发布考试信息
     */
    @RequestMapping("publishExam")
    public String publishExam(){
        return "/administrator/exam-info";
    }

    /*
    查询所有发布的考试信息
     */
    @RequestMapping("examInfo")
    public String examInfo(){
        return "/administrator/exam-info";
    }

    /*
    前往评卷管理页面
     */
    @RequestMapping("toTestPaperPlan")
    public String toTestPaperPlan(){
        return "/administrator/test-paper-plan";
    }

    /*
    前往添加评卷管理页面
     */
    @RequestMapping("toTestPaperPlanAdd")
    public String toTestPaperPlanAdd(){
        return "/administrator/test-paper-plan-add";
    }

    /*
    前往更新评卷管理页面
     */
    @RequestMapping("toTestPaperPlanUpdate")
    public String toTestPaperPlanUpdate(){
        return "/administrator/test-paper-plan-update";
    }

    /*
    添加评卷管理
     */
    @RequestMapping("testPaperPlanAdd")
    public String testPaperPlanAdd(){
        return "/administrator/test-paper-plan";
    }

    /*
    更新评卷管理
     */
    @RequestMapping("testPaperPlanUpdate")
    public String testPaperPlanUpdate(){
        return "/administrator/test-paper-plan";
    }

    /*
    删除评卷管理
     */
    @RequestMapping("testPaperPlanDelete")
    public String testPaperPlanDelete(){
        return "/administrator/test-paper-plan";
    }

    /*
    违纪编码库查询
     */
    @RequestMapping("violateCode")
    public String violateCode(){
        return "/administrator/violate-code";
    }

    /*
    处罚编码库查询
     */
    @RequestMapping("punishCode")
    public String punishCode(){
        return "/administrator/punish-code";
    }

    /*
    前往违纪记录管理
     */
    @RequestMapping("violateRecords")
    public String violateRecords(){
        return "/administrator/violate-records";
    }

    /*
    违纪记录管理
     */
    @RequestMapping("violateHandle")
    public String violateHandle(){
        return "/administrator/violate-records";
    }

    /*
    前往成绩管理页面
     */
    @RequestMapping("/toGradesManage")
    public String toGradesManage()
    {
        return "/administrator/grades-manage";
    }

    /*
    成绩管理
     */
    @RequestMapping("/gradesManage")
    public String gradesManage()
    {
        return "/administrator/grades-manage";
    }
}
