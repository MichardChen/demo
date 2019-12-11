/*
package com.etc.zuul.authorize;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

*/
/**
 * 网关我们一般用来做用户鉴权、路由转发、统一返回错误格式
 * @author ChenDang
 * @date 2019/11/4 0004
 *//*

//@Component
public class AuthorizeFilter extends ZuulFilter{

    @Override
    public boolean shouldFilter() {
        return false;
    }

    */
/**
     * 拦截具体的代码
     * @return
     * @throws ZuulException
     *//*

    @Override
    public Object run() throws ZuulException {
       */
/* RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Headers","Authorization,X-Requested-With");

        String requestUri = request.getRequestURI();
        if("/login".equals(requestUri)){
            //不对登录进行拦截
            return null;
        }*//*

        //获取token，进行验证
       // String token = request.getHeader("Authorization");
        //对token进行鉴权
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
*/
