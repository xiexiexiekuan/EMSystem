package com.demo.controller.admin;

import com.demo.entity.exam.*;
import com.demo.service.admin.AdminServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            return examType(map);
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
            return examType(map);
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
            return examType(map);
        }
        map.put("msg","考试类型信息删除失败，请重试！");
        return examType(map);
    }

    /*
    前往发布考试信息页面
     */
    @RequestMapping("toPublishExam")
    public String toPublishExam(){
        return "administrator/publish-exam";
    }

    /*
    发布考试信息
     */
    @RequestMapping("publishExam")
    public String publishExam(PublishExam exam, Map<String,Object> map){
        System.out.println(exam);
        Integer h = adminServe.findPublishExamByTypeId(exam.getTypeId());//同一种类型考试只能发布一次
        if(h!=null){//如果没有查询到结果，会返回一个空指针给h
            map.put("msg","本类型考试已经发布！");
            return toPublishExam();
        }
        Integer i = adminServe.publishExam(exam);
        if(i>0){
            map.put("msg","考试信息发布成功！");
            return examInfo(map);
        }
        map.put("msg","考试信息发布失败，请重试！");
        return toPublishExam();
    }

    /*
    查询所有发布的考试信息
     */
    @RequestMapping("examInfo")
    public String examInfo(Map<String,Object> map){
        List<PublishExam> publichExam = adminServe.findAllPublishExam();
        map.put("publichExam",publichExam);
        return "administrator/exam-info";
    }

    /*
    前往评卷管理页面
     */
    @RequestMapping("toTestPaperPlan")
    public String toTestPaperPlan(Map<String,Object> map){
        List<JudgingPlan> judgingPlan = adminServe.findAllJudgingPlan();
        map.put("judgingPlan",judgingPlan);
        return "administrator/test-paper-plan";
    }

    /*
    前往添加评卷管理页面
     */
    @RequestMapping("toTestPaperPlanAdd")
    public String toTestPaperPlanAdd(){
        return "administrator/test-paper-plan-add";
    }

    /*
    前往更新评卷管理页面
     */
    @RequestMapping("toTestPaperPlanUpdate")
    public String toTestPaperPlanUpdate(int planCode, Map<String,Object> map){
        JudgingPlan updatePlan = adminServe.findJudgingPlanByCode(planCode);
        map.put("updatePlan",updatePlan);
        return "administrator/test-paper-plan-update";
    }

    /*
    添加评卷管理
     */
    @RequestMapping("testPaperPlanAdd")
    public String testPaperPlanAdd(Map<String,Object> map, JudgingPlan judgingPlan){
        Integer i = adminServe.addJudgingPlan(judgingPlan);
        if(i>0){
            map.put("msg","评卷管理计划添加成功！");
            return toTestPaperPlan(map);
        }
        map.put("msg","评卷管理计划添加失败，请重试！");
        return toTestPaperPlanAdd();
    }

    /*
    更新评卷管理
     */
    @RequestMapping("testPaperPlanUpdate")
    public String testPaperPlanUpdate(Map<String,Object> map, JudgingPlan judgingPlan){
        Integer i = adminServe.updateJudgingPlan(judgingPlan);
        if(i>0){
            map.put("msg","评卷管理计划更新成功！");
            return toTestPaperPlan(map);
        }
        map.put("msg","评卷管理计划更新失败，请重试！");
        return toTestPaperPlanUpdate(judgingPlan.getPlanCode(),map);
    }

    /*
    删除评卷管理
     */
    @RequestMapping("testPaperPlanDelete")
    public String testPaperPlanDelete(int planCode, Map<String,Object> map){
        Integer i = adminServe.deleteJudgingPlan(planCode);
        if(i>0){
            map.put("msg","评卷管理计划删除成功！");
            return toTestPaperPlan(map);
        }
        map.put("msg","评卷管理计划删除失败，请重试！");
        return toTestPaperPlan(map);
    }

    /*
    违纪编码库查询
     */
    @RequestMapping("violateCode")
    public String violateCode(Map<String,Object> map){
        List<ViolationsCode> violationsCode = adminServe.findAllViolationsCode();
        map.put("violationsCode",violationsCode);
        return "administrator/violate-code";
    }

    /*
    处罚编码库查询
     */
    @RequestMapping("punishCode")
    public String punishCode(Map<String,Object> map){
        List<PenaltyCode> penaltyCode = adminServe.findAllPenaltyCode();
        map.put("penaltyCode",penaltyCode);
        return "administrator/punish-code";
    }

    /*
    前往违纪记录管理
     */
    @RequestMapping("violateRecords")
    public String violateRecords(Map<String,Object> map){
        List<ViolationInfo> violationInfo = adminServe.findAllViolationInfo();
        map.put("violationInfo",violationInfo);
        return "administrator/violate-records";
    }

    /*
    违纪记录管理
     */
    @RequestMapping("violateHandle")
    public String violateHandle(ViolationInfo violationInfo, Map<String,Object> map){
        Integer i = adminServe.handleViolationInfo(violationInfo);
        if(i>0){
            map.put("msg","违纪记录处理成功！");
            return violateRecords(map);
        }
        map.put("msg","违纪记录处理失败，请重试！");
        return violateRecords(map);
    }

    /*
    前往成绩管理页面
     */
    @RequestMapping("/toGradesManage")
    public String toGradesManage(Map<String,Object> map)
    {
        List<ApplicationInformation> gradesInfo = adminServe.findAllGradesInfo();
        for(int i=0; i<gradesInfo.size(); i++){
            Integer isViolate = adminServe.findViolationInfoByUserId(gradesInfo.get(i).getUserId());//依次查找每个学生是否有违规记录
            if(isViolate==null) gradesInfo.get(i).setPayStatus(0);//ExamStatus原为开考状态，在这里用为是否违规
            else gradesInfo.get(i).setPayStatus(1);
        }
        List<ExamType> examMenu = adminServe.findExamMenu();
        map.put("examMenu",examMenu);
        map.put("gradesInfo",gradesInfo);
        return "administrator/grades-manage";
    }

    /*
    前往成绩管理页面--只管理一种考试类型--此接口在菜单栏中调用
     */
    @RequestMapping("/toGradesManageOne")
    public String toGradesManage(int typeId, Map<String,Object> map)
    {
        List<ApplicationInformation> gradesInfo = adminServe.findOneGradesInfo(typeId);
        for(int i=0; i<gradesInfo.size(); i++){
            int isViolate = adminServe.findViolationInfoByUserId(gradesInfo.get(i).getUserId());//依次查找每个学生是否有违规记录
            gradesInfo.get(i).setExamStatus(isViolate);//ExamStatus原为开考状态，在这里用为是否违规
        }
        List<ExamType> examMenu = adminServe.findExamMenu();
        map.put("examMenu",examMenu);
        map.put("gradesInfo",gradesInfo);
        return "administrator/grades-manage";
    }

    /*
    成绩管理
     */
    @RequestMapping("/gradesManage")
    public String gradesManage(@RequestParam("enterId")int enterId, @RequestParam("grades")String grades, Map<String,Object> map)
    {
        Integer i = adminServe.gradesManage(enterId, grades);
        if(i>0){
            map.put("msg","成绩信息录入成功！");
            return toGradesManage(map);
        }
        map.put("msg","成绩信息录入失败，请重试！");
        return toGradesManage(map);
    }
}
