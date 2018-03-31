package com.study.www.demo24actuator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-12-01 07:13
 */
@Controller
@RequestMapping("/")
public class HelloControll {


    @RequestMapping("hello")
    public String hello1(){
        return "hello1";
    }
}
