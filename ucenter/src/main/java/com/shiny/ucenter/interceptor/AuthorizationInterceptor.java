package com.shiny.ucenter.interceptor;

import com.shiny.ucenter.config.token.AuthIgnore;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
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
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final String ACCESS_TOKEN="access_token";

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthIgnore annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        }else{
            return true;
        }
        if(annotation != null){
            return true;
        }
        String token = request.getHeader(ACCESS_TOKEN);
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(ACCESS_TOKEN);
        }
        if(StringUtils.isBlank(token)){
            Object obj = request.getAttribute(ACCESS_TOKEN);
            if(null!=obj){
                token=obj.toString();
            }
        }
        if(StringUtils.isBlank(token)){
            throw new Exception(ACCESS_TOKEN + "不能为空");
        }
        User user= (User) redisUtil.get(token);
        if(user==null){
            throw new BusinessException("token失效，请重新登陆！");
        }
        redisUtil.expire(token,600);
        request.setAttribute("currentUser",user);
        return true;
    }
}
