package com.study.www.service.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description: : 定时任务
 * @date :Create in  2018/2/23- 15:05
 * @Version: V1.0
 * @Modified By:
 **/
@Component
@Configuration
@EnableScheduling
public class ScheduleTask {

    private static final Logger LOGGER= LoggerFactory.getLogger(ScheduleTask.class);

    public void sayHello(){
        LocalDateTime time = LocalDateTime.now();
        LOGGER.warn("你好！Quartz:当前时间="+time.getHour()+"时"+time.getMinute()+"分"+time.getSecond()+"秒");
    }
}
