package com.etc.component.jwt.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.etc.base.enums.JwtResultEnums;
import com.etc.base.exception.ResultException;
import com.etc.component.jwt.annotation.IgnorePermissions;
import com.etc.component.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * jwt权限拦截器
 * @author ChenDang
 * @date 2019/7/29 0029
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    JwtProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果不是映射到方法直接跳过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //拦截到方法，判断是否不需要权限
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(IgnorePermissions.class)){
            return true;
        }

        //接下来的就需要判断token了
        String token = JwtUtil.getRequestToken(request);
        try{
            JwtUtil.verifyToken(token,properties.getSecret());
        } catch (TokenExpiredException e) {
            throw new ResultException(JwtResultEnums.TOKEN_EXPIRED);
        } catch (JWTVerificationException e) {
            throw new ResultException(JwtResultEnums.TOKEN_ERROR);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
