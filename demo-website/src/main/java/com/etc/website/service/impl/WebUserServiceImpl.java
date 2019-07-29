package com.etc.website.service.impl;

import com.etc.website.service.WebUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@Service
public class WebUserServiceImpl implements WebUserService {


    @Override
    @Cacheable(cacheNames ="Euser",key = "#id")
    public String getUser(String id) {
        return id.toString();
    }

    //清除缓存
    @CacheEvict(cacheNames ="Euser",key = "#id")
    @Override
    public String delete(String id) {
        System.out.println("删除id:"+id);
        return null;
    }
}
