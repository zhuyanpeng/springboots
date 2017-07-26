package com.study.www.service.Impl;

import com.study.www.entity.PipiInfo;
import com.study.www.entity.PipiInfoSimple;
import com.study.www.mapper.PipiInfoMapper;
import com.study.www.mapper.PipiInfoSimpleMapper;
import com.study.www.service.PipiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private PipiInfoMapper pipiInfoMapper;
    @Autowired
    private PipiInfoSimpleMapper pipiInfoSimpleMapper;
    @Override
    public void savePipiData(List<PipiInfo> pipiInfos, List<PipiInfoSimple> pipiInfoSimples) {
         pipiInfoMapper.insert(pipiInfos);
        pipiInfoSimpleMapper.insert(pipiInfoSimples);
    }
}
