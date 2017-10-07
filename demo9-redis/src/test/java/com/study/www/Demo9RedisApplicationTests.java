package com.study.www;

import com.study.www.domain.RedisObjectSerializer;
import com.study.www.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo9RedisApplicationTests {

	//redis读写模板从命名可以看出其支持String类型是redisTemplate的实现
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String,User> redisTemplate;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test1(){
		stringRedisTemplate.opsForValue().set("aaa1",2134+"dsaf");
		String aaa = stringRedisTemplate.opsForValue().get("aaa");
		System.out.println(aaa);
	}
	@Test
	public void test2(){
		User user = new User("超人", 20);
		redisTemplate.opsForValue().set(user.getUsername(),user);
	}
	@Test
	public void test3(){
		User user= redisTemplate.opsForValue().get("超人");
		System.out.println(user);
	}
	@Test
	public void test4(){
		User haha = new User("haha", 1234);
		byte[] serialize = new RedisObjectSerializer().serialize(haha);
		System.out.println(serialize);
		Object user = new RedisObjectSerializer().deserialize(serialize);
		System.out.println(((User)user).getUsername());
	}
}
