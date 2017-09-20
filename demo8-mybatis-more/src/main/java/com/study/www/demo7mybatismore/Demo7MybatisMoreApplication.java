package com.study.www.demo7mybatismore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//禁用掉自动去properties读取data信息
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class Demo7MybatisMoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo7MybatisMoreApplication.class, args);
	}
}
