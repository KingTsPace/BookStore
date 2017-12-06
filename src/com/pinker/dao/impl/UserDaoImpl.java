package com.pinker.dao.impl;

import com.pinker.dao.BaseDao;
import com.pinker.dao.UserDao;
import com.pinker.entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao{
    @Override
    public User getUserByUsernameAndPassword(User user) {
        String name=user.getName();
        String password=user.getPassword();

        String sql="select * from user where username=? and password=?";
        User user1=getBean(sql,name,password);
        return user1;
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into user (username,password,email) values(?,?,?) ";
        int column=update(sql,user.getName(),user.getPassword(),user.getEmail());

        return column;
    }
}
