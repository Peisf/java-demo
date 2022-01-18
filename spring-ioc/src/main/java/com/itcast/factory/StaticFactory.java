package com.itcast.factory;

import com.itcast.dao.UserDao;
import com.itcast.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
