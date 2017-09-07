package com.example.demo3swagger2restful.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-23 23:48
 **/
@Component
@ConfigurationProperties(prefix = "user")
@PropertySource(value = "classpath:user.properties")//目录源配置
public class UserDto {
    private String names;
    private String author;
    private int age;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
