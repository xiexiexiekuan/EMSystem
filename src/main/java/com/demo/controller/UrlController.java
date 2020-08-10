package com.demo.controller;

import com.demo.entity.exam.UserInformation;
import com.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用于页面路径跳转
 */
@SessionAttributes({"user"})
@Controller
@RequestMapping("/")
public class UrlController extends BaseController {
    @Autowired
    private LoginService loginService;



    private final ResourceLoader resourceLoader;

    public static UserInformation currentUser;

    //初始化资源加载器
    @Autowired
    public UrlController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    /**
     * 默认进入系统返回页面
     * @return
     */
    @RequestMapping(value = {"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/url")
    public String url(){return "url";}

    @RequestMapping("/login")
    public String login(){
        System.out.println("login");
        return "common/login";
    }

    @RequestMapping("/regist")
    public String regist(){return "common/regist";}

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:"+path+"/index";
    }

    /**
     * 所有用户都进入的主界面
     * @return
     */
    @RequestMapping("/home")
    public String home(){return "/common/home";}

    /**
     * 用户登录时的验证
     */
    @RequestMapping("validate")
    public String userValidate(UserInformation user, @RequestParam(required = false) String role, Map<String,Object> map){
        //System.out.println(user);
        UserInformation existUser=loginService.validate(user);
        if(existUser!=null) {
            currentUser = existUser;
            existUser.setPassword("");
            map.put("user",existUser);
            return "redirect:"+path+"/home";
        }
        map.put("msg","用户名或密码错误");
        return "/common/login";
    }

    /**
     * 考生注册
     * @param user
     * @param map
     * @return
     */
    @RequestMapping("register")
    public String regist(UserInformation user, Map<String,Object> map){
        Integer i=loginService.regist(user);
        if(i==0){
            map.put("msg","用户名信息输入错误！");
        }
        map.put("msg","用户名信息注册成功！");
        return "/common/login";
    }

}
