package com.shiny.ucenter.config.arg;

import com.shiny.ucenter.interceptor.AuthorizationInterceptor;
import com.shiny.ucenter.interceptor.RequestLimitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/7/11
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLimitInterceptor())
                .addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
        // 拦截所有请求，通过判断是否有 @AuthIgnore注解 决定是否需要登录
        super.addInterceptors(registry);
    }

    /**
     * 添加参数解析，将参数的形式从下划线转化为驼峰
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserMethodArgResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public RequestLimitInterceptor requestLimitInterceptor(){
        return new RequestLimitInterceptor();
    }

    @Bean
    public AuthorizationInterceptor authenticationInterceptor() {
        return new AuthorizationInterceptor();
    }
}
