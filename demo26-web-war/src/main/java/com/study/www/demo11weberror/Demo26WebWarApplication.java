package com.study.www.demo11weberror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Demo26WebWarApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Demo26WebWarApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Demo26WebWarApplication.class);
	}
}
