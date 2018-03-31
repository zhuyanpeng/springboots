package com.study.www.config;

import com.study.www.service.task.ScheduleTask;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description: : 定时任务的配置
 * @date :Create in  2018/2/23- 15:11
 * @Version: V1.0
 * @Modified By:
 **/
@Configuration
public class QuartzConfiguration {
    /**
     * 调度工厂
     * @Date: 2018/2/23 15:26
     */
    @Bean
    public SchedulerFactoryBean schedulerFactory(){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        /*用于Quartz集群,启动时更新已存在的Job*/
        factoryBean.setOverwriteExistingJobs(true);
        /*定时任务开始启动后延迟5秒开始*/
        factoryBean.setStartupDelay(5);
        return factoryBean;
    }
}
