### 目的

这个项目的目的是实现一个tomcat中session的持久化插件，项目为个人练手项目。

### 问题

#### 1.对于同一服务器上的不同的web项目，如何实现自定义的session持久化方案。

​	Tomcat是有session持久化管理的实现类，有File和JDBC两种，分别对应文件和数据库两种持久化方案。

​	Tomcat可以为目标web应用配置自己的Manager。

#### 2.如何映射对象与数据库间的关系

#### 3.如何设计配置

