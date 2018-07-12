package com.shiny.ucenter.interceptor;

import com.shiny.ucenter.config.token.RequestLimit;
import com.shiny.ucenter.exception.RequestLimitException;
import com.shiny.ucenter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DELL shiny
 * @create 2018/7/11
 */
@Component
public class RequestLimitInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestLimit annotation=null;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(RequestLimit.class);
        }else{
            return true;
        }
        if(annotation==null){
            return true;
        }
        int limit=annotation.count();
        long period=annotation.period();
        String ip = request.getLocalAddr();
        String url = request.getRequestURL().toString();
        String key = "req_limit_" .concat(url).concat(ip);
        if (redisUtil.get(key) == null || (int)redisUtil.get(key) == 0) {
            redisUtil.set(key, 1,period/1000);
        } else {
            redisUtil.incr(key,1);
        }
        int count = (int) redisUtil.get(key);
        if (count > limit) {
            //logger.info("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
            throw new RequestLimitException();
        }
        return true;
    }
}
