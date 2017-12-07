package com.study.www.application.service;

import com.study.www.application.model.RedisBase;

import java.util.List;
import java.util.Set;

/**
 * IRedisService:
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/12/7    14:26
 **/
public interface IRedisService {
    String getRedisKey();
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:
     * 注入：
     * @Param key:key
     * @Param domain:对象
     * @Param expire :过期时间（单位：秒），传入 -1时无过期时间
     *
     * @Date: 14:27 2017/12/7
     **/
    void put(String key,RedisBase domain,long expire);
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:list添加
     *
     * @Date: 15:11 2017/12/7
     **/
    void add(RedisBase redisBase,long expire);
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:删除
     * @Date: 14:33 2017/12/7
     **/
    void remove(String key);

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:查询
     * @Date: 14:33 2017/12/7
     **/
    RedisBase get(String key);
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:查看当前库下面的所有对象
     * @Date: 14:34 2017/12/7
     **/
    List<RedisBase> getAll();
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:查询当前redis库下所有的key
     * @Date: 14:35 2017/12/7
     **/
    Set<String> getKeys();

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:查看当前key有没有
     * @Date: 14:36 2017/12/7
     **/
    boolean isKeyExists(String key);
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:查看缓存数量
     * @Date: 14:37 2017/12/7
     **/
    long count();
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:
     * @Date: 14:38 2017/12/7
     **/
    void empty();
}
