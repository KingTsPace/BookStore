package com.pinker.dao;


import com.pinker.entity.User;

public interface UserDao extends BaseDao{

    /**
     *查询用户是否存在
     *存在则返回该用户
     */
    User getUserByUsernameAndPassword(User user);


    /**
     * 存入用户
     * 返回影响行数
     */
    int saveUser(User user);


}
