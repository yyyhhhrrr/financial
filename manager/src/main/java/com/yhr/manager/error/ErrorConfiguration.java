package com.yhr.manager.error;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.manager.error
 * @Author: yang
 * @CreateTime: 2019-03-26 13:08
 * @Description: 错误处理相关配置
 */

/**
 * 从 ErrorMvcAutoConfiguration 里复制的方法 再进行改造
 */
@Configuration
public class ErrorConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = ErrorController.class, search = SearchStrategy.CURRENT)
    public MyErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        return new MyErrorController(errorAttributes, serverProperties.getError(),
                errorViewResolversProvider.getIfAvailable());
    }

}
