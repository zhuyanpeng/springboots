package com.study.www.service;

import com.study.www.entity.PipiInfo;
import com.study.www.entity.PipiInfoSimple;

import java.util.List;

/**
 * PipiService: 入库服务
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    18:01
 **/
public interface PipiService {
    public void savePipiData(List<PipiInfo> pipiInfos, List<PipiInfoSimple> pipiInfoSimples);
}
