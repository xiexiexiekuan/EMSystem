package com.demo.controller.examinee;

import com.demo.controller.UrlController;
import com.demo.entity.Exam;
import com.demo.entity.exam.ApplicationInformation;
import com.demo.entity.exam.ExamType;
import com.demo.entity.exam.PublishExam;
import com.demo.entity.exam.UserInformation;
import com.demo.service.ExamService;
import com.demo.service.admin.AdminServe;
import com.demo.service.examinee.ExamineeServe;
import com.demo.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class ExamineeControl {

    //获取配置文件属性
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    private ExamineeServe examineeServe;

    /*
    考生查看所有已发布的考试列表
     */
    @RequestMapping("/examList")
    public String examList(@RequestParam(name="currentPage",defaultValue ="1")String currentPage, Map<String,Object> map)
    {
        PageBean<ExamType> examPage=examineeServe.findByPage(Integer.parseInt(currentPage),pageSize);
        map.put("examPage",examPage);
        return "/Examinee/exam-list";
    }

    /*
    选择一个考试去报名
     */
    @RequestMapping("/toSignUp")
    public String toSignUp(int typeId, Map<String,Object> map)
    {
        UserInformation studentInfo = UrlController.currentUser;//获取考生当前信息
        PublishExam publishExam = examineeServe.findPublishExamByTypeId(typeId);
        map.put("studentInfo",studentInfo);
        map.put("publishExam",publishExam);
        return "/Examinee/sign-up";
    }

    /*
    确认报名，即向后台提交报名信息
     */
    @RequestMapping("/signUp")
    public String signUp(ApplicationInformation applicationInfo, Map<String,Object> map)
    {
        if(applicationInfo.getStuType().equals("应用型")){
            Integer i = examineeServe.findWhitelistHaveStu(applicationInfo.getUserId());
            if(i!=1){
                map.put("msg","报名失败，用户是不具备自主报名的应用型考生！");
                return examList("1",map);
            }
        }
        Integer i = examineeServe.addApplicationInformation(applicationInfo);
        if(i>0){
            map.put("msg","报名考试成功！");
            return examList("1",map);
        }
        map.put("msg","报名考试失败，请重试！");
        return examList("1",map);
    }

    /*
    进入考试管理列表    待审核
     */
    @RequestMapping("/toWaitAudit")
    public String toWaitAudit(Map<String,Object> map)
    {
        List<ApplicationInformation> applicationInfo = examineeServe.findWaitAuditApplication();
        map.put("applicationInfo",applicationInfo);
        return "/Examinee/wait-audit";
    }

    /*
    进入考试管理列表    已审核
     */
    @RequestMapping("/toAlreadyAudit")
    public String toAlreadyAudit(Map<String,Object> map)
    {
        List<ApplicationInformation> applicationInfo = examineeServe.findAlreadyAuditApplication();
        map.put("applicationInfo",applicationInfo);
        return "/Examinee/already-audit";
    }

    /*
   选择报考后，确认报考
    */
    @RequestMapping("/confirmApply")
    public String confirmApply(@RequestParam("enterId")int enterId, @RequestParam("wantSchool")String wantSchool, Map<String,Object> map)
    {
        Integer i = examineeServe.confirmApply(enterId, wantSchool);
        if(i>0){
            map.put("msg","报考成功！");
            return toAlreadyAudit(map);
        }
        map.put("msg","报考失败，请重试！");
        return toAlreadyAudit(map);
    }

    /*
    进入考试管理列表    未支付
     */
    @RequestMapping("/toWaitPay")
    public String toWaitPay(Map<String,Object> map)
    {
        List<ApplicationInformation> applicationInfo = examineeServe.findWaitPayApplication();
        map.put("applicationInfo",applicationInfo);
        return "/Examinee/wait-pay";
    }

    /*
    支付
     */
    @RequestMapping("/payForExam")
    public String payForExam(@RequestParam("enterId")int enterId, Map<String,Object> map)
    {
        Integer i = examineeServe.payForExam(enterId);
        if(i>0){
            map.put("msg","支付成功！");
            return toWaitPay(map);
        }
        map.put("msg","支付失败，请重试！");
        return toWaitPay(map);
    }

    /*
    进入考试管理列表    已支付
     */
    @RequestMapping("/toAlreadyPay")
    public String toAlreadyPay(Map<String,Object> map)
    {
        List<ApplicationInformation> applicationInfo = examineeServe.findAlreadyPayApplication();
        map.put("applicationInfo",applicationInfo);
        return "/Examinee/already-pay";
    }

    /*
    成绩查询
     */
    @RequestMapping("/inquireGrades")
    public String inquireGrades(Map<String,Object> map)
    {
        List<ApplicationInformation> grades = examineeServe.inquireGrades();
        map.put("grades",grades);
        return "/Examinee/inquire-grades";
    }

    /*
    违纪查询
     */
    @RequestMapping("/inquireViolation")
    public String inquireViolation(Map<String,Object> map)
    {
        List<ApplicationInformation> violation = examineeServe.inquireViolation();
        map.put("violation",violation);
        return "/Examinee/inquire-violation";
    }

    /*
    准考证
     */
    @RequestMapping("/admissionTicket")
    public String admissionTicket(Map<String,Object> map)
    {
        return "/Examinee/admission-ticket";
    }

}
