package com.example.www.demo4jdbctemplate;

import com.example.www.demo4jdbctemplate.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo4JdbcTemplateApplicationTests {
	@Autowired
	UserService userService;
	@Test
	public void contextLoads() {
	}
	//首先清空表
	@Before
	public void setUp(){
		userService.dropUserTable();
		userService.creatUserTable();
		userService.deleteAllUsers();
	}
	@Test
	public void test(){
		userService.create("张三",10);
		userService.create("李四",11);
		userService.create("王五",12);
		//断言查询数据库应该有3条记录
		Assert.assertEquals(3,userService.getAllUsers().intValue());
		//删除1条记录
		userService.deletByName("张三");
		//断言查询出来应有2条
		Assert.assertEquals(2,userService.getAllUsers().intValue());
	}

}
