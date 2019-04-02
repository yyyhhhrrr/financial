package com.yhr.manager.repositories;

import com.yhr.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.repositories
 * @Author: yang
 * @CreateTime: 2019-03-26 09:37
 * @Description: 产品管理
 */

/**
 * JpaRepository<Product,String> String 指的是 product 的id 为string
 * JpaSpecificationExecutor<Product>  是复杂条件查询要继承的
 */
public interface ProductRepository  extends CrudRepository<Product,String>,JpaRepository<Product,String>, JpaSpecificationExecutor<Product> {
}
