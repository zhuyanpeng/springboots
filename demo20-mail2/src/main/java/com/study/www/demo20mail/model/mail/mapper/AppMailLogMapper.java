package com.study.www.demo20mail.model.mail.mapper;

import cn.xunjie.www.model.common.mail.AppMailLog;
import cn.xunjie.www.model.common.mail.AppMailLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppMailLogMapper {
    int countByExample(AppMailLogExample example);

    int deleteByExample(AppMailLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppMailLog record);

    int insertSelective(AppMailLog record);

    List<AppMailLog> selectByExampleWithBLOBs(AppMailLogExample example);

    List<AppMailLog> selectByExample(AppMailLogExample example);

    AppMailLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppMailLog record, @Param("example") AppMailLogExample example);

    int updateByExampleWithBLOBs(@Param("record") AppMailLog record, @Param("example") AppMailLogExample example);

    int updateByExample(@Param("record") AppMailLog record, @Param("example") AppMailLogExample example);

    int updateByPrimaryKeySelective(AppMailLog record);

    int updateByPrimaryKeyWithBLOBs(AppMailLog record);

    int updateByPrimaryKey(AppMailLog record);
}