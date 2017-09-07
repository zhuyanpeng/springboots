package com.example.demo5datajpa;

import com.example.demo5datajpa.domain.User;
import com.example.demo5datajpa.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo5DataJpaApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		userRepository.save(new User("aa1",123456));
		userRepository.save(new User("aa2",123456));
		userRepository.save(new User("aa3",123456));
		userRepository.save(new User("aa4",123456));
		userRepository.save(new User("aa5",123456));
		userRepository.save(new User("aa6",123456));
		User aa1 = userRepository.findUser("aa1");
		System.out.println(aa1);

	}

}
