package com.yhr.saller.service;

import com.yhr.api.ProductRpc;
import com.yhr.api.domain.ProductRpcReq;
import com.yhr.api.events.ProductStatusEvent;
import com.yhr.entity.Product;
import com.yhr.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.service
 * @Author: yang
 * @CreateTime: 2019-03-27 10:52
 * @Description: 产品服务
 */

@Service
@SuppressWarnings("all")
public class ProductRpcService implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOG= LoggerFactory.getLogger(ProductRpcService.class);

    static final String MQ_DESTINATION = "Consumer.cache.VirtualTopic.PRODUCT_STATUS";

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private ProductCache productCache;

    /**
     * 查询全部产品
     * @return
     */
    public List<Product> findAll(){
        return productCache.readAllCache();
    }

    /**
     * 查询单个产品
     * @param id
     * @return
     */

    /** spring 缓存结合hazelcast
     * cacheName 里的值是 hazelcast里的map名称 默认key 为id
     */
    public Product findOne(String id){
        Product product=productCache.readCache(id);
        if(product==null){ //如果查询一个id 但是id 对应没有实体 所以它会存一个null 当我们id有数据的时候 所以我们需要判断
            productCache.readCache(id);
        }
       return product;
    }


    /**
     * 在第一次运行的时候 监听ceontext 启动
     * 所以要实现 ApplicationListener<ContextRefreshedEvent>
     * 使得第一次启动容器的时候将所有的数据查询出来放入缓存
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Product> products=findAll();
        products.forEach(product -> {
            productCache.putCache(product);
        });
    }


    @JmsListener(destination = MQ_DESTINATION)
    void updateCache(ProductStatusEvent event){
        LOG.info("receive event:{}",event);
         productCache.removeCache(event.getId());
         if(ProductStatus.IN_SELL.equals(event.getStatus())){
             productCache.readCache(event.getId());//重新从管理端读取数据
         }

    }
}
