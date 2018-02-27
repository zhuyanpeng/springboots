package com.study.www.config;

import com.study.www.model.Config;
import com.study.www.utils.TaskUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description: : 禁止并发执行
 * @date :Create in  2018/2/26- 11:10
 * @Version: V1.0
 * @Modified By:
 **/
//当上一个任务未结束时下一个任务需进行等待
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job {

    public static final   String SCHEDULEJOBKEY="scheduleJob";
    //execute会根据cron的规则进行执行
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Config config = (Config) jobExecutionContext.getMergedJobDataMap().get(SCHEDULEJOBKEY);
        TaskUtils.invokMethod(config);
    }
}
