package com.demo.controller.manager;

import com.demo.entity.Exam;
import com.demo.entity.User;
import com.demo.entity.exam.ExamRoomInformation;
import com.demo.entity.exam.ExamTeacher;
import com.demo.entity.exam.UserInformation;
import com.demo.entity.exam.Whitelist;
import com.demo.service.manager.ManagerServe;
import com.demo.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
public class ManagerControl {

    @Autowired
    private ManagerServe managerService;
    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo()
    {

        return "/Manager/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate()
    {
        return "/Manager/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate()
    {
        return "/Manager/personal-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo()
    {

        return "/Manager/student-info";
    }

    /*
    去更新考生信息页面
     */
    @RequestMapping("/toStudentInfoUpdate")
    public String toStudentInfoUpdate(int studentId, Map<String,Object> map)
    {

        return "/Manager/student-info-update";
    }

    /*
    更新考生信息
     */
    @RequestMapping("/studentInfoUpdate")
    public String studentInfoUpdate(User user, Map<String,Object> map)
    {
        User examinee=managerService.findUserById(user.getId());
        map.put("examinee",examinee);
        Integer i = managerService.updateUser(examinee);

        if(i>0){
            map.put("mag","考生信息更新成功！");
            return "/Manager/student-info";
        }

        map.put("msg","考生信息更新失败！");
        return toStudentInfoUpdate(examinee.getId(),map);
    }

    /*
    去添加考生信息页面
     */
    @RequestMapping("/toStudentInfoAdd")
    public String toStudentInfoAdd()
    {
        return "/Manager/student-info-add";
    }

    /*
    添加考生信息
     */
    @RequestMapping("/studentInfoAdd")
    public String studentInfoAdd(Map<String,Object> map,User user )
    {
        Integer i = managerService.addExaminee(user);
        if(i>0){
            map.put("mag","考生添加成功！");
            return "/Manager/student-info";
        }
        map.put("msg","考生添加失败！");
        return "/Manager/student-info";
    }

    /*
    删除考生信息
     */
    @RequestMapping("/studentInfoDelete")
    public String studentInfoDelete(Map<String,Object> map,User user)
    {
        Integer i = managerService.deleteExaminee(user);
        if(i>0){
            map.put("mag","考生添加成功！");
            return "/Manager/student-info";
        }
        map.put("msg","考生添加失败！");
        return "/Manager/student-info";
    }

    /*
    前往集体报名页面
     */
    @RequestMapping("/toGroupEnter")
    public String toGroupEnter(Map<String,Object> map)
    {
        List<UserInformation> userInformationList = managerService.findStudentPassPreview();
        map.put("userInformationList",userInformationList);
        return "/Manager/group-enter";
    }

    /*
   集体报名
    */
    @RequestMapping("/groupEnter")
    public String groupEnter()
    {
        managerService.groupEnter();
        return "/Manager/group-enter";
    }

    /*
    前往集体报考页面
     */
    @RequestMapping("/toGroupApply")
    public String toGroupApply()
    {
        return "/Manager/group-apply";
    }

    /*
   集体报考
    */
    @RequestMapping("/groupApply")
    public String groupApply()
    {
        return "/Manager/group-apply";
    }

    /*
   前往集体缴费页面
    */
    @RequestMapping("/toGroupPay")
    public String toGroupPay()
    {
        return "/Manager/group-pay";
    }

    /*
   集体缴费
    */
    @RequestMapping("/groupPay")
    public String groupPay()
    {
        return "/Manager/group-pay";
    }

    /*
    报考信息查询
   */
    @RequestMapping("/examInformation")
    public String examInformation()
    {
        return "/Manager/exam-information";
    }

    /*
    白名单信息
     */
    @RequestMapping("/whitelist")
    public String whitelist(Map<String,Object> map)
    {
        List<Whitelist> whitelistList = managerService.findAllWhiteList();
        map.put("whitelist",whitelistList);
        return "/Manager/whitelist";
    }

    /*
    去更新白名单信息页面
     */
    @RequestMapping("/toWhitelistUpdate")
    public String toWhitelistUpdate()
    {
        return "/Manager/whitelist-update";
    }

    /*
    更新白名单信息
     */
    @RequestMapping("/whitelistUpdate")
    public String whitelistUpdate(Map<String,Object> map, Whitelist whitelist)
    {
        Integer i  = managerService.updateWhiteList(whitelist);
        if(i>0) {
            map.put("msg","白名单更新成功");
            return whitelist(map);
        }
        map.put("msg","白名单更新失败");
        return toWhitelistUpdate();
    }

    /*
    去添加白名单信息页面
     */
    @RequestMapping("/toWhitelistAdd")
    public String toWhitelistAdd()
    {
        return "/Manager/whitelist-add";
    }

    /*
    添加白名单信息
     */
    @RequestMapping("/whitelistAdd")
    public String whitelistAdd(Map<String,Object> map,int UserID)

    {
        Integer i = managerService.addWhiteList(UserID);
        if(i>0){
            map.put("mag","添加成功！");
            return whitelist(map);
        }
        map.put("msg","添加失败！");
        return "/Manager/whitelist-add";
    }

    /*
    删除白名单信息
     */
    @RequestMapping("/whitelistDelete")
    public String whitelistDelete(Map<String,Object> map,int listId)
    {
        Integer i = managerService.deleteWhiteList(listId);
        if(i>0){
            map.put("mag","添加成功！");
            return whitelist(map);
        }
        map.put("msg","添加失败！");
        return whitelist(map);
    }

    /*
    考场信息
     */
    @RequestMapping("/examRoom")
    public String examRoom(Map<String,Object> map)
    {
        List<ExamRoomInformation> examRoomInformationList = managerService.findAllExamRoom();
        map.put("examRoomList",examRoomInformationList);
        return "/Manager/exam-room";
    }

    /**
     * 检查是否是考点
     * @return boolean
     */
    @RequestMapping("/checkRoom")
    public boolean checkRoom() {
        return managerService.checkRoom();
    }

    /*
    去更新考场信息页面
     */
    @RequestMapping("/toExamRoomUpdate")
    public String toExamRoomUpdate(Map<String,Object> map,int examRoomId)
    {
        ExamRoomInformation examRoomInformation = managerService.findExamRoomById(examRoomId);
        map.put("examRoom",examRoomInformation);
        return "/Manager/exam-room-update";
    }

    /*
    更新考场信息
     */
    @RequestMapping("/examRoomUpdate")
    public String examRoomUpdate(Map<String,Object> map, ExamRoomInformation examRoomInformation)
    {
        Integer i = managerService.updateExamRoom(examRoomInformation);
        if(i>0) {
            map.put("msg","更新成功");
        }
        map.put("msg","更新失败");
        return toExamRoomUpdate(map,examRoomInformation.getExamRoomId());
    }

    /*
    去添加考场信息页面
     */
    @RequestMapping("/toExamRoomAdd")
    public String toExamRoomAdd()
    {
        return "/Manager/exam-room-add";
    }

    /*
    添加考场信息
     */
    @RequestMapping("/examRoomAdd")
    public String examRoomAdd(Map<String,Object> map, ExamRoomInformation examRoomInformation)
    {
        Integer i = managerService.addExamRoom(examRoomInformation);
        if(i>0) {
            map.put("msg","更新成功");
            return examRoom(map);
        }
        map.put("msg","更新失败");
        return toExamRoomAdd();

    }

    /*
    删除考场信息
     */
    @RequestMapping("/examRoomDelete")
    public String examRoomDelete(Map<String,Object> map,int examRoomId)
    {
        Integer i = managerService.deleteExamRoom(examRoomId);
        if(i>0) {
            map.put("msg","成功");
            return examRoom(map);
        }
        map.put("msg","失败");
        return examRoom(map);
    }

    /*
    考务老师信息
     */
    @RequestMapping("/examteacherInfo")
    public String examTeacherInfo(Map<String,Object> map)
    {
        List<ExamTeacher> examTeacherList = managerService.findAllExamTeacher();
        map.put("examTeacherList",examTeacherList);
        return "/Manager/examteacher-info";
    }

    /*
    去更新考务老师信息页面
     */
    @RequestMapping("/toExamteacherInfoUpdate")
    public String toExamTeacherInfoUpdate(Map<String,Object> map,int examTeacherId)
    {
        ExamTeacher examTeacher = managerService.findExamTeacherById(examTeacherId);
        map.put("examRoom",examTeacher);
        return "/Manager/examteacher-info-update";
    }

    /*
    更新考务老师信息
     */
    @RequestMapping("/examteacherInfoUpdate")
    public String examTeacherInfoUpdate(Map<String,Object> map, ExamTeacher examTeacher)
    {
        Integer i = managerService.updateExamTeacher(examTeacher);
        if(i>0) {
            map.put("msg","更新成功");
        }
        map.put("msg","更新失败");
        return toExamTeacherInfoUpdate(map,examTeacher.getTeacherId());
    }

    /*
    去添加考务老师信息页面
     */
    @RequestMapping("/toExamteacherInfoAdd")
    public String toExamteacherInfoAdd()
    {
        return "/Manager/examteacher-info-add";
    }

    /*
    添加考务老师信息
     */
    @RequestMapping("/examteacherInfoAdd")
    public String examteacherInfoAdd(Map<String,Object> map, ExamTeacher examTeacher)
    {
        Integer i = managerService.addExamTeacher(examTeacher);
        if(i>0) {
            map.put("msg","更新成功");
            return examTeacherInfo(map);
        }
        map.put("msg","更新失败");
        return toExamteacherInfoAdd();
    }

    /*
    删除考务老师信息
     */
    @RequestMapping("/examteacherInfoDelete")
    public String examteacherInfoDelete(Map<String,Object> map,int examTeacherId)
    {
        Integer i = managerService.deleteExamTeacher(examTeacherId);
        if(i>0) {
            map.put("msg","成功");
            return examTeacherInfo(map);
        }
        map.put("msg","失败");
        return examTeacherInfo(map);
    }
}
