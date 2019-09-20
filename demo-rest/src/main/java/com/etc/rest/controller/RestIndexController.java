package com.etc.rest.controller;

import com.etc.component.jwt.annotation.Login;
import com.etc.rest.util.HttpRequestUtil;
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

    @Login
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @Login
    @GetMapping(value = "/test")
    public String test(){
        return HttpRequestUtil.remoteRequest("http://localhost:8761/web/index",null,null);
    }
}
