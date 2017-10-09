package com.study.www.demo12config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Demo1: 測試
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/9    14:16
 **/
//@RestController注解相当于@ResponseBody ＋ @Controller
@RestController
public class Demo1 {
    @Value("${com.study.www.name}")
    private String name;
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        System.out.println(requestURI+request.getServerPort());
        return name;
    }
}
