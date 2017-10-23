package com.study.www.demo15log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo15Log4jApplicationTests {
	//private Logger logger = Logger.getLogger(getClass());1.4.2之前
	private Logger logger = LogManager.getLogger(getClass().getName());
	@Test
	public void test() throws Exception {

		logger.info("log4j2-输出info");
		logger.debug("log4j2-输出debug");
		logger.error("log4j2-输出error");
	}
}
