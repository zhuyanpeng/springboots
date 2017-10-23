package com.study.www.service;

import com.study.www.entity.PipiUpDownExplain;
import com.study.www.mapper.PipiUpDownExplainMapper;

import java.util.List;

/**
 * PipiService: 入库服务
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    18:01
 **/
public interface PipiService {
    public void savePipiData(List<PipiUpDownExplainMapper> pipiUpDownExplainMappers, PipiUpDownExplain pipiUpDownExplain);
}
