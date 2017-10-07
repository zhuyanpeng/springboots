package com.study.com.demo10mongodb;

import com.study.com.demo10mongodb.domain.User;
import com.study.com.demo10mongodb.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo10MongodbApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test1(){
		userRepository.save(new User(1234L,"绿泡泡",30));
		userRepository.save(new User(1235L,"绿泡泡1",30));
		userRepository.save(new User(1236L,"绿泡泡2",30));
	}
	@Test
	public void test2(){
		List<User> all = userRepository.findAll();
		for (User user : all) {
			System.out.println(user);
		}

	}

}
