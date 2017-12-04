package com.study.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * WebSocket:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/4    16:44
 **/
@Controller
@RequestMapping("/")
public class WebSocket {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
