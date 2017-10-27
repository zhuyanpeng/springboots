package com.study.www.mapper;

import com.study.www.entity.PipiUpDownEntity;
import com.study.www.entity.PipiUpDownExplain;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PipiInfoMapper: 对象全部保存
 *
 * @auther : Administrator.zhuyanpeng
 * @date :  2017/7/25    17:58
 **/
@Repository
public interface PipiUpDownEntityMapper {
    void insert(PipiUpDownEntity pipiUpDownEntity);

    int queryByEntity(PipiUpDownEntity pipiUpDownEntity);
}
