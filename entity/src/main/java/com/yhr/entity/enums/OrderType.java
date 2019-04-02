package com.yhr.entity.enums;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.entity.enums
 * @Author: yang
 * @CreateTime: 2019-03-26 09:17
 * @Description: 订单类型
 */
public enum OrderType {

    APPLY("申购"),
    REDEEM("赎回");

    private String desc;

    OrderType(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

  }
