package com.yhr.saller.repositories;

import com.yhr.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.repositories
 * @Author: yang
 * @CreateTime: 2019-03-26 09:37
 * @Description: 订单管理
 */


public interface OrderRepository extends JpaRepository<Order,String>, JpaSpecificationExecutor<Order> {
}
