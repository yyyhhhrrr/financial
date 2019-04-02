package com.yhr.saller;

import com.yhr.entity.Product;
import com.yhr.entity.enums.ProductStatus;
import com.yhr.saller.repositories.OrderRepository;
import com.yhr.saller.repositoriesbackup.BackupOrderRepository;
import com.yhr.saller.repositoriesbackup.VerifyRepository;
import com.yhr.saller.service.VerifyService;
import com.yhr.util.RestUtil;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Table;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.controller
 * @Author: yang
 * @CreateTime: 2019-03-26 14:09
 * @Description: 自动化测试
 */

@RunWith(SpringRunner.class)
@SuppressWarnings("all")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //随机端口
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //自动化测试顺序 按照名称字典顺序排序(就是哪个写在前面  哪个先执行)
public class VerifyTest {

    @Autowired
    private VerifyService verifyService;

    @Autowired
    private OrderRepository orderRepository;




//    /** 读写分离实现: 第一种方式
//     *  继承OrderRepoistory 不同包 多数据源原理
//     */
//    @Autowired
//    @Qualifier("backupOrderRepository")
//    private OrderRepository backupOrderRepository;



   /** 读写分离实现: 第二种方式
    *  同一个repository 拦截bean的注册过程 两个同类型 但名字不同的bean
    *定义注解 实现一个repository 操作两个数据源 (从@ EnableJpaRepositories 拷贝过来的元注解)
    */
    @Autowired
    @Qualifier("readorderRepository")
    private OrderRepository readorderRepository;



    @Test
    public void makeVerificationTest(){
        Date day=new GregorianCalendar(2018,11,30).getTime();
        File file=verifyService.makeVerificationFile("111",day);
        System.out.println(file.getAbsoluteFile());
    }

    @Test
    public void saveVerificationOrders(){
        Date day=new GregorianCalendar(2018,11,30).getTime();
        verifyService.saveChanOrders("111",day);
    }

    @Test
    public void verifyTest(){
        Date day=new GregorianCalendar(2018,11,30).getTime();
        System.out.println(String.join(";", verifyService.verifyOrder("111",day)));

    }

    @Test
    public void test(){
        System.out.println(readorderRepository.findAll());


    }
}
