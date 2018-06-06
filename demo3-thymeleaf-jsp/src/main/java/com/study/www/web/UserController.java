package com.study.www.web;

import com.study.www.model.User;
import org.omg.IOP.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/4/16 0016- 11:28
 * @Version: V1.0
 * @Modified By:
 **/
@Controller
public class UserController {
    
    @GetMapping("test")
    public String test(ModelMap map){
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i,"张三"+i,random.nextLong()));
        }
        map.put("users",users);
        return "table";
    }

    @Autowired
    private ServletContext application;

    @GetMapping("text")
    public String text(ModelMap map, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        map.put("result","我是演示");
        map.put("number",12);
        map.put("number_double",12.2876);
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numberList.add(i*10+30);
        }
        map.put("number_list",numberList);
        map.put("number_list_empt",new ArrayList<String>());
        map.put("numer_list_str","24,12,567,89,12");
        application.setAttribute("context_content","application_bbb");
        session.setAttribute("context_content","session_bbb");
        map.put("date_str_content","2017-08-08 11:01:11");
        map.put("date_format_content",new Date());
        return "text";
    }


}
