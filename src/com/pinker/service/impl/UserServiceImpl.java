package com.pinker.service.impl;

import com.pinker.dao.UserDao;
import com.pinker.dao.impl.UserDaoImpl;
import com.pinker.entity.User;
import com.pinker.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.getUserByUsernameAndPassword(user);
    }

    @Override
    public boolean sign(User user) {
        if (userDao.saveUser(user) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
