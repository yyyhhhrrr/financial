package com.yhr.saller.service;

import com.hazelcast.core.HazelcastInstance;
import com.yhr.api.ProductRpc;
import com.yhr.api.domain.ProductRpcReq;
import com.yhr.entity.Product;
import com.yhr.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.service
 * @Author: yang
 * @CreateTime: 2019-03-28 09:49
 * @Description: 产品缓存
 */

/**
 * 注意 所有的@Cache 相关注解 在当前类都不生效的
 */
@Component
@SuppressWarnings("all")
public class ProductCache {

    static final String CACHE_NAME = "yhr_product";
    private static Logger LOG= LoggerFactory.getLogger(ProductCache.class);

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    /**
     * 读取缓存
     * @param id
     */
     @Cacheable(cacheNames = CACHE_NAME)
     public Product readCache(String id){
         LOG.info("rpc查询单个产品,id={}",id);
         Product result=productRpc.findOne(id);
         LOG.info("rpc查询单个产品,结果={}",result);
         return result;

     }

    /**
     * 更新缓存
     * @param product
     * @return
     */
     @CachePut(cacheNames = CACHE_NAME,key = "#product.id")
     public Product putCache(Product product){
         return product;
     }

    /**
     * 清除缓存
     * @param id
     */
     @CacheEvict(cacheNames = CACHE_NAME)
     public void removeCache(String id){

     }

    public List<Product> readAllCache(){
         Map map=hazelcastInstance.getMap(CACHE_NAME);
         List<Product> products=null;
         if(map.size()>0){
             products=new ArrayList<>();
             products.addAll(map.values());
         }else {
             products=findAll();
         }
         return products;
    }


    public List<Product> findAll(){
        ProductRpcReq req=new ProductRpcReq();
        List<String> status=new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        Pageable pageable=new PageRequest(0,1000, Sort.Direction.DESC,"rewardRate"); //收益率倒序排序
        req.setStatusList(status);

        LOG.info("rpc查询全部产品,请求={}",req);
        List<Product> result=productRpc.query(req);
        LOG.info("rpc查询全部产品,结果={}",result);
        return result;
    }


}
