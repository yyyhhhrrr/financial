package com.yhr.saller.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.task
 * @Author: yang
 * @CreateTime: 2019-03-29 16:42
 * @Description: ${Description}
 */
public class VerifyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time is :"+simpleDateFormat.format(date));
        System.out.println("hello myjob");
    }
}
