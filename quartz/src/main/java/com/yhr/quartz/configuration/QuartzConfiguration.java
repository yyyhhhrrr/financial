package com.yhr.quartz.configuration;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.quartz.configuration
 * @Author: yang
 * @CreateTime: 2019-04-01 10:22
 * @Description: ${Description}
 */

@Configuration
public class QuartzConfiguration {

    @Autowired
    private MyQuartzScheduler myquartzScheduler;

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }
}
