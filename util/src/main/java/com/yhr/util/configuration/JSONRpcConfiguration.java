package com.yhr.util.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.util.configuration
 * @Author: yang
 * @CreateTime: 2019-03-27 15:02
 * @Description: jsonrpc 自动化配置
 */

@Configuration
public class JSONRpcConfiguration {

    private static Logger LOG = LoggerFactory.getLogger(JSONRpcConfiguration.class);

    @Bean
    public AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter(){
        return  new AutoJsonRpcServiceImplExporter();

    }


    @Bean
    @ConditionalOnProperty(value = {"rpc.client.url","rpc.client.basePackage"})
    /**
     * 当配置文件包含这两个属性时 才导出为客户端为客户端注入下面的bean  否则不需要
     */
    public AutoJsonRpcClientProxyCreator autoJsonRpcClientProxyCreator(@Value("${rpc.client.url}") String url,
                                                                       @Value("${rpc.client.basePackage}") String basePackage){
        AutoJsonRpcClientProxyCreator creator=new AutoJsonRpcClientProxyCreator();
        try {
            creator.setBaseUrl(new URL(url));
        } catch (MalformedURLException e) {
            LOG.error("创建rpc服务地址错误",e);
            e.printStackTrace();
        }
        creator.setScanPackage(basePackage);
        return  creator;
    }
}
