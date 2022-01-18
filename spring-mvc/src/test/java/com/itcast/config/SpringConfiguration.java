package com.itcast.config;

import org.springframework.context.annotation.*;

//标志该类是Spring的核心配置类
@Configuration
//<context:component-scan base-package="com.itcast"/>
@ComponentScan("com.itcast")
//<import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
