package com.study.www.demo15log4j;

import com.study.www.demo15log4j.logfile.LogEx;
import com.study.www.demo15log4j.slfEx.SlfFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo15Log4jApplication implements CommandLineRunner{
	@Autowired
	LogEx logEx;
	@Autowired
	SlfFile slfFile;

	@Override
	public void run(String... strings) throws Exception {
		logEx.log();
		slfFile.log();
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo15Log4jApplication.class, args);

	}
}
