package com.etc.component.jwt.service.impl;

import com.etc.base.entity.User;
import com.etc.component.jwt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ChenDang
 * @date 2019/7/8 0008
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findUser(String userName, String password) {

        if("admin".equals(userName)&&"admin".equals(password)){
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@qq.com");
            user.setNickname("AD");
            user.setPhone("18290921212");
            user.setRemark("remark");
            user.setSalt("123456");
            return user;
        }else{
            return null;
        }

    }
}
