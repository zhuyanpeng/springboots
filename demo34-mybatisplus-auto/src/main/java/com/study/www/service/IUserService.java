package com.study.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.www.entity.Role;
import com.study.www.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.www.entity.UserRoleVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2018-11-28
 */
public interface IUserService extends IService<User> {

    UserRoleVo queryUserVoByUserId( String userId);
}
