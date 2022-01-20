package com.itcast.test;

import com.itcast.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set balance = ? where id = ?", 1000, 4);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where id = ? ",  4);
    }

    @Test
    public void testQueryAll(){
        List<Account> query = jdbcTemplate.query("select * from account as a", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 3);
        System.out.println(account);
    }

    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
