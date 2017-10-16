package com.study.www.mapper;

import com.study.www.entity.PipiInfoSimple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PipiInfoSimpleMapper: 生意社简单对象的保存
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    17:59
 **/
public interface PipiInfoSimpleMapper {
    void insert(List<PipiInfoSimple> list);
    int queryCountByTime(@Param("time") String time);
}
