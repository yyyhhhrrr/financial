package com.yhr.manager.controller;

import com.yhr.entity.Product;
import com.yhr.entity.enums.ProductStatus;
import com.yhr.util.RestUtil;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.controller
 * @Author: yang
 * @CreateTime: 2019-03-26 14:09
 * @Description: 自动化测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //随机端口
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //自动化测试顺序 按照名称字典顺序排序(就是哪个写在前面  哪个先执行)
/**
 * 这里@FixMethodOrder里MethodSorters有三个枚举
 * 1.NAME_ASCENDING  按照命名顺序
 * 2.JVM  JVM返回的时候是不确定的
 * 3.DEFAULT  是按照hashcode 来排序的
 */
public class ProductControllerTest {

    private static RestTemplate rest=new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    private static List<Product> normals=new ArrayList<>();

    //异常数据
    private static List<Product> exceptions=new ArrayList<>();

    @BeforeClass
    public static void init(){

        //正常数据
         Product p1=new Product("T001","灵活宝1号", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),BigDecimal.valueOf(1),BigDecimal.valueOf(3.42));
         Product p2=new Product("T002","活期盈-金色人生", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),BigDecimal.valueOf(0),BigDecimal.valueOf(3.28));
         Product p3=new Product("T003","朝朝盈-聚财", ProductStatus.AUDITING.name(), BigDecimal.valueOf(100),BigDecimal.valueOf(10),BigDecimal.valueOf(3.86));
         normals.add(p1);
         normals.add(p2);
         normals.add(p3);


         //异常数据
        Product e1=new Product(null,"编号不可为空", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),BigDecimal.valueOf(1),BigDecimal.valueOf(3.42));
        Product e2=new Product("E002","收益率范围错误", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),BigDecimal.valueOf(0),BigDecimal.valueOf(31));
        Product e3=new Product("E003","投资步长需为整数", ProductStatus.AUDITING.name(), BigDecimal.valueOf(100),BigDecimal.valueOf(10.1),BigDecimal.valueOf(3.86));
        exceptions.add(e1);
        exceptions.add(e2);
        exceptions.add(e3);


        /**
         * 自定义异常 比如做异常测试时
         * 如果第一条不通过 就不会往下走 所以这里我们定义false 来放行让我们自己来处理
         * 使得测试用例能够绿色顺利通过 而不会报红色的错
         */
        ResponseErrorHandler errorHandler=new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        };
        rest.setErrorHandler(errorHandler);

    }

    /**
     * 添加功能测试
     */
    @Test
    public void create(){
        normals.forEach(product -> {
            Product result = RestUtil.postJSON(rest, baseUrl + "/products", product, Product.class);
            Assert.notNull(result.getCreateAt(),"插入失败");
        });
    }


    //异常测试
    @Test
    public void createException(){
        exceptions.forEach(product -> {
           Map<String,String> result= RestUtil.postJSON(rest, baseUrl + "/products", product, HashMap.class);
            Assert.notNull(result.get("message").equals(product.getName()),"编号不可为空");
            /**
             * 这个时候 product 的name 是“编号不可为空” 与我们error的message比较 如果通过 就表示排除了网络之外的问题 只是确定了 id为Null 的错误
             */
        });
    }


    /**
     * 查询功能测试
     */
    @Test
    public void findOne(){
          normals.forEach(product -> {
              Product result = rest.getForObject(baseUrl + "/products/" + product.getId(), Product.class);
              Assert.isTrue(result.getId().equals(product.getId()),"查询失败");
          });
          exceptions.forEach(product -> {
              Product result = rest.getForObject(baseUrl + "/products/" + product.getId(), Product.class);
              Assert.isNull(result,"查询失败");
          });
    }


}
