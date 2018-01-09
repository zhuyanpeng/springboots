package com.study.www.application.config;

import com.study.www.application.model.RedisBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfig: redis配置类
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/12/7    13:37
 **/
@Configuration
public class RedisConfig {

    @Autowired
    RedisConnectionFactory redisConnectionectionFactory;
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:制定序列化对象
     * @Date: 13:50 2017/12/7
     **/
    @Bean
    RedisTemplate<String,RedisBase> functionDomainRedisTemplate(){
        RedisTemplate<String, RedisBase> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate,redisConnectionectionFactory);
        return redisTemplate;
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:设置序列化方式
     * @Date: 13:40 2017/12/7
     **/
    void initDomainRedisTemplate(RedisTemplate<String,RedisBase> redisTemplate,RedisConnectionFactory factory){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:实例化HashOperations让hash类型可以被使用
     * @Date: 13:56 2017/12/7
     **/
    @Bean
    HashOperations<String,String,RedisBase> hashOperations(RedisTemplate<String,RedisBase> redisTemplate){
        return  redisTemplate.opsForHash();
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:实例化ValueOperations让String类型可以被使用
     * @Date: 13:58 2017/12/7
     **/
    @Bean
    ValueOperations<String,RedisBase> valueOperations(RedisTemplate<String,RedisBase> redisTemplate){
        return  redisTemplate.opsForValue();
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:实例化ListOPerations让list对象可以被使用
     * @Date: 14:01 2017/12/7
     **/
    @Bean
    ListOperations<String,RedisBase> listOperations(RedisTemplate<String,RedisBase> redisTemplate){
        return redisTemplate.opsForList();
    }
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:实例化SetOperations让set对象可以被使用
     * @Date: 14:25 2017/12/7
     **/
    @Bean
    SetOperations<String,RedisBase> setOperations(RedisTemplate<String,RedisBase> redisTemplate){
        return redisTemplate.opsForSet();
    }
    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:实例化ZSetOperations让zset对象可以被使用
     * @Date: 14:25 2017/12/7
     **/
    @Bean
    ZSetOperations<String,RedisBase> zSetOperations(RedisTemplate<String,RedisBase> redisTemplate){
        return redisTemplate.opsForZSet();
    }



}
