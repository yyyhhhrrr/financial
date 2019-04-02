package org.springframework.data.repository.config;

import java.lang.annotation.*;

/**
 * @BelongsProject: financial
 * @BelongsPackage: org.springframework.data.repository.config
 * @Author: yang
 * @CreateTime: 2019-04-01 15:10
 * @Description:  自
 *
 * 读写分离实现: 第二种方式
 * 定义注解 实现一个repository 操作两个数据源 (从@ EnableJpaRepositories 拷贝过来的元注解)
 *
 *
 * 修改思路
 * 1.找到@ EnableJpaRepositories 里面有一个@Import(JpaRepositoriesRegistrar.class)
 * 2.找到JpaRepositoriesRegistrar.class 父类 RepositoryBeanDefinitionRegistrarSupport
 * 3.RepositoryBeanDefinitionRegistrarSupport里有个方法registerBeanDefinitions 返回delegate.registerRepositoriesIn(registry, extension);
 * 4.找到registerRepositoriesIn(registry, extension)方法点进去就是我们要修改源码的类 RepositoryConfigurationDelegate
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RepositoryBeanNamePrefix {

    String value();
}
