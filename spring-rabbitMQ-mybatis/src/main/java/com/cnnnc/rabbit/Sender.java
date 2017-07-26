package com.cnnnc.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: Administrator.zhuyanpeng
 * @Description:
 * @Date: 8:56 2017/7/18
 **/
@Component
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(String content) {
		rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_SOCKET_EXCHANGE,RabbitConfig.MSG_DATA_ORDER,content);
	}
}