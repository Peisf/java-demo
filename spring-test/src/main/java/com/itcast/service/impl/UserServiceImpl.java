package com.itcast.service.impl;

import com.itcast.dao.RoleDao;
import com.itcast.dao.UserDao;
import com.itcast.domain.Role;
import com.itcast.domain.User;
import com.itcast.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个User中role数据
        for (User user : userList) {
            // 获得user的id
            Long id = user.getId();
            // 将id做为参数 查询当前userId对应的role的集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //1. 要向sys_user表中存储数据
        Long userId = userDao.save(user);
        //2. 向sys_user_role表中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        //1.删除关系表sys_user_role表的数据
        userDao.delUserRoleRel(userId);
        //2.删除sys_user表的数据
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username,password);
        return user;
    }
}
