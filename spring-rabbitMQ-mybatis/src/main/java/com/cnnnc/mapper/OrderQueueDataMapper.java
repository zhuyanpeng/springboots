package com.cnnnc.mapper;

import com.cnnnc.entity.OrderQueueBean;

import java.util.List;

/**
 * OrderQueueDataMapper: 委托队列的mapper实现
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/7    11:07
 **/
public interface OrderQueueDataMapper {
    void insert(List<OrderQueueBean> list);
}
