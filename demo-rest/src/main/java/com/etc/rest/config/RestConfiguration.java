package com.etc.rest.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置ribbon的全局设置
 * @author ChenDang
 * @date 2019/11/17 0017
 */
@Configuration
public class RestConfiguration {

    /**
     * 负载均衡
     * 定义RestTemplate bean
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 定义IRule 规则bean,默认轮询
     * 负载均衡策略有：
     * 1、随机策略RandomRule，随机选择Server
     * 2、轮询策略RoundRobinRule，按顺序循环选择server
     * 3、重试策略RetryRule,在一个配置时间段内选择Server不成功，则一直尝试选择一个可用的server
     * 4、最低并发策略BestAvailableRule，逐个考察server，如果断路器打开就忽略，再选择一个并发连接
     * 最低的server
     * 5、可用过滤策略AvailabilityFilteringRule，过滤掉一直连接失败并被标记为cricuit tripped的
     * server，过滤掉那些高并发的连接Server(active connections超过配置的网值)
     * 6、响应时间加权策略ResponseTimeWeightedRule，根据server的响应时间加权重，响应时间越长，
     * 权重越低，被选择的概率越低；响应时间越短，权重越高，被选择到的概率越高。综合各个因素，影响响应
     * 时间的因素很多，如IO，网络，磁盘
     * 7、区域权衡策略ZoneAvoidenceRule，综合判断server所在区域的性能和server可用性轮询选择server，
     * 并判断一个AWS Zone的运行性能是否可用，剔除不可用zone中的server
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

    /**
     * 随机策略
     * @return
     */
    RandomRule randomRule(){
        return new RandomRule();
    }

    /**
     * 轮询测试
     */
    RoundRobinRule roundRobinRule(){
        RoundRobinRule roundRobinRule = new RoundRobinRule();
        return roundRobinRule;
    }
}
