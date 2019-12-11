package com.etc.zuul.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用feign访问orders微服务
 * 不过这里订单服务orders有两个实例,8083和8084端口
 * @author ChenDang
 * @date 2019/11/25 0025
 * 加了decode404，凡是feign请求返回404，都不会走fallback
 */
@FeignClient(value = "orders",fallback = OrderFallBack.class,decode404 = true)
public interface OrdersClient {

    @GetMapping("/order/index")
    public String index();
}
