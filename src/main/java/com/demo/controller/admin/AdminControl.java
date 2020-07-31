package com.demo.controller.admin;

import com.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminControl {

    /*
    查询所有考试类型信息
     */
    @RequestMapping("examtype")
    public String examtype(){
        return "/administrator/exam-type";
    }

    /*
    前往添加考试类型信息
     */
    @RequestMapping("examtypeadd")
    public String examtypeadd(){
        return "/administrator/exam-type-add";
    }

    /*
    添加考试类型信息
     */
    @RequestMapping("typeadd")
    public String typeadd(){
        return "/administrator/exam-type";
    }

    /*
    前往更新考试类型信息页面
     */
    @RequestMapping("examtypeupdate")
    public String examtypeupdate(){
        return "/administrator/exam-type-update";
    }

    /*
    更新考试类型信息
     */
    @RequestMapping("typeupdate")
    public String typeupdate(){
        return "/administrator/exam-type";
    }

    /*
    删除考试类型信息
     */
    @RequestMapping("typedelete")
    public String typedelete(){
        return "/administrator/exam-type";
    }

    /*
    前往发布考试信息页面
     */
    @RequestMapping("publishexam")
    public String publishexam(){
        return "/administrator/publish-exam";
    }

    /*
    发布考试信息
     */
    @RequestMapping("publishingexam")
    public String publishingexam(){
        return "/administrator/exam-info";
    }

    /*
    查询所有发布的考试信息
     */
    @RequestMapping("examinfo")
    public String examinfo(){
        return "/administrator/exam-info";
    }

    /*
    前往评卷管理页面
     */
    @RequestMapping("testpaperplan")
    public String testpaperplan(){
        return "/administrator/test-paper-plan";
    }

    /*
    前往添加评卷管理页面
     */
    @RequestMapping("testpaperplanadd")
    public String testpaperplanadd(){
        return "/administrator/test-paper-plan-add";
    }

    /*
    前往更新评卷管理页面
     */
    @RequestMapping("testpaperplanupdate")
    public String testpaperplanupdate(){
        return "/administrator/test-paper-plan-update";
    }

    /*
    添加评卷管理
     */
    @RequestMapping("testplanadd")
    public String testplanadd(){
        return "/administrator/test-paper-plan";
    }

    /*
    更新评卷管理
     */
    @RequestMapping("testplanupdate")
    public String testplanupdate(){
        return "/administrator/test-paper-plan";
    }

    /*
    删除评卷管理
     */
    @RequestMapping("testplandelete")
    public String testplandelete(){
        return "/administrator/test-paper-plan";
    }

    /*
    违纪编码库查询
     */
    @RequestMapping("violatecode")
    public String violatecode(){
        return "/administrator/violate-code";
    }

    /*
    处罚编码库查询
     */
    @RequestMapping("punishcode")
    public String punishcode(){
        return "/administrator/punish-code";
    }

    /*
    前往违纪记录管理
     */
    @RequestMapping("violaterecords")
    public String violaterecords(){
        return "/administrator/violate-records";
    }

    /*
    违纪记录管理
     */
    @RequestMapping("violatehandle")
    public String violatehandle(){
        return "/administrator/violate-records";
    }

    /*
    个人信息
     */
    @RequestMapping("/personalinfo")
    public String personalInfo()
    {
        return "/administrator/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/personalinfoupdate")
    public String personalInfoUpdate()
    {
        return "/administrator/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalupdate")
    public String personalUpdate()
    {
        return "/administrator/personal-info";
    }

    /*
    市州信息
     */
    @RequestMapping("/mayorinfo")
    public String mayorinfo()
    {
        return "/administrator/mayor-info";
    }

    /*
    去更新市州信息页面
     */
    @RequestMapping("/mayorinfoupdate")
    public String mayorInfoUpdate()
    {
        return "/administrator/mayor-info-update";
    }

    /*
    更新市州信息
     */
    @RequestMapping("/mayorupdate")
    public String mayorUpdate()
    {
        return "/administrator/mayor-info";
    }

    /*
    去添加市州信息页面
     */
    @RequestMapping("/mayorinfoadd")
    public String mayorInfoadd()
    {
        return "/administrator/mayor-info-add";
    }

    /*
    添加市州信息
     */
    @RequestMapping("/mayoradd")
    public String mayoradd()
    {
        return "/administrator/mayor-info";
    }

    /*
    删除市州信息
     */
    @RequestMapping("/mayordelete")
    public String mayordelete()
    {
        return "/administrator/mayor-info";
    }

    /*
    院校老师信息
     */
    @RequestMapping("/teacherinfo")
    public String teacherinfo()
    {
        return "/administrator/teacher-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentinfo")
    public String studentinfo()
    {
        return "/administrator/student-info";
    }

    /*
    前往成绩管理页面
     */
    @RequestMapping("/gradesmanage")
    public String gradesmanage()
    {
        return "/administrator/grades-manage";
    }

    /*
    成绩管理
     */
    @RequestMapping("/gradesmanaging")
    public String gradesmanaging()
    {
        return "/administrator/grades-manage";
    }
}
