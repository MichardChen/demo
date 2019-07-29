package com.etc.component.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2、jwt路径权限配置拦截器
 * @author ChenDang
 * @date 2019/7/29 0029
 */
@Configuration
@ConditionalOnProperty(name = "project.jwt.patternPath", havingValue = "true", matchIfMissing = false)
public class JwtInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/api/**");
    }
}
