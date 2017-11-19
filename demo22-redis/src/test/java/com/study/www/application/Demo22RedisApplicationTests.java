package com.study.www.application;

import com.study.www.application.domain.User;
import com.study.www.application.domain.UserRepository;
import com.study.www.application.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo22RedisApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	UserService userService;
	@Test
	public void contextLoads1() {
		Date date = new Date();
		User mirror = userRepository.findByName("测试20");
		Date date1  = new Date();
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		mirror = userRepository.findByName("测试20");
		System.out.println("第二次查询耗时:"+(new Date().getTime()-date1.getTime())+"["+mirror.toString()+"]");
	}

	@Test
	public void accountTest2(){
		Date date = new Date();
		User mirror = userRepository.findByAccount("mirror20");
		Date date1  = new Date();
		SimpleValueWrapper valueWrapper = (SimpleValueWrapper) cacheManager.getCache("redisName").get("mirror20");
		System.out.println("查看cache中的数据:"+valueWrapper.get());
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		mirror = userRepository.findByAccount("mirror20");
		System.out.println("第二次查询耗时:"+(new Date().getTime()-date1.getTime())+"["+mirror.toString()+"]");
	}
	@Test
	public void putTest3(){
		Date date = new Date();
		User mirror = userRepository.findByAccount("mirror13");
		Date date1  = new Date();
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("redisName").get("mirror13");
		System.out.println("缓存中的数据"+valueWrapper.get());
		mirror.setName("扩延");
		User user = userService.updateByAccunt(mirror);
		valueWrapper = cacheManager.getCache("redisName").get("mirror13");
		System.out.println("缓存中的数据"+valueWrapper.get());
		//再次尝试查询会发现不走数据库了
		 mirror = userRepository.findByAccount("mirror13");
		System.out.println(mirror);
	}
	//删除数据
	@Test
	public void removeTest4(){
		Date date = new Date();
		User mirror = userRepository.findByAccount("mirror48");
		Date date1 = new Date();
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("redisName").get("mirror48");
		System.out.println("缓存中的数据:"+valueWrapper.get());
		 userService.removeByAccount("mirror48");
		valueWrapper = cacheManager.getCache("redisName").get("mirror48");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
	}
}
