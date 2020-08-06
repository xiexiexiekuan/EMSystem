package com.demo.controller;

import com.demo.entity.exam.UserInformation;
import com.demo.service.UserInfoService;
import com.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController{

    @Autowired
    private UserInfoService userInfoService;
    
    public String getFilePosition(int role){
        String position;
        if(role==0)position="administrator";
        else if(role==1)position="Mayor";
        else if(role==2)position="Manager";
        else position="Examinee";
        return position;
    }

    /*
    个人信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo(Map<String,Object> map) {
        System.out.println("personalInfo");
        map.put("myInfo", UrlController.currentUser);
        int role = UrlController.currentUser.getRole();
        return getFilePosition(role)+"/personal-info";
    }

    /*
    去更新个人信息页面
     */
    @RequestMapping("/toPersonalInfoUpdate")
    public String toPersonalInfoUpdate(Map<String,Object> map) {
        System.out.println("toPersonalInfoUpdate");
        map.put("updateUser", UrlController.currentUser);
        int role = UrlController.currentUser.getRole();
        return getFilePosition(role)+"/personal-info-update";
    }

    /*
    更新个人信息
     */
    @RequestMapping("/personalInfoUpdate")
    public String personalInfoUpdate(UserInformation myInfo, Map<String,Object> map)
    {
        Integer i = userInfoService.updatePersonalInfo(myInfo);
        if(i>0){
            map.put("msg","用户信息更新成功！");
            UrlController.currentUser = userInfoService.findUserInfoById(myInfo.getUserId());
            return personalInfo(map);
        }
        map.put("msg","用户信息更新失败，请重试！");
        return toPersonalInfoUpdate(map);
    }

    /*
    市州信息
     */
    @RequestMapping("/mayorInfo")
    public String mayorInfo(Map<String,Object> map)
    {
        List<UserInformation> mayorInfo = userInfoService.findAllMayorInfo();
        map.put("mayorInfo",mayorInfo);
        return "administrator/mayor-info";
    }

    /*
    院校老师信息
     */
    @RequestMapping("/teacherInfo")
    public String teacherInfo(Map<String,Object> map)
    {
        List<UserInformation> teacherInfo = userInfoService.findAllTeacherInfo();
        map.put("teacherInfo",teacherInfo);
        int role = UrlController.currentUser.getRole();
        return getFilePosition(role)+"/teacher-info";
    }

    /*
    考生信息
     */
    @RequestMapping("/studentInfo")
    public String studentInfo(Map<String,Object> map)
    {
        List<UserInformation> studentInfo = userInfoService.findAllStudentInfo();
        map.put("studentInfo",studentInfo);
        int role = UrlController.currentUser.getRole();
        return getFilePosition(role)+"/student-info";
    }

    public String getHtmlName(int role){
        String name;
        if(role==0)name="/mayor";//考务院只能修改市州的信息
        else if(role==1)name="/teacher";//市州只能修改院校的信息
        else name="/student";//院校只能修改考生信息，考生只能修改个人信息，修改个人信息不调用此函数
        return name;
    }

    /*
    去更新用户信息页面
     */
    @RequestMapping("/toUserInfoUpdate")
    public String toUserInfoUpdate(int userId, Map<String,Object> map)
    {
        System.out.println("userId = "+userId);
        UserInformation updateUser = userInfoService.findUserInfoById(userId);
        int role = UrlController.currentUser.getRole();
        map.put("updateUser",updateUser);
        return getFilePosition(role)+getHtmlName(role)+"-info-update";
    }

    /*
    更新用户信息
     */
    @RequestMapping("/userInfoUpdate")
    public String userInfoUpdate(UserInformation userInfo, Map<String,Object> map)
    {
        Integer i = userInfoService.updatePersonalInfo(userInfo);
        int role = UrlController.currentUser.getRole();
        if(i>0){
            map.put("msg","用户信息更新成功！");
            if(role==0) return mayorInfo(map);
            else if(role==1) return teacherInfo(map);
            else return studentInfo(map);
//            return getFilePosition(role)+getHtmlName(role)+"-info";
        }
        map.put("msg","用户信息更新失败，请重试！");
        return toUserInfoUpdate(userInfo.getUserId(),map);
    }

    /*
    去添加用户信息页面
     */
    @RequestMapping("/toUserInfoAdd")
    public String toUserInfoAdd()
    {
        int role = UrlController.currentUser.getRole();
        return getFilePosition(role)+getHtmlName(role)+"-info-add";
    }

    /*
    添加用户信息
     */
    @RequestMapping("/userInfoAdd")
    public String userInfoAdd(UserInformation userInfo, Map<String,Object> map)
    {
        Integer i = userInfoService.addUserInfo(userInfo);
        int role = UrlController.currentUser.getRole();
        if(i>0){
            map.put("msg","用户信息添加成功！");
            if(role==0) return mayorInfo(map);
            else if(role==1) return teacherInfo(map);
            else return studentInfo(map);
//            return getFilePosition(role)+getHtmlName(role)+"-info";
        }
        map.put("msg","用户信息添加失败，请重试！");
        return toUserInfoAdd();
    }

    /*
    删除用户信息
     */
    @RequestMapping("/userInfoDelete")
    public String userInfoDelete(int userId, Map<String,Object> map)
    {
        Integer i = userInfoService.deleteUserInfo(userId);
        int role = UrlController.currentUser.getRole();
        if(i>0) map.put("msg","用户信息删除成功！");
        else map.put("msg","用户信息删除失败，请重试！");
        //删除成功与否都会回到用户信息列表
        if(role==0) return mayorInfo(map);
        else if(role==1) return teacherInfo(map);
        else return studentInfo(map);
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("uploadUserPhoto")
    public String uploadUserPhoto(@RequestParam("file") MultipartFile file, HttpServletRequest request, Map<String,Object> map) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
//        String filePath = request.getSession().getServletContext().getRealPath("/");
        try {
            System.out.println("getRealPath-->" + filePath+fileName);
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            Integer id=((UserInformation)request.getSession().getAttribute("user")).getUserId();
            Integer x=userInfoService.saveUserImage(fileName,id);
            if(x>0){
                UserInformation newUser=userInfoService.findUserInfoById(id);
                request.getSession().setAttribute("user",newUser);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        UrlController.currentUser = userInfoService.findUserInfoById(UrlController.currentUser.getUserId());
        System.out.println(UrlController.currentUser);
        return personalInfo(map);
    }
}
