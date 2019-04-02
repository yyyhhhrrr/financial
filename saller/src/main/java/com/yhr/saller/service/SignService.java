package com.yhr.saller.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.service
 * @Author: yang
 * @CreateTime: 2019-03-28 15:00
 * @Description: 签名服务
 */

@Service
public class SignService {

    static Map<String,String> PUBLIC_KEYS=new HashMap<>();

    static{
        PUBLIC_KEYS.put("1000","MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCz55WI+eRJSq1d91MoinIekNgH\n" +
                "yT6F7pOjQpaElYJqgBiaFp1tQCmbjhwY8PHjhsZBWJOhXcYIl0liX8xHPNWYkUWq\n" +
                "X0oRiJUisaPLMDysh48+DnbylzWILbd7VpauVH2I6+XqrRHZUGo/2d8NwPYjnw6v\n" +
                "OryeQYTicPXwlTv5yQIDAQAB");
    }
    /**
     * 根据授权编号 获取公钥
     * @param authId
     * @return
     */
   public String getPublicKey(String authId){
         return PUBLIC_KEYS.get(authId);
   }

}
