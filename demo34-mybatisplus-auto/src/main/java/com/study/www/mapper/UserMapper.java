package com.study.www.mapper;

import com.study.www.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.www.entity.UserRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-11-28
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    UserRoleVo queryUserVoByUserId(@Param("userId") String userId);
}
