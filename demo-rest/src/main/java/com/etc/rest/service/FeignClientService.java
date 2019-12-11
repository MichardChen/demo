package com.etc.rest.service;

import com.etc.rest.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign客户端已经结合了负载均衡
 * @author ChenDang
 * @date 2019/11/26 0026
 */
@FeignClient(name = "orders",configuration = FeignConfiguration.class)
public interface FeignClientService {

    @GetMapping("/order/index")
    public String index();
}
