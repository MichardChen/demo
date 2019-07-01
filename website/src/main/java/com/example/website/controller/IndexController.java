package com.example.website.controller;

import com.example.website.service.J2cacheService;
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
    J2cacheService j2cacheService;

    @RequestMapping("/j2cache")
    public String j2cache(@RequestParam("key")String key,@RequestParam("value")String value){
        return j2cacheService.addCache(key,value);
    }

    @RequestMapping("/queryCache")
    public String queryRedis(@RequestParam("type")String type){
        return j2cacheService.queryCache(type);
    }

    @RequestMapping("/getKey")
    public String getKey(@RequestParam("key")String key){
        return j2cacheService.getKey(key);
    }

    @RequestMapping("/deleteKey")
    public String deleteKey(@RequestParam("key")String key){
        return j2cacheService.deleteKey(key);
    }
}
