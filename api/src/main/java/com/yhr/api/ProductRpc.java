package com.yhr.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.yhr.api.domain.ProductRpcReq;
import com.yhr.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.api
 * @Author: yang
 * @CreateTime: 2019-03-27 10:14
 * @Description: 产品相关的rpc服务
 */

@JsonRpcService
/**
 * 注意不能以斜杠开始
 */
public interface ProductRpc {

    /**
     * 查询多个产品
     * @param req
     * @return
     *
     * 比如要频繁修改接口参数或者参数不确定的时候 就可以把它封装到一个类里面
     *
     */
    List<Product> query(ProductRpcReq req);

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    Product findOne(String id);



}
