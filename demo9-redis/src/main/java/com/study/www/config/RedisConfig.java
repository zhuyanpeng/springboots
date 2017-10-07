package com.study.www.config;

import com.study.www.domain.RedisObjectSerializer;
import com.study.www.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Bean
    public RedisTemplate<String,User> redisTemplate(){
        RedisTemplate<String, User> stringUserRedisTemplate = new RedisTemplate<>();
        stringUserRedisTemplate.setConnectionFactory(redisConnectionFactory);//连接工厂
        stringUserRedisTemplate.setKeySerializer(new StringRedisSerializer());//key的序列化格式
        stringUserRedisTemplate.setValueSerializer(new RedisObjectSerializer());//值的序列化格式
        return stringUserRedisTemplate;
    }

}
