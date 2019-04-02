package com.yhr.saller.controller;

import com.yhr.saller.service.VerifyService;
import com.yhr.saller.task.VerifyJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.controller
 * @Author: yang
 * @CreateTime: 2019-03-29 16:57
 * @Description: ${Description}
 */

@RestController
@RequestMapping("/quartz")
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @RequestMapping("/test")
    public void quartzTest() throws SchedulerException {
        verifyService.quartzTest(VerifyJob.class);
    }
}
