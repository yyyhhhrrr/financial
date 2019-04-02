package com.yhr.quartz.configuration;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.quartz.configuration
 * @Author: yang
 * @CreateTime: 2019-03-29 16:30
 * @Description: 容器启动时启动  这里没使用
 */


public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyQuartzScheduler quartzScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    System.out.println("scheduler 已注入");
    }



    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }
}
