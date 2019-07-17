package com.demo1.testzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String str = request.getParameter("token");

        // 这里过滤掉你需要过滤的请求，比如 session token 等等，做个演示

        if (str == null || str.length() < 1000) {

            // 拦截测试
            requestContext.setSendZuulResponse(false); //表示 非法请求
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("拦截掉请求"); //返回类容，这里组装你要返回的信息
            requestContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            return null;
        }

        return null;
    }

}
