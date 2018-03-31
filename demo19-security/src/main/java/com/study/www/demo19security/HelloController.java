package com.study.www.demo19security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-10-30 23:31
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String idex(ModelMap map){
    //    map.addAttribute("host","www.642jb.com");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
