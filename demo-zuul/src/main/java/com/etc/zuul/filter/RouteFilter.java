package com.etc.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * 过滤器
 */
@Component
public class RouteFilter extends ZuulFilter {

    /**
     * 设置过滤器类型为前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 设置过滤器顺序，越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 设置过滤器是否生效，返回true则需要权限校验,
     * 返回false则不需要权限校验
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获取上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Map<String, String[]> map = request.getParameterMap();
        String contentType = request.getContentType();
        int contentLength = request.getContentLength();
        //获取请求uri,对uri进行访问判断
        String uri = request.getRequestURI();
        if("/webreq/error/htp".equalsIgnoreCase(uri)){
            return true;
        }
        return false;
    }

    /**
     * 业务逻辑,只有shouldFilter返回true,
     * 才会进入该方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //jwt的token，可以用请求头传过来，也可以用参数传过来，一般是用请求头传递
        String token = request.getHeader("token");
        System.out.println("=================请求头信息=================");
        //请求头信息
        Enumeration<String> headersMap = request.getHeaderNames();
        while (headersMap.hasMoreElements()){
            String headerName = (String)headersMap.nextElement();
            String headerVal =request.getHeader(headerName);
            System.out.println(headerName+":"+headerVal);
        }
        if(StringUtils.isEmpty(token)){
            //过滤掉该路由，不对它进行路由
            requestContext.setSendZuulResponse(false);
            //返回错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}

