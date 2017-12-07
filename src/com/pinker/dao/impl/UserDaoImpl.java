package com.pinker.dao.impl;

import com.pinker.dao.BaseDaoImpl;
import com.pinker.dao.UserDao;
import com.pinker.entity.User;
import com.pinker.util.LoadDatabase;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public User getUserByUsernameAndPassword(User user) {
        String name=user.getName();
        String password=user.getPassword();
        String sql=null;
        if(LoadDatabase.getDatabaseType().equals("SQLServer")) {
             sql = "select * from [user] where username=? and password=?";
        }else if(LoadDatabase.getDatabaseType().equals("mysql")){
            sql = "select * from user where username=? and password=?";
        }
        User user1= getBean(sql,name,password);
        return user1;
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into [user] (username,password,email) values(?,?,?) ";
        int column=update(sql,user.getName(),user.getPassword(),user.getEmail());

        return column;
    }
}
