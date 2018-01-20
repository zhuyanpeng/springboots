package com.study.www.web;

import com.study.www.domain.User;
import com.study.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 用户
 * @date :Create in  2018/1/20- 11:26
 * @Version: V1.0
 * @Modified By:
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/cache/{name}")
    public User findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }

    @GetMapping("/cache/account/{account}")
    public User findByAccount(@PathVariable("account") String account){
        return userService.findByAccount(account);
    }

    /**
     * 获得所有用户
     * @return
     */
    @GetMapping("/cache")
    public List<User> selectUsers(){
        return userService.select();
    }


}
