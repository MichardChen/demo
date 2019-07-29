package com.etc.component.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2019/7/29 0029
 */
@Component
@Configuration
@Data
@ConfigurationProperties(prefix = "project.jwt")
public class JwtProperties {

    //jwt密钥
    private String secret;

    //过期天数
    private Integer expired;

    //权限模式-路径拦截
    private boolean patternPath;

    //权限模式-注解拦截
    private boolean patternAnno;
}
