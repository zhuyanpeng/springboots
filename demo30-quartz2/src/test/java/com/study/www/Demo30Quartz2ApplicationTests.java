package com.study.www;

import com.study.www.model.Config;
import com.study.www.model.mapper.ConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo30Quartz2ApplicationTests {
	@Autowired
	ConfigRepository configRepository;
	@Test
	public void contextLoads() {
	}


	@Test
	@Transactional
	public void test1(){
		Config config= configRepository.findOne(1L);
		config.setStatus("0");
		int i = configRepository.setStatusById(config.getStatus(), config.getId());
		System.out.println(i);
	}
}
