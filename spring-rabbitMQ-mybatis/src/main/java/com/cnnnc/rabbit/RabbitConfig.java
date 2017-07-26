package com.cnnnc.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Administrator.zhuyanpeng
 * @Description:
 * @Date: 8:56 2017/7/18
 **/
@Configuration
public class RabbitConfig {
    public final static String DIRECT_SOCKET_EXCHANGE="Wind_Direct_Exchange";
    public final static String MSG_DATA_MARKET="MSG_DATA_MARKET";
    public final static String  MSG_DATA_TRANSACTION="MSG_DATA_TRANSACTION";
    public final static String MSG_DATA_ORDERQUEUE="MSG_DATA_ORDERQUEUE";
    public final static String MSG_DATA_ORDER="MSG_DATA_ORDER";
    @Bean
    public Queue marketQueue() {
        return new Queue(RabbitConfig.MSG_DATA_MARKET,true);
    }
    @Bean
    public Queue transactionQueue() {
        return new Queue(RabbitConfig.MSG_DATA_TRANSACTION,true);
    }
    @Bean
    public Queue orderQueueQueue() {
        return new Queue(RabbitConfig.MSG_DATA_ORDERQUEUE,true);
    }
    @Bean
    public Queue orderQueue() {
        return new Queue(RabbitConfig.MSG_DATA_ORDER,true);
    }

    @Bean
    public DirectExchange exchange(){
        return  new DirectExchange(RabbitConfig.DIRECT_SOCKET_EXCHANGE);
    }
    @Bean
    public Binding bindingExchangeMarket(Queue marketQueue,DirectExchange directExchange){
        return BindingBuilder.bind(marketQueue).to(directExchange).with(marketQueue.getName());
    }
    @Bean
    public Binding bindingExchangeTransaction(Queue transactionQueue,DirectExchange directExchange){
        return BindingBuilder.bind(transactionQueue).to(directExchange).with(transactionQueue.getName());
    }
    @Bean
    public Binding bindingExchangeOrderQueue(Queue orderQueueQueue,DirectExchange directExchange){
        return BindingBuilder.bind(orderQueueQueue).to(directExchange).with(orderQueueQueue.getName());
    }
    @Bean
    public Binding bindingExchangeOrder(Queue orderQueue,DirectExchange directExchange){
        return BindingBuilder.bind(orderQueue).to(directExchange).with(orderQueue.getName());
    }
}
