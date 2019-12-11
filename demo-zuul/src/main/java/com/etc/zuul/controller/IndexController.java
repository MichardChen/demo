package com.etc.zuul.controller;

import com.etc.zuul.feignclient.OrdersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenDang
 * @date 2019/11/7 0007
 * //@RequestMapping("/zuul)
 * //@Controller
 * //使用@RequestMapping和@Controller,springboot在含有main函数的中，
 * 是会自动注册该类中的路劲的，而在其他类中，需要添加额外注解次才可以注册。
 * 否则报404,这是个大坑,需注意,之前以为子包springboot也会扫描,结果没有。
 */
@RestController("/zuul")
public class IndexController {

    @Autowired
    private OrdersClient ordersClient;

    @GetMapping("/index")
    public String index(){
        return "index zuul";
    }

    @GetMapping("/orderIndex")
    public String orderIndex(){
        return ordersClient.index();
    }
}
