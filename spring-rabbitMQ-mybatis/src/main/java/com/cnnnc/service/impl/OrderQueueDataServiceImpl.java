package com.cnnnc.service.impl;

import com.alibaba.fastjson.JSON;
import com.cnnnc.entity.OrderQueueBean;
import com.cnnnc.mapper.OrderQueueDataMapper;
import com.cnnnc.service.OrderQueueDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderQueueDataServiceImpl: 委托队列实现
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/7    11:05
 **/
@Service
public class OrderQueueDataServiceImpl implements OrderQueueDataService {
    @Autowired
    private OrderQueueDataMapper orderQueueDataMapper;
    @Override
    public void saveOrderQueueData(String str) {
        List<OrderQueueBean> orderQueueBeans = JSON.parseArray(str, OrderQueueBean.class);
      /*  orderQueueDataMapper.insert(orderQueueBeans);*/
        System.out.println(orderQueueBeans);
    }
}
