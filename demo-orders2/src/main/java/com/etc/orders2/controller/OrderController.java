package com.etc.orders2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenDang
 * @date 2019/11/19 0019
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("index")
    public String index(){
        return "index2";
    }
}
