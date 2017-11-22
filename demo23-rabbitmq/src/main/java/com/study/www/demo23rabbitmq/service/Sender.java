package com.study.www.demo23rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:发送
 *
 * @outhor Administrator
 * @create 2017-11-23 06:51
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

   public void send(String str){
        String context = str+ new Date();
        System.out.println("发送的消息有:"+context);
        //第一个元素时key
        this.amqpTemplate.convertAndSend("hello",context);
    }
}
