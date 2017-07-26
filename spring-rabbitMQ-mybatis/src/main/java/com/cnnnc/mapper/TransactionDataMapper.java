package com.cnnnc.mapper;

import com.cnnnc.entity.TransactionDataBean;

import java.util.List;

/**
 * TransactionDataMapper: 逐笔成交的dao
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/6    14:41
 **/
public interface TransactionDataMapper {
    void insert(List<TransactionDataBean> list);
}
