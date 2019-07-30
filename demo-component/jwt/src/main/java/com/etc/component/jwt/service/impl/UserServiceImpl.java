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
    public User findUser(String userName) {

        if("admin".equals(userName)){
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@qq.com");
            user.setNickname("AD");
            user.setPhone("18290921212");
            user.setRemark("remark");
            user.setSalt("123456");
            user.setPassword("0596bfdcc8544eaccce45400689d3864ed7deac3bc6c0fdab0c7af579e284df0");
            return user;
        }else{
            return null;
        }

    }
}
