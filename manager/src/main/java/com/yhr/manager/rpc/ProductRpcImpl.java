package com.yhr.manager.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.yhr.api.ProductRpc;
import com.yhr.api.domain.ProductRpcReq;
import com.yhr.entity.Product;
import com.yhr.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.rpc
 * @Author: yang
 * @CreateTime: 2019-03-27 10:29
 * @Description: ${Description}
 */

@AutoJsonRpcServiceImpl
@Service
public class ProductRpcImpl implements ProductRpc {

    private static Logger LOG= LoggerFactory.getLogger(ProductRpcImpl.class);


    @Autowired
    private ProductService productService;

    @Override
    public List<Product> query(ProductRpcReq req) {
        LOG.info("查询多个产品,请求={}",req);
        Pageable pageable=new PageRequest(0,100, Sort.Direction.DESC,"rewardRate");
        Page<Product> result = productService.query(req.getIdList(), req.getMinRewardRate(), req.getMaxRewardRate(), req.getStatusList(), pageable);
        LOG.info("查询多个产品,结果={}",result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id) {
        LOG.info("查询产品详情,请求={}",id);
        Product result = productService.findOne(id);
        LOG.info("查询产品详情,结果={}",result);
        return result;
    }
}
