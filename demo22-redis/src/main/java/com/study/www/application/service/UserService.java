package com.study.www.application.service;

import com.study.www.application.domain.User;
import com.study.www.application.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-18 09:25
 */
@Service
@CacheConfig(cacheNames = "redisName")
public class UserService {
    @Autowired
    UserRepository userRepository;
    @CachePut(key = "#user.account")
    public User updateByAccunt(User user){
        userRepository.updateUserByAccount(user.getAccount(),user.getName());
        User byAccuntNoCache = userRepository.findByAccuntNoCache(user.getAccount());
        return  byAccuntNoCache;
    }
    @CacheEvict(key = "#p0",beforeInvocation = false,condition = "#result==null")
    public User removeByAccount(String account){
        int i = userRepository.removeByAccount(account);
        if (i>0){
            return null;
        }
        return userRepository.findByAccuntNoCache(account);
    }
}
