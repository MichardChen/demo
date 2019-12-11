package com.etc.orders2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Orders2Application {

    public static void main(String[] args) {
        SpringApplication.run(Orders2Application.class, args);
    }

}
