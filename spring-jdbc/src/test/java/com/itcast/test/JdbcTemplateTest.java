package com.itcast.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    //测试jdbcTemplate开发步骤
    @Test
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/learn");
        dataSource.setUser("root");
        dataSource.setPassword("sf200672");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源对象， 知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);

        //执行操作
        int row = jdbcTemplate.update("insert into account values (?,?,?)", 3,"tom", 5000);
        System.out.println(row);
    }

    //测试Spring产生jdbcTemplate模板对象开发步骤
    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        //执行操作
        int row = jdbcTemplate.update("insert into account values (?,?,?)", 4,"王五", 5000);
        System.out.println(row);

    }
}
