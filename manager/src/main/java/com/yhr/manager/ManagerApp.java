package com.yhr.manager;

import com.yhr.swagger.EnableMySwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager
 * @Author: yang
 * @CreateTime: 2019-03-26 09:32
 * @Description: 管理端启动类
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.yhr.entity"})
@EnableMySwagger
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class);
    }
}
