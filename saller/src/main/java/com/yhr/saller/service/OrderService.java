package com.yhr.saller.service;

import com.yhr.entity.Order;
import com.yhr.entity.Product;
import com.yhr.entity.enums.OrderStatus;
import com.yhr.entity.enums.OrderType;
import com.yhr.saller.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.UUID;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.service
 * @Author: yang
 * @CreateTime: 2019-03-28 13:38
 * @Description: 订单服务
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRpcService productRpcService;


    /**
     * 申购订单
     * @param order
     * @return
     */
    public Order apply(Order order){
        //数据校验
        checkOrder(order);
        //完善订单数据
        completeOrder(order);
        //存入数据库
        orderRepository.save(order);
        return order;
    }

    /**
     * 完善订单数据
     * @param order
     */
    private void completeOrder(Order order) {
         order.setOrderId(UUID.randomUUID().toString().replaceAll("-",""));
         order.setOrderType(OrderType.APPLY.name());
         order.setOrderStatus(OrderStatus.SUCCESS.name());
         order.setUpdateAt(new Date());
    }


    /**
     * 校验数据
     * @param order
     */
    private void checkOrder(Order order) {
        //必填字段
        Assert.notNull(order.getOuterOrderId(),"需要外部订单号");
        Assert.notNull(order.getChanId(),"需要渠道编号");
        Assert.notNull(order.getChanUserId(),"需要用户编号");
        Assert.notNull(order.getProductId(),"需要产品编号");
        Assert.notNull(order.getAmount(),"需要购买金额");
        Assert.notNull(order.getCreateAt(),"需要订单时间");

        //产品是否存在及金额是否符合要求
        Product product=productRpcService.findOne(order.getProductId());
        Assert.notNull(product,"产品不存在");
        //金额要满足 如果有起投金额时，要大于等于起投金额，如果有投资步长时，超过起投金额的部分要是投资步长的整数倍
//        if(product.getThresholdAmount()!=null){
//            Assert.isTrue(order.getAmount().compareTo(product.getThresholdAmount())>-1,"如果有起投金额时，购买金额要大于等于起投金额");
//            if(product.getStepAmount()!=null){
//                BigDecimal thresholdAmount=product.getThresholdAmount();//起投金额
//                BigDecimal orderAmount=order.getAmount(); //购买金额
//                if(product.getStepAmount()!=null){
//                   Assert.isTrue(orderAmount.subtract(thresholdAmount).divideToIntegralValue(product.getStepAmount()).compareTo(BigDecimal.valueOf(0))==0,"如果有投资步长时，超过起投金额的部分要是投资步长的整数倍");
//                }
//            }
//        }

    }

}
