package com.demo.config;

import com.demo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebInterceptorConfiguration extends WebMvcConfigurationSupport {
    @Value("${interceptor.path.exclude}")
    private String[] excludePaths;
    @Value("${server.servlet.path}")
    private String path;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //用户登录拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns(path+"/**")
                .excludePathPatterns("res/**");
        super.addInterceptors(registry);
    }
}
