package com.yhr.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.entity
 * @Author: yang
 * @CreateTime: 2019-03-25 17:51
 * @Description: 订单
 */

@Entity
public class VerificationOrder implements Serializable {
     @Id
     private String orderId;//订单编号
     private String chanId; //渠道编号
     private String productId; //产品编号
     private String chanUserId; //渠道用户产品编号
     private String orderType; //类型
     private String outerOrderId;//外部订单编号
     private BigDecimal amount;//金额

    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
     private Date createAt;//创建时间


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChanId() {
        return chanId;
    }

    public void setChanId(String chanId) {
        this.chanId = chanId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getChanUserId() {
        return chanUserId;
    }

    public void setChanUserId(String chanUserId) {
        this.chanUserId = chanUserId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


    public String getOuterOrderId() {
        return outerOrderId;
    }

    public void setOuterOrderId(String outerOrderId) {
        this.outerOrderId = outerOrderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "VerificationOrder{" +
                "orderId='" + orderId + '\'' +
                ", chanId='" + chanId + '\'' +
                ", productId='" + productId + '\'' +
                ", chanUserId='" + chanUserId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", outerOrderId='" + outerOrderId + '\'' +
                ", amount=" + amount +
                ", createAt=" + createAt +
                '}';
    }
}
