package com.yhr.saller.controller;

import com.yhr.entity.Product;
import com.yhr.saller.service.ProductRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.controller
 * @Author: yang
 * @CreateTime: 2019-03-28 09:25
 * @Description: ${Description}
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRpcService productRpcService;


    @RequestMapping("/{id}")
    public Product findOne(@PathVariable String id){
        return productRpcService.findOne(id);
    }



}
