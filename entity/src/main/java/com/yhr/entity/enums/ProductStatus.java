package com.yhr.entity.enums;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.entity.enums
 * @Author: yang
 * @CreateTime: 2019-03-25 17:55
 * @Description: 产品状态
 */
public enum ProductStatus {

    AUDITING("审核中"),

    IN_SELL("销售中"),

    LOCKED("暂停销售"),

    FINISHED("已结束");



    private String desc;

    ProductStatus(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

   }
