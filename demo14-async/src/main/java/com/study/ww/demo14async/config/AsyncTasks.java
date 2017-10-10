package com.study.ww.demo14async.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * NoAsyncTasks: 异步
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/9    17:16
 **/
@Component
public class AsyncTasks {
    public static Random random=new Random();
    @Async
    public void doTaskOne(){
        System.out.println("开始做任务一");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务一结束用时:"+(System.currentTimeMillis()-l));
    }
    @Async
    public void doTaskTwo(){
        System.out.println("开始做任二");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务二结束用时:"+(System.currentTimeMillis()-l));
    }
    @Async
    public void doTaskThree(){
        System.out.println("开始做任务三");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务三结束用时:"+(System.currentTimeMillis()-l));
    }



}
