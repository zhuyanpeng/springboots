package com.example.demo2swagger2restful;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-24 0:59
 **/
public class User {
    private String id;
    private String name;
    private String age;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
