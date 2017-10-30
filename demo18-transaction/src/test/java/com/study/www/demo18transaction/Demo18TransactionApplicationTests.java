package com.study.www.demo18transaction;

import com.study.www.demo18transaction.domain.User;
import com.study.www.demo18transaction.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo18TransactionApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	@Transactional//一般加载service接口的方法上面如果是多个是数据源得在Transactional后面加上Value选择对应的源
	/*@Rollback注解可以模拟提交用在测试单元上感觉犇*/
	public void contextLoads() {
		userRepository.save(new User("A",12));
		userRepository.save(new User("B",12));
		userRepository.save(new User("C",12));
		userRepository.save(new User("D",12));
		//此处报错但是前面的内容已经被提交了，因此得进行事务操作加上一个@Transactional
		/*
		可以在console中清晰的看到如下回滚的内容
		Rolled back transaction for test context [DefaultTestContext@4c309d4d ****/
		userRepository.save(new User("EEEEEEEEEEEEE",12));
		userRepository.save(new User("F",12));
		userRepository.save(new User("G",12));
		int size = userRepository.findAll().size();
		System.out.println(size);
	}

}
