package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.itcast.service.impl.UserServiceImpl">

//    </bean>
//@Component("userService")
@Service("userService")
@Scope("prototype")
//@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //  <property name="userDao" ref="userDao"></property>
//    @Autowired  // 按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao")  // 按照ID值从容器中进行匹配  注意此处要结合@Autowired一起使用
    @Resource(name = "userDao") //相当于@Autowired + @Qualifier
    private UserDao userDao;
    //使用xml方式这段要写， 通过注解可以不写
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Service对象的销毁方法");
    }
}
