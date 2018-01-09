package com.study.www.application.service.impl;

import com.study.www.application.model.RedisBase;
import com.study.www.application.model.RedisTest;
import com.study.www.application.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.swing.text.TabExpander;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisServiceImpl: rdis服务实现
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/7    14:38
 **/
@Service
public class RedisServiceImpl implements IRedisService{
    private static final String REDIS_KEY = "TEST_REDIS_KEY";
    @Autowired
    RedisTemplate<String,RedisBase> template;
    @Resource
    HashOperations<String,String,RedisBase> hashOperations;

    @Override
    public String getRedisKey() {
        return this.REDIS_KEY;
    }

    @Override
    public void put(String key, RedisBase domain, long expire) {
        String redisKey = this.getRedisKey();
        hashOperations.put(redisKey,key,domain);
        if (expire!=-1){
            template.expire(redisKey,expire, TimeUnit.SECONDS);
        }
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:与put不同的是list添加的数据是list集合put添加的是redisKey:{[key:domain],[key1:domain1]}
     * @Date: 18:51 2017/12/7
     **/
    @Override
    public void add(RedisBase redisBase, long expire) {
        template.opsForList().leftPush(redisBase.getRedisKey(),redisBase);
        if (expire!=-1){
            template.expire(redisBase.getRedisKey(),expire, TimeUnit.SECONDS);
        }
    }

    @Override
    public List<RedisBase> lrange(String key, int left, int right) {
        if (right==-1){
            return template.opsForList().range(key, left < 0 ? 0 : left, template.opsForList().size(key));
        }
        return template.opsForList().range(key,left<0?0:left,right<0?0:right);
    }

    @Override
    public void remove(String key) {
        hashOperations.delete(this.getRedisKey(),key);
    }

    @Override
    public RedisBase get(String key) {
        return hashOperations.get(this.getRedisKey(),key);
    }

    @Override
    public List<RedisBase> getAll() {
        return hashOperations.values(this.getRedisKey());
    }

    @Override
    public Set<String> getKeys() {
        return hashOperations.keys(this.getRedisKey());
    }

    @Override
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(this.getRedisKey(),key);
    }

    @Override
    public long count() {
        return hashOperations.size(this.getRedisKey());
    }

    @Override
    public void empty() {
        Set<String> keys = hashOperations.keys(this.getRedisKey());
        String redisKey = this.getRedisKey();
        for (String key : keys) {
            hashOperations.delete(redisKey,key);
        }
    }
}
