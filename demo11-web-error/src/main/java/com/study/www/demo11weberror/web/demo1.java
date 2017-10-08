package com.study.www.demo11weberror.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//演示异常
@Controller
public class demo1 {
    @RequestMapping(value = "/demo1")
    public  String hello() throws  Exception{
        throw  new Exception("错误");
    }
}
