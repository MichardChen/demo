package com.etc.rest.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 针对单个服务的ribbon的负载均衡策略配置
 * 使用方式：哪个微服务需要用这个负载均衡配置，就在那个服务
 * 的启动类上加@RibbonClient的引用
 * @author ChenDang
 * @date 2019/11/20 0020
 */
public class RibbonRandomLoadBalancingConfiguration {

    @Resource
    IClientConfig iClientConfig;

    @Bean
    public IRule iRule(IClientConfig iClientConfig){
        return new RoundRobinRule();
    }
}
