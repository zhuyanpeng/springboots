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
     * 执行细节
     * @Date: 2018/2/23 15:13
     */
    @Bean(name="jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        /*是否并发执行,在本次执行未结束之前是否能开启下次执行*/
        jobDetail.setConcurrent(false);
        //任务名
        jobDetail.setName("schedule-hello");
        //任务组名 多任务的时候任务名和任务组名会有作用
        jobDetail.setGroup("schedule");
        /*需要执行的对象*/
        jobDetail.setTargetObject(task);
        /*需要执行的方法，此方法将会来源于实体对象本例子中的ScheduleTask-sayHello*/
        jobDetail.setTargetMethod("sayHello");
        return jobDetail;
    }

    /**
     * 任务的触发执行
     * @Date: 2018/2/23 15:21
     */
    @Bean(name="jobTrigger")
    public CronTriggerFactoryBean  cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean jobTrigger = new CronTriggerFactoryBean();
        jobTrigger.setJobDetail(jobDetail.getObject());
        jobTrigger.setCronExpression("0/5 * * * * ?");
        jobTrigger.setName("schedule-hello");
        return jobTrigger;
    }

    /**
     * 调度工厂
     * @Date: 2018/2/23 15:26
     */
    @Bean(name="scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger trigger){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        /*用于Quartz集群,启动时更新已存在的Job*/
        factoryBean.setOverwriteExistingJobs(true);
        /*定时任务开始启动后延迟5秒开始*/
        factoryBean.setStartupDelay(30);
        /*触发器的注册*/
        factoryBean.setTriggers(trigger);
        return factoryBean;
    }
}
