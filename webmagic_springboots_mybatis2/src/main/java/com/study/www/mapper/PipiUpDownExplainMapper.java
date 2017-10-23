package com.study.www.mapper;

import com.study.www.entity.PipiUpDownExplain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PipiUpDownExplainMapper: 生意社简单对象的保存
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    17:59
 **/
@Repository
public interface PipiUpDownExplainMapper {
    void insert(PipiUpDownExplain pipiUpDownExplain);
    int queryCountByTime(@Param("time") String time);
}
