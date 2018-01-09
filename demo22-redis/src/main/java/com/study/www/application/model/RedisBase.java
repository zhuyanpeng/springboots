package com.study.www.application.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RedisBase:
 *redis顶级对象其他对象一律继承其来进行使用
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/7    13:59
 **/
public class RedisBase implements Serializable{
     String redisKey=new Date().toString();

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }
}
