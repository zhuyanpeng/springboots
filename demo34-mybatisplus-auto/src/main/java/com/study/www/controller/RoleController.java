package com.study.www.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.www.entity.Role;
import com.study.www.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @GetMapping("")
    public String query(HttpServletRequest request,
                        @RequestParam(value = "paegSize",defaultValue = "5") Integer pageSize,
                        @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber){
        Page<Role> page = new Page<>(pageNumber, pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("`name`","`order`");
        if (StringUtils.isNotEmpty(request.getParameter("name"))){
            queryWrapper.like("name",request.getParameter("name"));
        }
        return JSON.toJSONString(roleService.page(page,queryWrapper));
    }
}
