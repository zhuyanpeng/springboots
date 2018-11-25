package com.study.www.demo20mail;

import com.study.www.demo20mail.model.mail.MailConfig;
import com.study.www.demo20mail.model.mail.MailConfigRepository;
import com.study.www.demo20mail.service.MailService;
import com.sun.corba.se.spi.monitoring.MonitoredAttributeInfo;
import freemarker.template.TemplateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo20MailApplicationTests {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private MailService mailService;

	@Autowired
	MailConfigRepository mailConfigRepository;
	//3	smtp.163.com	zhuyanpengyy@163.com	z8912005
	// 	zhuyanpengyy@163.com	zhuyanpengyy@163.com
	// 	242	0	2018-10-18 23:14:07	1	2018-10-18 23:14:07	1	0	600
	@Before
	public void before(){
		MailConfig mailConfig = new MailConfig();
		mailConfig.setSmtp("smtp.163.com");
		mailConfig.setMailpassword("z8912005");
		mailConfig.setSenderaddress("zhuyanpengyy@163.com");
		mailConfig.setSendnum(0);
		mailConfig.setStatus(0);
		mailConfig.setAuthcodetime(300);
		mailConfig.setCreatetime(new Date());
		mailConfig.setCreateby("666");
		mailConfig.setUpdatetime(new Date());
		mailConfig.setUpdateby("666");
		mailConfig.setIsdel(0);
		mailConfigRepository.save(mailConfig);
	}
	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("ads@qq.com");
		simpleMailMessage.setTo("as@qq.com");
		simpleMailMessage.setSubject("主题：简单邮件");
		simpleMailMessage.setText("测试邮件内容");
		javaMailSender.send(simpleMailMessage);
	}

	@Test
	public void testSendMail(){
		String send = "zhuyanpengyy@163.com";
		String subject ="好的";
		Map<String, String>  map = new HashMap<>();
		map.put("authCode","1234");
		String templateName = "register";
		try {
			mailService.sendMailByTemplate(send,subject,map, templateName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
