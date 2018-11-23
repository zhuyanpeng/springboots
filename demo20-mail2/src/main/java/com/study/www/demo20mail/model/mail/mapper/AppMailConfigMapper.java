package com.study.www.demo20mail.model.mail.mapper;

import cn.xunjie.www.model.common.mail.AppMailConfig;
import cn.xunjie.www.model.common.mail.AppMailConfigExample;
import com.study.www.demo20mail.model.mail.AppMailConfig;
import com.study.www.demo20mail.model.mail.AppMailConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppMailConfigMapper {
    int countByExample(AppMailConfigExample example);

    int deleteByExample(AppMailConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppMailConfig record);

    int insertSelective(AppMailConfig record);

    List<AppMailConfig> selectByExample(AppMailConfigExample example);

    AppMailConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppMailConfig record, @Param("example") AppMailConfigExample example);

    int updateByExample(@Param("record") AppMailConfig record, @Param("example") AppMailConfigExample example);

    int updateByPrimaryKeySelective(AppMailConfig record);

    int updateByPrimaryKey(AppMailConfig record);
}