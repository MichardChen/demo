package com.etc.zuul.feignclient;

import org.springframework.stereotype.Component;

/**
 * @author ChenDang
 * @date 2019/12/6 0006
 */
@Component
public class OrderFallBack implements OrdersClient{

    @Override
    public String index() {
        return "fallback error...........";
    }
}
