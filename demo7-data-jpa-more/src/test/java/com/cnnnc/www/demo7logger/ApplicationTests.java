package com.cnnnc.www.demo7logger;

import com.cnnnc.www.domain.message.MessagePO;
import com.cnnnc.www.domain.message.MessageRepository;
import com.cnnnc.www.domain.user.UserPO;
import com.cnnnc.www.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class ApplicationTests {

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
		MessagePO messagePO = new MessagePO();
		messagePO.setName("德玛");
		messagePO.setContent("this is hibernate");
		MessagePO save = messageRepository.save(messagePO);
		UserPO userPO = new UserPO();
		userPO.setName("安其拉");
		userPO.setAge(12);
		UserPO save1 = userRepository.save(userPO);
	}

}
