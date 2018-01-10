package com.study.www;

import com.study.www.domain.User;
import com.study.www.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.Date;

@SpringBootApplication
//@EnableCaching
@EnableCaching
/*EnableCaching 开启缓存springboot会根据如下的顺序去探测缓存的提供者：Generic;JSR-107;EhCache;Hazelcast;infinispan;redis
simple除了按顺序探测之外我们也可以通过配置属性Spring.cache.type来强制指定。我们也可以通过debug调试查看到cacheManager对象
到底是用的是什么缓存*/
public class Demo21EhcacheApplication {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(Demo21EhcacheApplication.class, args);

	}
}
