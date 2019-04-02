package com.yhr.quartz.configuration;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.quartz.configuration
 * @Author: yang
 * @CreateTime: 2019-03-29 16:33
 * @Description: ${Description}
 */

@Configuration
@SuppressWarnings("all")
public class MyQuartzScheduler {


    @Autowired
    private Scheduler scheduler;


    /**
     * 开始执行任务
     *
     */
    public void startJob(Class <? extends Job> jobClass) throws SchedulerException{
        startMyJob(scheduler,jobClass);
        scheduler.start();
    }

    private void startMyJob(Scheduler scheduler,Class <? extends Job> jobClass ) throws SchedulerException {

        JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity("job1","group1").build();

        CronTrigger cronTrigger=TriggerBuilder.newTrigger().withIdentity("trigger1","group2")
                .withSchedule(
                        CronScheduleBuilder
                                .cronSchedule("* * * * * ? *")).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

}
