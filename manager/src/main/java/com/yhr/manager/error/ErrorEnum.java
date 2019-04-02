package com.yhr.manager.error;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.error
 * @Author: yang
 * @CreateTime: 2019-03-26 13:14
 * @Description: 错误种类
 */
public enum ErrorEnum {

    ID_NOT_NULL("F001","编号不可为空",false),
    //,.,,,
    UNKNOWN("999","未知异常",false);


    private String code;
    private String message;
    private boolean canRestry;

    ErrorEnum(String code,String message,boolean canRestry){
        this.code=code;
        this.message=message;
        this.canRestry=canRestry;
    }

    public static ErrorEnum getByCode(String code){
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if(errorEnum.code.equals(code)){
                return errorEnum;
            }
        }
        return UNKNOWN;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanRestry() {
        return canRestry;
    }}
