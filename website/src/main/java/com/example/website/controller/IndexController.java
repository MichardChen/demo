package com.example.website.controller;

import com.example.website.service.IndexService;
import com.example.website.service.J2cacheService;
import com.example.website.service.UserService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenDang
 * @date 2019/6/27 0027
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    IndexService indexService;
    @Autowired
    J2cacheService j2cacheService;

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id")String id){
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache("Euser");
        Element data = cache.get("user_8");
        if(data != null){
            System.out.println("===================="+data.toString());
        }

        return userService.getUser(id);
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id")String id){
        return userService.delete(id);
    }

    @RequestMapping("/redis")
    public String redis(@RequestParam("id")String id){
        return indexService.delete(id);
    }

    @RequestMapping("/j2cache")
    public String j2cache(){
        return j2cacheService.test();
    }

    @RequestMapping("/queryRedis")
    public String queryRedis(@RequestParam("type")String type){
        return indexService.queryRedis(type);
    }

    @RequestMapping("/getKey")
    public String getKey(@RequestParam("key")String key){
        return indexService.getKey(key);
    }
}
