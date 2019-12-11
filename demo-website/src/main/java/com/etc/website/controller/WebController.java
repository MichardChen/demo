package com.etc.website.controller;

import com.etc.component.jwt.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * web 控制器
 * @author ChenDang
 * @date 2019/7/1 0001
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @Login
    @GetMapping(value = "/jwt")
    public String jwt(){
        return "jwt";
    }
}
