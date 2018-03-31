package com.study.www.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ScheduleTask: 定时任务的服务
 *
 * @date :  2018/2/23    16:29
 **/
@Service
public class ScheduleTask {
    private static final Logger LOGGER= LoggerFactory.getLogger(ScheduleTask.class);

    public void test1(){
        LocalDateTime time = LocalDateTime.now();
        LOGGER.warn("good!good!study!:当前时间="+time.getHour()+"时"+time.getMinute()+"分"+time.getSecond()+"秒");
    }

    public void test2(){
        LocalDateTime time = LocalDateTime.now();
        LOGGER.warn("day!day!UP!!:当前时间="+time.getHour()+"时"+time.getMinute()+"分"+time.getSecond()+"秒");
    }
}
