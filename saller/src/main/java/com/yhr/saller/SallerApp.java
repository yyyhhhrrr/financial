package com.yhr.saller;

import com.yhr.saller.sign.SignAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller
 * @Author: yang
 * @CreateTime: 2019-03-27 10:51
 * @Description: 销售端启动类
 */

@SpringBootApplication
@EnableCaching
@EntityScan("com.yhr.entity")
//@EnableScheduling
public class SallerApp {

    public static void main(String[] args) {
        SpringApplication.run(SallerApp.class);
    }
}
