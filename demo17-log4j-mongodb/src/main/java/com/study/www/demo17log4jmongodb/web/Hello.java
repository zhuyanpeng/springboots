package com.study.www.demo17log4jmongodb.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/13    9:37
 **/
@RestController
public class Hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello1(@RequestParam String name){
        System.out.println("hello"+name);
        return "hello"+name;
    }
}