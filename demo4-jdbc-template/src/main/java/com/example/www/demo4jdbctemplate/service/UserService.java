package com.example.www.demo4jdbctemplate.service;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-26 1:20
 **/
public interface UserService {
    void dropUserTable();
    void creatUserTable();
    void create(String name,Integer age);
    void deletByName(String name);
    Integer getAllUsers();
    void deleteAllUsers();
}
