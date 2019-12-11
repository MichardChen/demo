package com.etc.rest.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign自定义配置类
 * @author ChenDang
 * @date 2019/11/26 0026
 */
@Configuration
public class FeignConfiguration {

    /**
     * 这里配置日志的输出级别,也可以把日志的配置，单独定义一个日志配置类,
     * 这里我们就写在一起,有的时候定义多个Feign,需要单独地自定义Feign的配置
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
