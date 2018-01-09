package com.study.www.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan
public class Demo22RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo22RedisApplication.class, args);
	}
}
