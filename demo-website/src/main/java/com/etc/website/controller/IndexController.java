package com.etc.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.etc.base.service.BusinessLogRecordService;
import com.etc.base.util.HttpClientUtils;
import com.etc.website.service.J2cacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
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
    @Autowired
    BusinessLogRecordService businessLogRecordService;
    @Autowired
    GridFsTemplate gridFsTemplate;

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

    @RequestMapping("/count")
    public String count(){
        return businessLogRecordService.count();
    }

    @RequestMapping("/saveFile")
    public String saveFile(){
        return businessLogRecordService.count();
    }

    @RequestMapping("/test")
    public String test(){
        JSONObject ret = HttpClientUtils.httpGet("http://localhost:8088/test");
        return ret.toJSONString();
    }
}
