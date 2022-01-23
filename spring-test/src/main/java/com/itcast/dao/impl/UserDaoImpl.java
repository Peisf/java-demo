package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(final User user) {
        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //使用原始jdbc 完成 PreparedStatement的组建
                PreparedStatement statement = con.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setObject(1,null);
                statement.setString(2,user.getUsername());
                statement.setString(3,user.getPassword());
                statement.setString(4,user.getEmail());
                statement.setString(5,user.getPhoneNum());
                return statement;
            }
        };
        // 创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, keyHolder);
        // 获得生成的主键
        long userId = keyHolder.getKey().longValue();
        // jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null, user.getUsername(),user.getPassword(),user.getEmail(),user.getPhoneNum());
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",userId ,roleId);
        }

    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ? ", new BeanPropertyRowMapper<User>(User.class), username,password);
        return user;
    }
}
