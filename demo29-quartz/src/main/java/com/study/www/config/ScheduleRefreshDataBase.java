package com.study.www.config;

import com.study.www.model.ConfigRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: : 根据数据库定时更新任务
 * @date :Create in  2018/2/23- 15:36
 * @Version: V1.0
 * @Modified By:
 **/
@Configuration
@EnableScheduling
@Component
public class ScheduleRefreshDataBase {
    @Autowired
    private ConfigRepository repository;

    @Resource(name="jobDetail")
    private JobDetail jobDetail;

    @Resource(name="jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name="scheduler")
    private Scheduler scheduler;

    @Scheduled(fixedDelay  = 10000) // 每隔10s查库，并根据查询结果决定是否重新设置定时任务
    public void scheduleUpdateCronTrigger() throws SchedulerException{
        CronTrigger trigger =(CronTrigger)scheduler.getTrigger(cronTrigger.getKey());
        //当前定时任务使用的cron表达式
        String oldCron = trigger.getCronExpression();
        //数据库里面的cron表达式
        String searchCron = repository.findOne(1L).getCron();
        System.out.println("当前定时任务使用的cron表达式:"+oldCron);
        System.out.println("数据库里面的cron表达式:"+searchCron);
        //判断数据库里面的cron表达式和当前定时任务的cron表达式是否一致
        if (oldCron.equals(searchCron)){
            //一致 不刷新任务
        }else{
            //不一致则进行任务的改变
            //修改数据库里面的cron表达式利用构造器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
            //按照新的规则构造trigger
            trigger=(CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
                    .withSchedule(cronScheduleBuilder).build();
            //按照新的trigger重新设置job执行
            scheduler.rescheduleJob(cronTrigger.getKey(),trigger);
        }
    }
}
