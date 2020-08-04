package com.demo.controller.examinee;

import com.demo.controller.BaseController;
import com.demo.controller.UrlController;
import com.demo.entity.exam.*;
import com.demo.service.examinee.ExamineeServe;
import com.demo.util.PageBean;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class ExamineeControl extends BaseController {

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
        List<ViolationInfo> violation = examineeServe.inquireViolation();
        map.put("violation",violation);
        return "/Examinee/inquire-violation";
    }

    /*
    准考证
     */
    @RequestMapping("/admissionTicket")
    public String admissionTicket(Map<String,Object> map)
    {
        List<ApplicationInformation> admissionTicket = examineeServe.admissionTicket();
        map.put("admissionTicket",admissionTicket);
        return "/Examinee/admission-ticket";
    }

    /*
    打印准考证
     */
    @RequestMapping(method = RequestMethod.GET, value = "printTicket")
    @ResponseBody
    public void printTicket(HttpServletResponse response, @RequestParam("enterId")Integer enterId) throws Exception
    {
        String tmpFile = admissionPath;
        ApplicationInformation myticket = examineeServe.findApplicationInfoById(enterId);//查找考生个人考试数据
        PublishExam punishId = examineeServe.findPublishExamByPublishId(myticket.getPublishId());
        ExamType examName = examineeServe.findExamTypeById(punishId.getTypeId());

        //-------------模板数据Map设置开始----------------
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("examName", examName.getTypeName());
        datas.put("name", UrlController.currentUser.getUserName());
        datas.put("examNum",myticket.getAdminNumber());
        datas.put("sex", UrlController.currentUser.getSex().equals("1")?"男":"女");
        datas.put("idnumber", UrlController.currentUser.getCertificateId());
        datas.put("roomNum", "001");
        datas.put("seat", "215/325");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        if(punishId.getAdmissioncardPrintDeadline()!=null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(punishId.getAdmissioncardPrintDeadline());
            calendar.add(Calendar.DAY_OF_YEAR,2);//准考证截止日期后的第二天开始考试
            datas.put("time", sdf.format(calendar.getTime()));
        }else {
            datas.put("time", "2020年12月21日 09:00");
        }
        //--------------模板数据Map设置完毕---------------

        System.out.println("准考证模板文件读取-->");
        FileInputStream tempFileInputStream = new FileInputStream(tmpFile);//准考证模板文件读取
        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        System.out.println("替换内容-->"  );
        // 替换内容
        for (Map.Entry<String, String> entry : datas.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }
        System.out.println("<--替换内容"  );
        //导出到http响应
        String tempFileName=datas.get("name")+"-"+datas.get("examName")+"-"+"准考证.doc";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename="+tempFileName);//默认Excel名称
        response.flushBuffer();
        document.write(response.getOutputStream());
    }

}
