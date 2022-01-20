



# **Spring的优势：**

​	*1.方便解耦，简化开发*  通过Spring提供的IOC容器，将对象间的依赖关系交由Spring进行控制。

​	*2.AOP编程的支持*   面向切面编程

​	*3. 声明式事务的支持*， 通过声明方式灵活的进行事务管理， 提高开发效率和质量

​	*4.方便程序的测试*

​	*5.方便集成各种优秀框架*  对Struts，Hibernate，Hessian,Quartz等的支持

​	*6.降低JavaEE API的使用难度*  对JavaEE API进行了封装

​	*7.Java源码是经典学习范例*   是Java技术的最佳实践的范例



# **Spring的体系结构**

​	 ![image-20220109115939246](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109115939246.png)

​	

# **Spring开发步骤**

![image-20220109120607468](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109120607468.png)

​	1.导入Spring开发的基本包坐标

​	2.编写Dao接口和实现类

​	3.创建Spring核心配置文件

​	4.在Spring配置文件中配置*DapImpl

​	5.使用Spring的API获得Bean实例



# **Spring配置**

​	![image-20220109141002761](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109141002761.png)

![image-20220109142100667](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109142100667.png)



## Bean实例化三种方式

 1. 无参**构造**方法实例化
    ![image-20220109144050094](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109144050094.png)

    ![image-20220109144007847](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109144007847.png)

 2. 工厂**静态**方法实例化
    ![image-20220109143905476](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109143905476.png)
    ![image-20220109143941352](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109143941352.png)

 3. 工厂**实例**方法实例化
    ![image-20220109143800555](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109143800555.png)
    ![image-20220109143821108](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109143821108.png)



## Bean的依赖注入分析

![image-20220109183158060](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109183158060.png)



## Bean的依赖注入概念

![image-20220109183224743](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109183224743.png)

## Bean的依赖注入方式

​		**构造方法**

![image-20220109184801064](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109184801064.png)

![image-20220109184812876](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109184812876.png)

​		**set方法**

![image-20220109184255890](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109184255890.png)

2）![image-20220109184332632](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109184332632.png)

![image-20220109184406337](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109184406337.png)





## Bean的依赖注入的数据类型

普通数据类型

引用数据类型

集合数据类型



# Spring配置文件

![image-20220109191639235](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109191639235.png)



![image-20220109191849780](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220109191849780.png)



# Spring相关API

![image-20220110080841969](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220110080841969.png)

## ApplicationContext是实现类

1.ClassPathXMLApplicationContext  
	它是从类的根路径下加载配置文件  推荐使用

2.FileSystemXMLApplicationContext

从磁盘路径加载配置文件，配置文件可以在磁盘的任意位置  不推荐

3.AnnotationConfigApplicationContext

使用注解配置容器对象时，需要使用此类来创建Spring容器，它用来读取注解



## getBean的使用方法

![image-20220110081439910](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220110081439910.png)





# Spring配置数据源

**数据源（连接池）的作用**

​	是提高程序性能出现的

​	事先实例化数据源，初始化布局连接资源

​	使用连接资源时从数据源中获取

​	使用完毕后连接资源归还给数据源

**常见的数据源 DBCP C3P0 Druid** 



**数据源的开发步骤**

1.导入数据源的坐标和数据库驱动坐标

2.创建数据源对象

3.设置数据源的基本连接数据

4.使用数据源获取连接资源和归还连接资源

![image-20220111214846547](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220111214846547.png)



# Spring注解开发

![image-20220114081726442](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220114081726442.png)

![image-20220114082211137](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220114082211137.png)

# Spring集成Junit步骤



![image-20220114082553205](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220114082553205.png)

# Spring集成web环境

![image-20220114081444527](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220114081444527.png)

![image-20220117085145548](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220117085145548.png)

![image-20220117085814112](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220117085814112.png)



# SpringMVC

![image-20220118082951833](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118082951833.png)

![image-20220118084535643](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118084535643.png)

![image-20220118084713100](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118084713100.png)

![image-20220118204255410](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118204255410.png)

![image-20220118204412391](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118204412391.png)

![image-20220118213726167](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220118213726167.png)

**解决中文乱码问题**

```xml
<!--配置全局过滤的filter-->
<filter>
  <filter-name>CharacterEncodingFilter</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>CharacterEncodingFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
```

![image-20220119210536137](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220119210536137.png)

![image-20220119210720889](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220119210720889.png)

# SpringMVC文件上传

![image-20220120080750975](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220120080750975.png)

![image-20220120081020972](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220120081020972.png)

![image-20220120081156264](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220120081156264.png)

![image-20220120081204341](C:\Users\Peisf\AppData\Roaming\Typora\typora-user-images\image-20220120081204341.png)
