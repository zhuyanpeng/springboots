package com.study.cn.web;

import com.study.cn.config.CustomAccess;
import com.study.cn.enums.AccessEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 用户web
 * @date :Create in  2018/3/5- 13:45
 * @Version: V1.0s
 * @Modified By:
 **/
@Controller
@RequestMapping("")
public class UserController {

    @RequestMapping("/user/{id}")
    @ResponseBody
    //自定义用户查询注解
    @CustomAccess(AccessEnum.BUU_R)
    public String findUserById(@PathVariable("id") Long id){
        return id+"is very good!";
    }


    @RequestMapping("/movie/{id}")
    @ResponseBody
    //这个方法需要影视查看的权限 但是数据库里面用户并没有此权限
    @CustomAccess(AccessEnum.BUM_C)
    public String findMovieById(@PathVariable("id") Long id){
        return id+"is movie very good!";
    }
}
