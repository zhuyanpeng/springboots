package com.study.www;

import com.google.gson.Gson;
import com.study.www.model.User;
import com.study.www.service.MyTableSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class Demo25WebsocketApplication {



	@Scheduled(cron = "0/3 * * * * ?") // 每天的9点11点14点16点半运行一次
	public void scheduler(){
		long l = new Date().getTime() %5;
		double randomInt = new Random().nextInt(1000);
		User user = new User("0" + l, new Double(randomInt/10+randomInt%10));
		String str = new Gson().toJson(user);
		try {
			MyTableSocket.sendInfo(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(Demo25WebsocketApplication.class, args);
	}
}
