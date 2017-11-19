package com.study.www;

import com.study.www.domain.User;
import com.study.www.domain.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo81MybatisApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Test
	public void insertTest() {
		User user = new User();
		user.setId(1002L);
		user.setAccount("mirror1002Demo8");
		user.setName("测试Demo8");
		user.setSex(1);
		userMapper.insertUser(user);
	}

	@Test
	public void findTest1(){
		User mirror1002Demo8 = userMapper.findByAccount("mirror1002Demo8");
		System.out.println(mirror1002Demo8);
	}

	@Test
	public void selectTest2(){
		List<User> mirror = userMapper.selectByLikeAccount("%mirror%");
		for (User user : mirror) {
			System.out.println(user);
		}
	}

}
