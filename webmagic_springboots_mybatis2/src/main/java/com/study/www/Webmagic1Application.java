package com.study.www;

import com.study.www.service.DzspProcessorService;
import com.study.www.service.PipiInfoline;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Author: Administrator.zhuyanpeng
 * @Description:手动点击运行
 * @Date: 16:04 2017/10/13
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.study.www.mapper")
//CommandLineRunner定义初始化完毕之后进行的加载
public class Webmagic1Application implements CommandLineRunner {
	private  static  final  String url="http://www.100ppi.com/price/";
	@Autowired
	DzspProcessorService dzspRepoPageProcessor;
	@Autowired
	PipiInfoline pipiInfoline;

	//初始加载
	@Override
	public void run(String... strings) throws Exception {
		new Thread(() -> dzspRepoPageProcessor.start(dzspRepoPageProcessor, pipiInfoline)).start();
	}

	public static void main(String[] args) {
		SpringApplication.run(Webmagic1Application.class, args);
	}
}
