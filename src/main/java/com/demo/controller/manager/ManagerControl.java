package com.demo.controller.manager;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
public class ManagerControl {
    
    /*
    个人信息
     */
    @RequestMapping("/personalinfo")
    public String personalInfo()
    {
        return "/Manager/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/personalinfoupdate")
    public String personalInfoUpdate()
    {
        return "/Manager/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalupdate")
    public String personalUpdate()
    {
        return "/Manager/personal-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentinfo")
    public String studentinfo()
    {
        return "/Manager/student-info";
    }

    /*
    去更新考生信息页面
     */
    @RequestMapping("/studentinfoupdate")
    public String studentInfoUpdate()
    {
        return "/Manager/student-info-update";
    }

    /*
    更新考生信息
     */
    @RequestMapping("/studentupdate")
    public String studentUpdate()
    {
        return "/Manager/student-info";
    }

    /*
    去添加考生信息页面
     */
    @RequestMapping("/studentinfoadd")
    public String studentInfoadd()
    {
        return "/Manager/student-info-add";
    }

    /*
    添加考生信息
     */
    @RequestMapping("/studentadd")
    public String studentadd()
    {
        return "/Manager/student-info";
    }

    /*
    删除考生信息
     */
    @RequestMapping("/studentdelete")
    public String studentdelete()
    {
        return "/Manager/student-info";
    }

    /*
    前往集体报名页面
     */
    @RequestMapping("/groupenter")
    public String groupenter()
    {
        return "/Manager/group-enter";
    }

    /*
   集体报名
    */
    @RequestMapping("/groupentering")
    public String groupentering()
    {
        return "/Manager/group-enter";
    }

    /*
    前往集体报考页面
     */
    @RequestMapping("/groupapply")
    public String groupapply()
    {
        return "/Manager/group-apply";
    }

    /*
   集体报考
    */
    @RequestMapping("/groupapplying")
    public String groupapplying()
    {
        return "/Manager/group-apply";
    }

    /*
   前往集体缴费页面
    */
    @RequestMapping("/grouppay")
    public String grouppay()
    {
        return "/Manager/group-pay";
    }

    /*
   集体缴费
    */
    @RequestMapping("/grouppaying")
    public String grouppaying()
    {
        return "/Manager/group-pay";
    }

    /*
    报考信息查询
   */
    @RequestMapping("/examinfomation")
    public String examinfomation()
    {
        return "/Manager/exam-infomation";
    }

    /*
    白名单信息
     */
    @RequestMapping("/whitelist")
    public String whitelist()
    {
        return "/Manager/whitelist";
    }

    /*
    去更新白名单信息页面
     */
    @RequestMapping("/whitelistupdate")
    public String whitelistUpdate()
    {
        return "/Manager/whitelist-update";
    }

    /*
    更新白名单信息
     */
    @RequestMapping("/whiteupdate")
    public String whiteUpdate()
    {
        return "/Manager/whitelist";
    }

    /*
    去添加白名单信息页面
     */
    @RequestMapping("/whitelistadd")
    public String whitelistadd()
    {
        return "/Manager/whitelist-add";
    }

    /*
    添加白名单信息
     */
    @RequestMapping("/whiteadd")
    public String whiteadd()
    {
        return "/Manager/whitelist";
    }

    /*
    删除白名单信息
     */
    @RequestMapping("/whitedelete")
    public String whitedelete()
    {
        return "/Manager/whitelist";
    }

    /*
    考场信息
     */
    @RequestMapping("/examroom")
    public String examroom()
    {
        return "/Manager/exam-room";
    }

    /*
    去更新考场信息页面
     */
    @RequestMapping("/examroomupdate")
    public String examroomUpdate()
    {
        return "/Manager/exam-room-update";
    }

    /*
    更新考场信息
     */
    @RequestMapping("/roomupdate")
    public String roomUpdate()
    {
        return "/Manager/exam-room";
    }

    /*
    去添加考场信息页面
     */
    @RequestMapping("/examroomadd")
    public String examroomadd()
    {
        return "/Manager/exam-room-add";
    }

    /*
    添加考场信息
     */
    @RequestMapping("/roomadd")
    public String roomadd()
    {
        return "/Manager/exam-room";
    }

    /*
    删除考场信息
     */
    @RequestMapping("/roomdelete")
    public String roomdelete()
    {
        return "/Manager/exam-room";
    }

    /*
    考务老师信息
     */
    @RequestMapping("/examteacherinfo")
    public String examteacherinfo()
    {
        return "/Manager/examteacher-info";
    }

    /*
    去更新考务老师信息页面
     */
    @RequestMapping("/examteacherinfoupdate")
    public String examteacherinfoUpdate()
    {
        return "/Manager/examteacher-info-update";
    }

    /*
    更新考务老师信息
     */
    @RequestMapping("/examteacherupdate")
    public String examteacherUpdate()
    {
        return "/Manager/examteacher-info";
    }

    /*
    去添加考务老师信息页面
     */
    @RequestMapping("/examteacherinfoadd")
    public String examteacherinfoadd()
    {
        return "/Manager/examteacher-info-add";
    }

    /*
    添加考务老师信息
     */
    @RequestMapping("/examteacheradd")
    public String examteacheradd()
    {
        return "/Manager/examteacher-info";
    }

    /*
    删除考务老师信息
     */
    @RequestMapping("/examteacherdelete")
    public String examteacherdelete()
    {
        return "/Manager/examteacher-info";
    }
}
