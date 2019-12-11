package com.etc.rest;

import com.etc.rest.config.RibbonRandomLoadBalancingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 使用Ribbon + RestTemplate访问
 * 接口模块
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.etc.*","com.etc.*"})
@EnableMongoRepositories(basePackages = {"com.etc.base.mapper"})
//针对单个服务做负载均衡
@RibbonClient(name = "orders",configuration = RibbonRandomLoadBalancingConfiguration.class)
/** 此处配置根据标识 @AvoidScan 过滤掉需要单独
 * 配置的 Ribbon 负载均衡策略，不然就会作用于全局，启动就会报错
 * 但是这个@AvoidScan应该是自定义注解。
 * ### 针对单个服务的 Ribbon 配置
 * demo-goods:
 *   ribbon:
 *     # 基于配置文件形式的 针对单个服务的 Ribbon 负载均衡策略
 *     NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
 *
 * */
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,value = AvoidSa))
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
