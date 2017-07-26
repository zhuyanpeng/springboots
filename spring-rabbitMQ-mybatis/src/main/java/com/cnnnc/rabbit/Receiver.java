package com.cnnnc.rabbit;

import com.cnnnc.service.impl.OrderQueueDataServiceImpl;
import com.cnnnc.service.impl.TransactionDataServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Administrator.zhuyanpeng
 * @Description:
 * @Date: 8:56 2017/7/18
 **/
@Component
public class Receiver {
    @Autowired
    private TransactionDataServiceImpl transactionDataServiceImpl;
    @Autowired
    private OrderQueueDataServiceImpl orderQueueDataService;
    //逐笔成交
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process1(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process2(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process3(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process4(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_TRANSACTION)
    public void process5(String str) {
        transactionDataServiceImpl.saveTransaction(str);
    }
    //委托队列
    @RabbitListener(queues = RabbitConfig.MSG_DATA_ORDERQUEUE)
    public void process6(String str) {
        orderQueueDataService.saveOrderQueueData(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_ORDERQUEUE)
    public void process7(String str) {
        orderQueueDataService.saveOrderQueueData(str);
    }
    @RabbitListener(queues = RabbitConfig.MSG_DATA_ORDERQUEUE)
    public void process8(String str) {
        orderQueueDataService.saveOrderQueueData(str);
    }
}
