package com.study.cn;


import com.study.cn.model.Permissions;
import com.study.cn.model.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 启动类
 * @date :Create in  2018/3/5- 11:24
 **/
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    PermissionsRepository repository;
    @Autowired
    StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Permissions> permissions = repository.findAll();
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        for (Permissions permission : permissions) {
            String value =stringStringValueOperations.get(permission.getUserId());
            if (value==null){
                stringStringValueOperations.set(permission.getUserId(),permission.getPermission());
            }else{
                value= value+","+permission.getPermission();
                stringStringValueOperations.set(permission.getUserId(),value);
            }

        }
    }
}
