package com.itcast.factory;

import com.itcast.dao.UserDao;
import com.itcast.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
