package com.study.ww.demo14async.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * FutureTasks: 回调
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/10    13:44
 **/
@Component
public class FutureTasks {
    public static Random random=new Random();
    @Async
    public Future<String> doTaskOne(){
        System.out.println("开始做任务一");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务一结束用时:"+(System.currentTimeMillis()-l));
        return new AsyncResult<>("GAME OVER!一");
    }
    @Async
    public Future<String> doTaskTwo(){
        System.out.println("开始做任务二");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务二结束用时:"+(System.currentTimeMillis()-l));
        return new AsyncResult<>("GAME OVER!二");
    }
    @Async
    public Future<String> doTaskThree(){
        System.out.println("开始做任务三");
        long l = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务三结束用时:"+(System.currentTimeMillis()-l));
        return new AsyncResult<>("GAME OVER!三");
    }
}
