package com.study.www.demo7mybatismore.domain.cnnnc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * UserMapper: userMapper
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/9/20    9:12
 **/
@Component
public interface UserMapper {
    public Map<String,Object> findByAccount(@Param("account") String account);
}
