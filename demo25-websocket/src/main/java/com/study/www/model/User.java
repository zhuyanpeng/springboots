package com.study.www.model;

/**
 * User:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/11    14:07
 **/
public class User {
    private String id;
    private String name;
    private int age;
    private double price;

    public User() {
    }

    public User(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public User(String id, String name, int age, double price) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
