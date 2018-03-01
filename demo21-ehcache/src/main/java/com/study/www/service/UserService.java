package com.study.www.service;

import com.study.www.domain.User;
import com.study.www.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-16 06:29
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    @Autowired
    EhCacheCacheManager ehCacheCacheManager;
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
    @Cacheable(key = "#p0",value = "users")
    public User findByName(String name){
        Cache userCache = ehCacheCacheManager.getCache("users");
        return userRepository.findByName(name);
    }

    /**
     * 将所有的用户按照账号：用户存入缓存
     * @return
     */
    public List<User> select(){
        List<User> userList= userRepository.findAll();
        Cache userCache = ehCacheCacheManager.getCache("users");
        for (User user : userList) {
            userCache.put(user.getAccount(),user);
        }
        return userList;
    }

    public List<User> findAll(){
        List<User> users;
        Cache cache = ehCacheCacheManager.getCache("users");
        if (cache.get("all")==null){
            users = userRepository.findAll();
            cache.put("all",users);
        }else{
            users= (List<User>) cache.get("all").get();
        }
        return users;
    }

    //如果select成功了的话那么这个就应该是有值的
    @Cacheable(key = "#p0",value = "users")
    public User findByAccount(String account){
        return null;
    }
}
