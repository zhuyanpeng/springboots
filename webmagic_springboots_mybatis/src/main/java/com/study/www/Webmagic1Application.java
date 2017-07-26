package com.study.www;

import com.study.www.service.DzspProcessorService;
import com.study.www.service.PipiInfoline;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan(basePackages = "com.study.www.mapper")
//CommandLineRunner定义初始化完毕之后进行的加载
@EnableScheduling
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
	@Scheduled(cron = "00 50 08 * * ?") // 每天的三点执行一次
	public void scheduler() {
	/*	//判断今天是否是星期六或者星期天是的话跳过
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w !=0&&w !=6){
			new Thread(() -> dzspRepoPageProcessor.start(dzspRepoPageProcessor, pipiInfoline)).start();
		}*/
	}

	public static void main(String[] args) {
		SpringApplication.run(Webmagic1Application.class, args);
	}
}
