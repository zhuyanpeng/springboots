package com.study.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Demo21EhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo21EhcacheApplication.class, args);
	}
}
