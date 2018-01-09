package com.study.www.web;

import com.study.www.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

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

    @RequestMapping(value = "table",method = RequestMethod.GET)
    public String table(ModelMap map){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("01","张三",10,100));
        users.add(new User("02","李四",11,100));
        users.add(new User("03","王五",12,100));
        users.add(new User("04","赵六",8,100));
        map.put("users",users);
        return "table";
    }

}
