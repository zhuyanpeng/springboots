package com.study.www.demo7mybatismore.domain.dbstk.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 作用说明：回测文件落地系统
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-20 14:44
 **/
@Component
public interface TbFileMapper {
    List<Map<String,String>>  findTimeAndCodeByStrategyId();
}
