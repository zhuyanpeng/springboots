package com.study.www.demo12config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * randomProperties: 配置文件的随机数
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/9    13:48
 **/
@Component
public class RandomProperties {

    @Value("${com.study.www.value}")
    private String value;
    @Value("${com.study.www.number}")
    private int number;
    @Value("${com.study.www.long}")
    private Long aLong;
    @Value("${com.study.www.int}")
    private int int1;
    @Value("${com.study.www.int1}")
    private int int2;
    @Value("${com.study.www.uuid}")
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }
    public void start(){
        System.out.println(aLong);
    }
}
