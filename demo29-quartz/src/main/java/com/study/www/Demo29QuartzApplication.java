package com.study.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Demo29QuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo29QuartzApplication.class, args);
	}
}
