package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;


public class BaseController {
    //默认路径
    @Value("${server.servlet.path}")
    protected String path;
    @Value("${image.path}")
    protected String filePath;
    @Value("${admission.path}")
    protected String admissionPath;
    @Value("${admission.per}")
    protected String admissionPer;

}
