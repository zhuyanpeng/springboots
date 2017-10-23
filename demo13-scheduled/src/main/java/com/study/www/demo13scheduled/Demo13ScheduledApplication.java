package com.study.www.demo13scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Demo13ScheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo13ScheduledApplication.class, args);
	}
}
