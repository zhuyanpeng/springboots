package com.example.www.demo4jdbctemplate.service.impl;

import com.example.www.demo4jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 作用说明：用户实现
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-26 1:22
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER_INFO(NAME,AGE) values(?,?)",name,age);
    }

    @Override
    public void deletByName(String name) {
        jdbcTemplate.update("delete FROM USER_INFO where NAME= ?",name);
    }

    @Override
    public Integer getAllUsers() {
        //查询返回自定义
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM USER_INFO", Integer.class);
        return count;
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER_INFO ");
    }

    @Override
    public void creatUserTable() {
        jdbcTemplate.update("create TABLE USER_INFO(name VARCHAR(32),AGE INT )");
    }

    @Override
    public void dropUserTable() {
        jdbcTemplate.update("DROP TABLE USER_INFO");
    }
}
