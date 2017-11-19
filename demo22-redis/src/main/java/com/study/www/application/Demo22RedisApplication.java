package com.study.www.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Demo22RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo22RedisApplication.class, args);
	}
}
