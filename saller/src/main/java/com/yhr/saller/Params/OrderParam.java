package com.yhr.saller.Params;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yhr.saller.sign.SignText;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.Params
 * @Author: yang
 * @CreateTime: 2019-03-28 14:49
 * @Description: 下单请求参数
 */
public class OrderParam implements SignText {
    private String chanId; //渠道编号
    private String productId; //产品编号
    private String chanUserId; //渠道用户产品编号
    private String outerOrderId;//外部订单编号
    private BigDecimal amount;//金额
    private String memo;//备注
    @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private Date createAt;//创建时间

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
