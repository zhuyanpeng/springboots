package com.study.www.demo23rabbitmq.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 描述:队列配置器可以用来配置队列 交换器 路由等信息
 *
 * @outhor Administrator
 * @create 2017-11-23 07:10
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
