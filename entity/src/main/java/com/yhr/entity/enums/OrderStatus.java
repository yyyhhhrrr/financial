package com.yhr.entity.enums;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.entity.enums
 * @Author: yang
 * @CreateTime: 2019-03-26 09:19
 * @Description: 订单状态
 */
public enum OrderStatus {

    INIT("初始化"),
    PROCESS("处理中"),
    SUCCESS("成功"),
    FAIL("失败");



    private String desc;

    OrderStatus(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }}
