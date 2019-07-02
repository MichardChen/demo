package com.etc.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @ComponentScan要把其他模块也给扫描进来,不然其他模块的@Service,注入到controller里,会提示找不到bean
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.etc.*","com.etc.*"})
@EnableMongoRepositories(basePackages = {"com.etc.base.mapper"})
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
