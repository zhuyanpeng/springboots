package com.study.www.service.Impl;

import com.study.www.entity.PipiUpDownEntity;
import com.study.www.entity.PipiUpDownExplain;
import com.study.www.mapper.PipiUpDownEntityMapper;
import com.study.www.mapper.PipiUpDownExplainMapper;
import com.study.www.service.PipiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PipiServiceImpl: 入库服务的实现
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    18:01
 **/
@Service(value = "PipiService")
public class PipiServiceImpl implements PipiService{

    @Autowired
    private PipiUpDownEntityMapper pipiUpDownEntityMapper;
    @Autowired
    private PipiUpDownExplainMapper pipiUpDownExplainMapper;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void  savePipiData(List<PipiUpDownEntity> pipiUpDownEntitys, PipiUpDownExplain pipiUpDownExplain) {
        pipiUpDownExplainMapper.insert(pipiUpDownExplain);
        //判断数据是否存在
        for (PipiUpDownEntity pipiUpDownEntity : pipiUpDownEntitys) {
            int count=pipiUpDownEntityMapper.queryByEntity(pipiUpDownEntity);
            if (count==0){
                pipiUpDownEntityMapper.insert(pipiUpDownEntity);
            }
        }
    }

}
