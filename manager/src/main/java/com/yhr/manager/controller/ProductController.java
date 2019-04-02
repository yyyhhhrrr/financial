package com.yhr.manager.controller;

import com.yhr.entity.Product;
import com.yhr.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.PAEncTSEnc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.controller
 * @Author: yang
 * @CreateTime: 2019-03-26 09:59
 * @Description: ${Description}
 */

/**
 * 日志级别 一般调试的时候 service 设置为DEBUG
 *  controller 设置为info
 *  当正式上线的时候 就把service的去掉 只保留controller的日志就可以了
 */

@RestController
@RequestMapping("/products")
public class ProductController {


    private static Logger LOG= LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    @ApiOperation(value="创建产品",notes="根据业务规则创建相应的产品")
    @RequestMapping(value="",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){

        LOG.info("创建产品,参数:{}",product);
        Product result = productService.addProduct(product);
        LOG.info("创建产品,结果:{}",result);
        return result;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id){
        LOG.info("查询单个产品,id={}",id);
        Product result=productService.findOne(id);
        LOG.info("查询单个产品,结果={}",result);
        return result;
    }






    @RequestMapping(value="",method = RequestMethod.GET)
    public Page<Product> query(String ids,BigDecimal minRewardRate,BigDecimal maxRewardRate,String status,
                               @RequestParam(defaultValue = "0") int pageNum,@RequestParam(defaultValue = "10") int  pageSize){
        LOG.info("查询产品,ids={},minRewardRate={},maxRewardRate={},status={},pageNum={},pageSize={}",ids,minRewardRate,maxRewardRate,status,pageNum,pageSize);
        List<String> idList = null,statusList = null;
        if(!StringUtils.isEmpty(ids)){
            idList = Arrays.asList(ids.split(","));//ids是字符串 ids.split(",")分割后是数组  最后调用Arrays.asList 转换为List
        }
        if(!StringUtils.isEmpty(status)){
            statusList = Arrays.asList(status.split(","));
        }

        Pageable pageable=new PageRequest(pageNum,pageSize);
        Page<Product> page=productService.query(idList,minRewardRate,maxRewardRate,statusList,pageable);
        LOG.info("查询产品,ids={},minRewardRate={},maxRewardRate={},status={},pageNum={},pageSize={}",idList,minRewardRate,maxRewardRate,statusList,pageNum,pageSize);
        LOG.info("查询产品,结果={}",page);
        return page;
    }



}
