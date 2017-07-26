package com.study.www.mapper;

import com.study.www.entity.PipiInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * PipiInfoMapper: 对象全部保存
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    17:58
 **/
public interface PipiInfoMapper {
    void insert(List<PipiInfo> list);
}
