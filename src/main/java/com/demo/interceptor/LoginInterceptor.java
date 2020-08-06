package com.demo.interceptor;

import com.demo.entity.exam.UserInformation;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInformation u=(UserInformation)request.getSession().getAttribute("user");
        if(u==null){//用户不存在拦截重定向到登录页面
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
