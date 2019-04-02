package com.yhr.manager.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.error
 * @Author: yang
 * @CreateTime: 2019-03-26 13:27
 * @Description: 统一错误处理
 */
//
@ControllerAdvice("com.yhr.manager.controller")
public class ErrorControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e){
        Map<String, Object> attrs = new HashMap<>();
        String errorCode = (String) attrs.get("message");
        ErrorEnum errorEnum=ErrorEnum.getByCode(errorCode);
        attrs.put("message",errorEnum.getMessage());
        attrs.put("code",errorEnum.getCode());
        attrs.put("canRetry",errorEnum.isCanRestry());
        attrs.put("type","advice"); //这里加入这个只是测试一下 是否使用controller advice 来控制异常的
        return new ResponseEntity(attrs, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
