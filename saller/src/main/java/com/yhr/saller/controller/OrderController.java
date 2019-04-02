package com.yhr.saller.controller;

import com.yhr.entity.Order;
import com.yhr.entity.enums.OrderStatus;
import com.yhr.saller.Params.OrderParam;
import com.yhr.saller.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.controller
 * @Author: yang
 * @CreateTime: 2019-03-28 13:50
 * @Description: 订单相关
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    static final Logger LOG= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    /**
     * 下单
     * @param param
     * @return
     */
    @RequestMapping(value="/apply",method= RequestMethod.POST)
    public Order apply(@RequestHeader String authId, @RequestHeader String sign,@RequestBody OrderParam param){
        LOG.info("申购请求:{}",param);
        Order order=new Order();
        BeanUtils.copyProperties(param,order); //有很多相同属性 就可以转化
        order=orderService.apply(order);
        LOG.info("申购结果:{}",order);
        return  order;
    }
}
