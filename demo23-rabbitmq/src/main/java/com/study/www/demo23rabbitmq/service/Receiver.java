package com.study.www.demo23rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述: 接受
 *
 * @outhor Administrator
 * @create 2017-11-23 07:06
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    void process(String str){
        System.out.println("Receiver:"+str);

    }
}
