package com.etc.component.jwt.aop;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.etc.base.enums.JwtResultEnums;
import com.etc.base.exception.ResultException;
import com.etc.component.jwt.util.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenDang
 * @date 2019/7/8 0008
 */
@Aspect
@Component
public class LoginAop {

    /**
     * 这里先写固定
     */
    private String secret = "123456";

    @Autowired
    HttpServletRequest request;

    @Pointcut("@annotation(com.etc.component.jwt.annotation.Login)")
    public void jwtLogin() {};

    @Around("jwtLogin()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {

        // 获取请求对象头部token数据
        String token = JwtUtil.getRequestToken(request);

        // 验证token数据是否正确
        try {
            JwtUtil.verifyToken(token,secret);
        } catch (TokenExpiredException e) {
            throw new ResultException(JwtResultEnums.TOKEN_ERROR);
        } catch (JWTVerificationException e) {
            throw new ResultException(JwtResultEnums.TOKEN_ERROR);
        }

        return point.proceed();
    }
}
