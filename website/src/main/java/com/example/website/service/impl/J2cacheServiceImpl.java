package com.example.website.service.impl;

import com.example.website.service.J2cacheService;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenDang
 * @date 2019/6/28 0028
 */
@Service
public class J2cacheServiceImpl implements J2cacheService {

    @Autowired
    CacheChannel cacheChannel;

    @Override
    public String test() {
        cacheChannel.set("Euser","1","hello");
        return "region:Euser,key:1,value:hello";
    }
}
