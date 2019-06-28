package com.example.website.service.impl;

import com.etc.entity.Users;
import com.example.website.service.UserService;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    @Cacheable(cacheNames ="Euser",key = "'user_'+#id")
    public String getUser(String id) {
        Users users = new Users();
        users.setAddress("福建");
        users.setUserName("王先森");
        return users.toString();
    }

    //清除缓存
    @CacheEvict(cacheNames ="Euser",key = "'user_'+#id")
    @Override
    public String delete(String id) {
        System.out.println("删除id:"+id);
        return null;
    }
}
