package com.study.www.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.www.entity.User;
import com.study.www.entity.UserRoleVo;
import com.study.www.mapper.UserMapper;
import com.study.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public UserRoleVo queryUserVoByUserId(String userId) {
        return  userMapper.queryUserVoByUserId(userId);
    }
}
