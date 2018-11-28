package com.study.www.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.www.entity.Role;
import com.study.www.entity.UserRoleVo;
import com.study.www.service.IRoleService;
import com.study.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-11-28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String find(HttpServletRequest request,
                        @RequestParam(value = "userId") String userId){
        UserRoleVo roleVo = userService.queryUserVoByUserId(userId);
        return JSON.toJSONString(roleVo);
    }
}
