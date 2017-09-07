package com.example.demo3swagger2restful.entity;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-25 0:13
 **/
public class TeacherDto {
    private int id;
    private String name;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
