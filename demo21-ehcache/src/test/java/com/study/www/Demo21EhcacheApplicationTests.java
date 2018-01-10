package com.study.www;

import com.study.www.domain.User;
import com.study.www.domain.UserRepository;
import com.study.www.service.UserService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo21EhcacheApplicationTests {


	@Autowired
	UserRepository userRepository;

	@Autowired
	CacheManager cacheManager;

	@Autowired
	UserService userService;

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

	//测试key的设定和缓存条件当第一个参数小于4时才被缓存
	@Test
	public void conditionTest(){
		User byNameAndAccount = userRepository.findByNameAndAccount("测试110", "mirror110");
		System.out.println(byNameAndAccount);
		//检查缓存中是否已经缓存了
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("users").get("测试110");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
		byNameAndAccount = userRepository.findByNameAndAccount("测试1", "mirror1");
		System.out.println(byNameAndAccount);
		valueWrapper = cacheManager.getCache("users").get("测试1");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
	}
	//测试输出参数 必须小于4位
	@Test
	public void unlessTest(){
		User mirror18 = userRepository.findByIdAndAccount(20L, "mirror18");
		System.out.println(mirror18);
		//检查缓存中是否已经缓存了
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("users").get("mirror18");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
	}
	//测试修改
	@Test
	public void putTest(){
		User mirror18 = userRepository.findByAccount("mirror1");
		System.out.println(mirror18);
		mirror18.setName("一人我饮酒醉");
		userService.updateUserByAccount(mirror18);
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("users").get("mirror1");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
		User mirror181 = userRepository.findByAccount("mirror18");
		System.out.println(mirror181);
	}

	//测试删除
	@Test
	@Transactional
	public void removeTest(){
		User mirror18 = userRepository.findByAccount("mirror5");
		System.out.println(mirror18);
		Cache.ValueWrapper valueWrapper = cacheManager.getCache("users").get("mirror5");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
		User mirror181 = userService.removeByAccount("mirror5");
		valueWrapper= cacheManager.getCache("users").get("mirror5");
		System.out.println("查看缓存中的数据:"+(valueWrapper==null?"无数据":valueWrapper.get()));
		System.out.println(mirror181);
	}

}
