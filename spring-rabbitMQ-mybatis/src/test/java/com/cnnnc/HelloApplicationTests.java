package com.cnnnc;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApplication.class)
@Transactional
public class HelloApplicationTests {
/*
	@Autowired
	private Sender sender;
	@Autowired
	private D1Mapper d1Mapper;

	@Test
	public void hello() throws Exception {
		for (int i = 0; i < 20; i++) {
			*//*D1 d1 = new D1();
			d1.setNum("mirror"+i);
			d1.setWindCode("路过蜻蜓!");
			d1.setWindTime("錄過蜻蜓");
			*//**//*String str =JSON.toJSONString(d1);
			sender.sendMsg(str);*//**//*
			int insert = d1Mapper.insert(d1.getNum(), d1.getWindCode(), d1.getWindTime());
			System.out.println(insert);*//*
					D1 d1 = new D1();
			d1.setNum("mirror"+i);
			d1.setWindCode("路过蜻蜓!");
			d1.setWindTime("錄過蜻蜓");
			String str =JSON.toJSONString(d1);
			sender.sendMsg(str);
		}

	}*/

}
