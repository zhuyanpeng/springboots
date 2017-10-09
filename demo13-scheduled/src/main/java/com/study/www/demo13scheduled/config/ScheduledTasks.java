package com.study.www.demo13scheduled.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ScheduledTasks: 定时任务内
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/9    15:59
 **/
@Component
public class ScheduledTasks {

      /**
    * @Author: Administrator.zhuyanpeng
    * @Description:上一次开始执行时间点之后n秒后再次执行
    * @Date: 16:12 2017/10/9
    **/
    @Scheduled(fixedRate = 1000)
    public void  fixedRate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        Random random= new Random();
        System.out.println("北京时间:"+simpleDateFormat.format(new Date()));
        try {
            int i = random.nextInt(3) * 1000;
            Thread.sleep(i );
            System.out.println("等待时间"+i/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: Administrator.zhuyanpeng
     * @Description:上次执行完毕时间点之后n秒后再次执行
     * @Date: 16:12 2017/10/9
     **/
    @Scheduled(fixedDelay = 1000)
    public void fixedDelay(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        Random random= new Random();
        System.out.println("北京时间:"+simpleDateFormat.format(new Date()));
        try {
            int i = random.nextInt(3) * 1000;
            Thread.sleep(i );
            System.out.println("等待时间"+i/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   /**
    * @Author: Administrator.zhuyanpeng
    * @Description:第一次启动延迟1秒之后按照后文规矩进行运行
    * @Date: 16:58 2017/10/9
    **/
    @Scheduled(initialDelay = 1000,fixedRate = 2000)
   public void initialDelay(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        Random random= new Random();
        System.out.println("北京时间:"+simpleDateFormat.format(new Date()));
        try {
            int i = random.nextInt(3) * 1000;
            Thread.sleep(i );
            System.out.println("等待时间"+i/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }
  /**
   * @Author: Administrator.zhuyanpeng
   * @Description:通过cron规则进行运行
   * @Date: 17:01 2017/10/9
   **/
  @Scheduled(cron = "*/5 * * * * *")
  public void cron(){
      SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
      System.out.println("北京时间:"+simpleDateFormat.format(new Date()));
  }


}
