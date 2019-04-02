package com.yhr.util;

import org.junit.Test;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.util
 * @Author: yang
 * @CreateTime: 2019-03-28 13:30
 * @Description: 测试加签 验签
 */
public class RSAUtilTest {

    static final String publikey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCz55WI+eRJSq1d91MoinIekNgH\n" +
            "yT6F7pOjQpaElYJqgBiaFp1tQCmbjhwY8PHjhsZBWJOhXcYIl0liX8xHPNWYkUWq\n" +
            "X0oRiJUisaPLMDysh48+DnbylzWILbd7VpauVH2I6+XqrRHZUGo/2d8NwPYjnw6v\n" +
            "OryeQYTicPXwlTv5yQIDAQAB";
    static final String privatekey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALPnlYj55ElKrV33\n" +
            "UyiKch6Q2AfJPoXuk6NCloSVgmqAGJoWnW1AKZuOHBjw8eOGxkFYk6FdxgiXSWJf\n" +
            "zEc81ZiRRapfShGIlSKxo8swPKyHjz4OdvKXNYgtt3tWlq5UfYjr5eqtEdlQaj/Z\n" +
            "3w3A9iOfDq86vJ5BhOJw9fCVO/nJAgMBAAECgYAwMglQYcmzjMr3Emv3v2clIx6M\n" +
            "r3ANh0WMBim2qSsABwMQPKC+BONgpeiHEf1rO87e8LDUGQAVixoAvbNHHlgGDWAQ\n" +
            "rtpIoz2SxO3IAmAqJ5TcCDCdQR9N47xkj2G6y0xWimMj8WfBrarJi154A0QLoq/w\n" +
            "qjxG5e4ti4+fuv0tFQJBANgmtElDBtxoAbMyoTJHtpafwdb0kmPfheJqSSPA1MxZ\n" +
            "DQkS1mE4Hh4tnpwHHpjTct9ukSPC8Apf8u0UdqRnX0sCQQDVEjdwjB21Murck6Yw\n" +
            "/PU+tfQ0LOUgH+JCSUxyo08kcyL5gLS5VGLUJyYaIl1zsZ2XyBRCcT5RMxY/Djxq\n" +
            "C1q7AkBHO8oicsJqFKSqx76z8UpNLW0WSBeObnWS/nAIJl560cYn/VtFQtc6HtKs\n" +
            "nPQKbXToCWovnOi6opBObXYEDEUtAkEAoIkjIDdRws5kSmEsnEha9y7cmdshnzym\n" +
            "ms7jPJRy8sGVHmusvt4nwDTm7lXqF1tBo7RqH013aHKXVlcBidyYNQJAdEpghR7M\n" +
            "/TYMnSG6pbBv+Jh20d/cBCnNx+ZvDGcAcTZvt4kKwAz7OMCkRCcMkE/k/si+aHcM\n" +
            "99YvltO7Rpz24w==";


    @Test
    public void signTest(){
       String text="{\"amount\":10,\"chanId\":\"111\",\"chanUserId\":\"123\",\"createAt\":\"2018-12-363 23:08:57\",\"memo\":\"aaa\",\"outerOrderId\":\"10001\",\"productId\":\"T004\"}";
       String sign=RSAUtil.sign(text,privatekey);
       System.out.println(sign);
       System.out.println(RSAUtil.verify(text,sign,publikey));
    }
}
