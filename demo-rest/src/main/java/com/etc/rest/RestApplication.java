package com.etc.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 接口模块
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.etc.*","com.etc.*"})
@EnableMongoRepositories(basePackages = {"com.etc.base.mapper"})
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
