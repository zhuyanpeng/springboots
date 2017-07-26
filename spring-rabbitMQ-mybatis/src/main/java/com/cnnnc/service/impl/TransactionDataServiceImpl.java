package com.cnnnc.service.impl;

import com.alibaba.fastjson.JSON;
import com.cnnnc.entity.TransactionDataBean;
import com.cnnnc.mapper.TransactionDataMapper;
import com.cnnnc.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * TransactionDataServiceImpl:
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/6    14:43
 **/
@Service
public class TransactionDataServiceImpl implements TransactionDataService {
    @Autowired
    private TransactionDataMapper transactionDataMapper;
    @Override
    public void saveTransaction(String str) {
        TransactionDataBean transactionDataBean = JSON.parseObject(str, TransactionDataBean.class);
        ArrayList<TransactionDataBean> transactionDataBeans = new ArrayList<>();
        transactionDataBeans.add(transactionDataBean);
        transactionDataMapper.insert(transactionDataBeans);
    }

}
