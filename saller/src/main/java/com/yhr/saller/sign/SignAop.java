package com.yhr.saller.sign;

import com.yhr.saller.service.SignService;
import com.yhr.util.RSAUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.sign
 * @Author: yang
 * @CreateTime: 2019-03-28 14:56
 * @Description: 验签AOP
 */
@Component
@Aspect
public class SignAop {

    @Autowired
    private SignService signService;

    @Before(value = "execution(* com.yhr.saller.controller.*.*(..)) && args(authId,sign,text,..)")
    public void verify(String authId,String sign,SignText text){
        String publicKey = signService.getPublicKey(authId);
        Assert.isTrue(RSAUtil.verify(text.toText(),sign,publicKey),"验签失败");
    }
}

