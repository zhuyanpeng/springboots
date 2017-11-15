package com.study.www.service;

import com.study.www.domain.User;
import com.study.www.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-16 06:29
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @CachePut(key = "#user.account",value = "users")
    public User updateUserByAccount(User user){
        userRepository.updateNameByAccount(user.getAccount(),user.getName());
        User byAccount1 = userRepository.findByAccount1(user.getAccount());
        return byAccount1;
    }
    @CacheEvict(key = "#p0",value = "users",beforeInvocation = false,condition = "#result == null ")
    public User removeByAccount(String account){
        userRepository.removeByAccount(account);
        User byAccount1 = userRepository.findByAccount1(account);
        return byAccount1;
    }


}
