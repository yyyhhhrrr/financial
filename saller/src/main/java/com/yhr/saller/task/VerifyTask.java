package com.yhr.saller.task;

import com.yhr.saller.enums.ChanEnum;
import com.yhr.saller.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.task
 * @Author: yang
 * @CreateTime: 2019-03-29 11:02
 * @Description: 定时对账任务
 */

@Component
public class VerifyTask {

    @Autowired
    private VerifyService verifyService;

    /**
     * @Scheduled 是spring自带的定时任务注解
     */
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void hello(){
//        System.out.println("hello");
//    }



//    @Scheduled(cron = "0 0 1,3,5 * * ? ")
    public void makeVerificationFile(){
        Date yesterday=new Date(System.currentTimeMillis()-24*60*60*1000);

        for (ChanEnum chanEnum : ChanEnum.values()) {
            verifyService.makeVerificationFile(chanEnum.getChanId(),yesterday);
        }

    }


//    @Scheduled(cron = "0 0 2,4,6 * * ? ")
    public void verify(){
        Date yesterday=new Date(System.currentTimeMillis()-24*60*60*1000);

        for (ChanEnum chanEnum : ChanEnum.values()) {
            verifyService.verifyOrder(chanEnum.getChanId(),yesterday);
        }

    }

}
