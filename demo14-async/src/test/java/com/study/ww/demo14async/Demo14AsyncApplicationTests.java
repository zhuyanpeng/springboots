package com.study.ww.demo14async;

import com.study.ww.demo14async.config.AsyncTasks;
import com.study.ww.demo14async.config.FutureTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class Demo14AsyncApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	AsyncTasks asyncTasks;
	@Test
	public void test1(){
		asyncTasks.doTaskOne();
		asyncTasks.doTaskTwo();
		asyncTasks.doTaskThree();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	FutureTasks futureTasks;
	@Test
	public void test2(){
		Future<String> stringFuture = futureTasks.doTaskOne();
		Future<String> stringFuture1 = futureTasks.doTaskTwo();
		Future<String> stringFuture2 = futureTasks.doTaskThree();
		//判断是否执行完毕
		try {
			while (true){
                if (stringFuture.isDone()&&stringFuture1.isDone()&&stringFuture2.isDone()){
                    break;
                }
                    Thread.sleep(1000);
            }
			System.out.println(stringFuture.get());
			System.out.println(stringFuture1.get());
			System.out.println(stringFuture2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
