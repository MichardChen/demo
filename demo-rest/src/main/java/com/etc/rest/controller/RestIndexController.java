package com.etc.rest.controller;

import com.etc.rest.service.FeignClientService;
import com.etc.rest.service.IndexService;
import com.etc.rest.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index接口controller
 * @author ChenDang
 * @date 2019/9/18 0018
 */
@RestController
@RequestMapping("/rest")
public class RestIndexController {

    @Autowired
    IndexService indexService;
    @Autowired
    FeignClientService feignClientService;

    @RequestMapping("/index")
    public String index(){
        return indexService.index();
    }

    @GetMapping(value = "/test")
    public String test(){
        return HttpRequestUtil.remoteRequest("http://localhost:8761/web/index",null,null);
    }

    @RequestMapping("/ireport")
    public String ireport(){
        return "index";
    }

    @GetMapping("orderIndex")
    public String orderIndex(){
        return feignClientService.index();
    }
}
