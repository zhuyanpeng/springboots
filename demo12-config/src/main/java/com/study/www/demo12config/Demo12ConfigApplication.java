package com.study.www.demo12config;

import com.study.www.demo12config.config.RandomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo12ConfigApplication implements CommandLineRunner{

	@Autowired
	RandomProperties randomProperties;
	@Override
	public void run(String... strings) throws  Exception{
		randomProperties.start();
	}
	//注意看此处并没有使用SpringApplication.run直接启动而是用的另外的方法
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Demo12ConfigApplication.class);
		//springApplication.setAddCommandLineProperties(false); ##此可以禁止jar 后文的配置追加
		springApplication.run(args);

		//SpringApplication.run(Demo12ConfigApplication.class, args);
	}

}
