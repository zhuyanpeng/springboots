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
        int i = userRepository.updateNameByAccount(user.getAccount(), user.getName());
        if (i>0){
            return userRepository.findByAccount1(user.getAccount());
        }
        throw  new RuntimeException("Data delete function is error");
    }
    //根据传入的参数第一个去存入缓存users中，beforeInvocation 方法调用完毕之后进行使用,condition 判断回参是否为null为null则进行删除
    @CacheEvict(key = "#p0",value = "users",beforeInvocation = false,condition = "#result == null ")
    public User removeByAccount(String account){
        userRepository.removeByAccount(account);
        User byAccount1 = userRepository.findByAccount1(account);
        return byAccount1;
    }


}
