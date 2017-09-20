package com.study.www.demo7mybatismore;

import com.study.www.demo7mybatismore.domain.cnnnc.mapper.UserMapper;
import com.study.www.demo7mybatismore.domain.dbstk.mapper.TbFileMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo7MybatisMoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	UserMapper userMapper;
	@Autowired
	TbFileMapper tbFileMapper;

	@Test
	public void findTest(){
		Map<String, Object> admin = userMapper.findByAccount("mirror1");
		List<Map<String, String>> timeAndCodeByStrategyId = tbFileMapper.findTimeAndCodeByStrategyId();
		System.out.println(timeAndCodeByStrategyId.toArray().toString());

	}

}
