package com.etc.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 开启认证了，但是没有禁用CSRF
 *
 * 新版本的spring-cloud2.0中： Spring Security默认开启了CSRF攻击防御
 * CSRF会将微服务的注册也给过滤了，虽然不会影响注册中心，但是其他客户端是注册不了的
 * 解决方案:
 * 关闭csrf攻击
 * @author ChenDang
 * @date 2019/11/5 0005
 */
@Configuration
public class WebSecurityConfig{

    @EnableWebSecurity
    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
        }
    }



}
