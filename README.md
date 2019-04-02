# SpringBoot 理财管理平台系统

主要技术:
## 快速: 
1.框架:springboot   
2.ORM:springdata-jpa 
3.自动化测试:junit 
4.API文档生成: swagger
5.自动化配置: 利用 spring.factories
5.项目依赖管理: gradle
5.关系型数据库: mysql5.7

## 高效：
1.RPC:jsonrpc
2.缓存:hazelcast
3.读写分离


## 安全：
1.RSA签名
2.API网关:tyk



## 说明:
**1.数据库**
manager 管理端数据库
saller 销售端数据库主库
saller_backup 销售端数据库从库

**2.读写分离实现**
修改了部分源码 见saller目录下的org目录 
为了实现一个repository 操作两个数据源
通过自定义注解并修改源码实现

**3.JsonRpc**
使用jsonRpc 在不同服务之间相互调用方法

**4.自动化配置**
resources/META-INF 下创建spring.factories 文件 
配置自定义配置类 导入其他模块