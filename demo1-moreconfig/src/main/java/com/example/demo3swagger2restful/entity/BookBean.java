package com.example.demo3swagger2restful.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 作用说明：书籍对象
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-22 0:32
 **/
@Component
//引用配置文件
@ConfigurationProperties(prefix = "book")
@PropertySource("classpath:book.properties")
public class BookBean {
    private String name;
    private String author;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public BookBean() {
    }
}
