package com.study.www.demo20mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo20MailApplicationTests {
	@Autowired
	private JavaMailSender javaMailSender;
	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("ads@qq.com");
		simpleMailMessage.setTo("as@qq.com");
		simpleMailMessage.setSubject("主题：简单邮件");
		simpleMailMessage.setText("测试邮件内容");
		javaMailSender.send(simpleMailMessage);
	}

}
