package com.study.www.demo12config;

import com.study.www.demo12config.config.BlogProperties;
import com.study.www.demo12config.config.RandomProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo12ConfigApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	@Autowired
	private RandomProperties randomProperties;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test1(){
		System.out.println(blogProperties.getName());
		System.out.println(blogProperties.getTitle());
		Integer[] arr = blogProperties.getArr();
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public  void test2(){
		System.out.println(blogProperties.getAll());
	}
	@Test
	public void test3(){
		System.out.println("value:"+randomProperties.getValue());
		System.out.println("number:"+randomProperties.getNumber());
		System.out.println("long:"+randomProperties.getaLong());
		System.out.println("int1:"+randomProperties.getInt1());
		System.out.println("int2:"+randomProperties.getInt2());
		System.out.println("uuid:"+randomProperties.getUuid());
	}

}
