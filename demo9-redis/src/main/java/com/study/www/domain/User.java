package com.study.www.domain;

import java.io.Serializable;
//对象要想进行进行存储必须转化为二进制
public class User implements Serializable{
    //不同的JVM可能计算的此值不同所以你得将计算得参数写出来 这样就能通融
    private static final long serialVersionUID = -1675911465222078151L;
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
