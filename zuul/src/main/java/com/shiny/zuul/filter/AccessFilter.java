package com.shiny.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiny
 **/
@Log4j2
@Component
public class AccessFilter extends ZuulFilter {

    @Value("${aa.bb}")
    private String config;

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
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("*******************************************");
        log.info("请求方法:{}，请求地址:{}", request.getMethod(), request.getRequestURL().toString());
        log.info("配置:{}",config);
        return null;
    }
}
