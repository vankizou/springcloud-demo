```
这是一个springCloud基础服务的测试服务
只是简单的搭建能让其跑起来

本Demo参照：https://www.fangzhipeng.com/spring-cloud.html
```

| Cloud代号 | Boot版本(train) | Boot版本(tested) | lifecycle |
| :-: | :-: | :-: | :-: |
| Angle | 1.2.x | incompatible with 1.3 | EOL in July 2017 |
| Brixton | 1.3.x | 1.4.x | 2017-07卒 |
| Camden | 1.4.x | 1.5.x | - |
| Dalston | 1.5.x | not expected 2.x | - |
| Edgware | 1.5.x | not expected 2.x | - |
| Finchley | 2.x | not expected 1.5.x | - |

```
本DEMO搭建是基于F版的

D版本和E版本的区别
二者均基于SpringBoot的1.5.x版本。但支持其他组件的版本不同，如以 Dalston.SR4 和 Edgware.RELEASE 来对比：

spring-cloud-config 分别对应 1.3.3和 1.4.0; 
spring-cloud-netflix 分别对应 1.3.5和 1.4.0; 
spring-cloud-consul 分别对应 1.2.1和 1.3.0; 
spring-cloud-gateway 前者不支持，后者 1.0.0。

每个小版本的不同，会有细微差别。

F版本
F版本是个绝对的大版本，几乎所有组件，全部同步变更版本号为2.x。

小版本
Spring Cloud 小版本分为:

SNAPSHOT： 快照版本，随时可能修改
M： MileStone，M1表示第1个里程碑版本，一般同时标注PRE，表示预览版版。
SR： Service Release，SR1表示第1个正式版本，一般同时标注GA：(GenerallyAvailable),表示稳定版本。
```

##### 服务介绍

- client：业务客户端
- eureka：服务注册中心
- ribbon：负载均衡 | hystrix：pom文件引入，断路器（当client全挂时直接返回预先准备的错误业务）
- feign：负载均衡 + 断路器 | 内置 ribbon + hystrix
- zuul：路由 + 过滤器


##### 测试eureka
1. 启动 eureka 

```
成功后访问：http://localhost:7001(eureka配置端口)
```

##### 测试client
1. 启动 eureka
2. 启动 client

```
成功后访问eureka：http://localhost:7001
    7001: eureka配置端口 
    可在注册实例查看到 SPRINGCLIENT-CLIENT
    
调用client接口：http://localhost:7002/hi?name=vanki
    7002: client配置端口
```

##### 测试ribbon
1. 启动 eureka
2. 启动 client
3. 将client端口换一个再启动 client，这样就有2个client
4. 启动 ribbon

```
成功后访问ribbon：http://localhost:7100/hi?name=vanki
    7100: ribbon配置端口
    因为启动两个client，所以循环刷新以上接口响应数据是不一致的
```

5. 测试hystrix：将两个client全部关闭

```
此时再访问ribbon接口，则会执行断路代码
```

##### 测试feign

```
与 测试ribbon 是一致的，只是访问端口换成feign配置端口
```

##### 测试zuul
1. 启动 eureka
2. 启动 client
3. 启动 feign
4. 启动 zuul

```
成功后访问zuul：
    http://localhost:7300/api-b/hi?token=xx&name=vanki
        7300：zuul配置端口
    http://localhost:7300/api-b/hi?name=vanki
        未传token参数，会直接过滤    
```