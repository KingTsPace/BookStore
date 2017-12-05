package com.pinker.service;

import com.pinker.entity.User;

public interface UserService {

    User login(User user);

    boolean sign(User user);


}
