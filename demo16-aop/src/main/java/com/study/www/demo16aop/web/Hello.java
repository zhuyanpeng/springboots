package com.study.www.demo16aop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/12    10:22
 **/
@RestController
public class Hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello1(@RequestParam String name){
        System.out.println("hello"+name);
        return "hello"+name;
    }
}
