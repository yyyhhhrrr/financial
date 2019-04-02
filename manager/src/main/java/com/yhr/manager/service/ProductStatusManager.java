package com.yhr.manager.service;

import com.yhr.api.events.ProductStatusEvent;
import com.yhr.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.service
 * @Author: yang
 * @CreateTime: 2019-03-28 10:46
 * @Description: 管理产品状态
 */
@Component
public class ProductStatusManager {

    static final String MQ_DESTINATION = "VirtualTopic.PRODUCT_STATUS";
    static Logger LOG= LoggerFactory.getLogger(ProductStatusManager.class);


    @Autowired
    private JmsTemplate jmsTemplate;


    public void changeStatus(String id, ProductStatus status){
        ProductStatusEvent event=new ProductStatusEvent(id,status);
        LOG.info("send message:{}",event);
        jmsTemplate.convertAndSend(MQ_DESTINATION,event);
    }

//    @PostConstruct
//    public void init(){
//        changeStatus("T004",ProductStatus.FINISHED);
//    }

}
