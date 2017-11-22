package com.study.www.demo23rabbitmq;

import com.study.www.demo23rabbitmq.service.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo23RabbitmqApplicationTests {

	@Autowired
	Sender sender;
	@Test
	public void contextLoads() {
		for (int i = 0; i < 100; i++) {
			sender.send("hhaha"+i);
		}
	}

}
