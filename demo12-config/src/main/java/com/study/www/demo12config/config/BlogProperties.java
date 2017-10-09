package com.study.www.demo12config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * BlogProperties: 配置文件的信息
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/9    11:21
 **/
@Component
public class BlogProperties {
    @Value("${com.study.www.name}")
    private String name;

    @Value("${com.study.www.title}")
    private String title;

    private Integer[] arr;
    @Value("${com.study.www.all}")
    private  String all;

    public Integer[] getArr() {
        return arr;
    }
    @Value("${com.study.www.arr}")
    public void setArr(String arrStr) {
        String[] split = arrStr.split(",");
        Integer[] arr=new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.valueOf(split[i]);
        }
        this.arr =arr ;
    }

    public String getName() {
        return name;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
