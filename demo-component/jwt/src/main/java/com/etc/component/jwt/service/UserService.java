package com.etc.component.jwt.service;

import com.etc.base.entity.User;

/**
 * @author ChenDang
 * @date 2019/7/8 0008
 */
public interface UserService {
    public User findUser(String userName, String password);
}
