package com.study.www;

import com.study.www.domain.User;
import com.study.www.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo21EhcacheApplicationTests {


	@Autowired
	UserRepository userRepository;

	@Autowired
	CacheManager cacheManager;

	@Before
	public void before(){
		/*for (int i = 0; i < 1000; i++) {
			userRepository.save(new User("mirror"+i,"测试"+i,i));
		}*/
	}
	//name
	@Test
	public void nameTest() {
		Date date = new Date();
		User mirror = userRepository.findByName("测试20");
		Date date1  = new Date();
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		 mirror = userRepository.findByName("测试20");
		System.out.println("第二次查询耗时:"+(new Date().getTime()-date1.getTime())+"["+mirror.toString()+"]");
	}
	//account
	@Test
	public void accountTest(){
		Date date = new Date();
		User mirror = userRepository.findByAccount("mirror20");
		Date date1  = new Date();
		SimpleValueWrapper valueWrapper = (SimpleValueWrapper) cacheManager.getCache("users").get("mirror20");
		System.out.println("查看cache中的数据:"+valueWrapper.get());
		System.out.println("第一次查询耗时:"+(date1.getTime()-date.getTime())+"["+mirror.toString()+"]");
		mirror = userRepository.findByAccount("mirror20");
		System.out.println("第二次查询耗时:"+(new Date().getTime()-date1.getTime())+"["+mirror.toString()+"]");
	}

}
