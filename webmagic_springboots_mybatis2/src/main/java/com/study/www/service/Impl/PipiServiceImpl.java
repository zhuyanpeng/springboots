package com.study.www.service.Impl;

import com.study.www.entity.PipiUpDownEntity;
import com.study.www.entity.PipiUpDownExplain;
import com.study.www.mapper.PipiUpDownEntityMapper;
import com.study.www.mapper.PipiUpDownExplainMapper;
import com.study.www.service.PipiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * PipiServiceImpl: 入库服务的实现
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    18:01
 **/
@Service(value = "PipiService")
public class PipiServiceImpl implements PipiService{
    private static Logger logger = LoggerFactory.getLogger(PipiServiceImpl.class);
    @Autowired
    private PipiUpDownEntityMapper pipiUpDownEntityMapper;
    @Autowired
    private PipiUpDownExplainMapper pipiUpDownExplainMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void  savePipiData(List<PipiUpDownEntity> pipiUpDownEntitys, PipiUpDownExplain pipiUpDownExplain) {
        this.pipiUpDownExplainMapper.insert(pipiUpDownExplain);
        Iterator var3 = pipiUpDownEntitys.iterator();

        while(var3.hasNext()) {
            PipiUpDownEntity pipiUpDownEntity = (PipiUpDownEntity)var3.next();

            try {
                int count = this.pipiUpDownEntityMapper.queryByEntity(pipiUpDownEntity);
                if (count == 0) {
                    this.pipiUpDownEntityMapper.insert(pipiUpDownEntity);
                    logger.warn("数据下载完成:[" + pipiUpDownEntity.getGoodsName() + "]");
                }
            } catch (Exception var6) {
                System.out.println(var6.getMessage());
                logger.error("严重警告数据有误错误数据为:[" + pipiUpDownEntity.getGoodsName() + "]");
                logger.warn("严重警告数据有误错误数据为:[" + pipiUpDownEntity.getGoodsName() + "]");
            }
        }
    }

}
