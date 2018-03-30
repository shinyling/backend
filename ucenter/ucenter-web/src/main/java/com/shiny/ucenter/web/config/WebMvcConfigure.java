package com.shiny.ucenter.web.config;

import com.shiny.ucenter.web.interceptor.ParamInterceptor;
import com.shiny.ucenter.web.interceptor.SignInterceptor;
import com.shiny.ucenter.web.resolver.ArgumentResolver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author shiny
 **/
@Configuration
public class WebMvcConfigure extends WebMvcConfigurerAdapter {

    private final Logger logger= LogManager.getLogger(WebMvcConfigure.class);

    @Bean
    public ParamInterceptor paramInterceptor(){
        return new ParamInterceptor();
    }

    @Bean
    public SignInterceptor signInterceptor(){
        return new SignInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(paramInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login/**","/user/logout/**","/user/register/**");
        registry.addInterceptor(signInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login/**","/user/logout/**","/user/register/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new ArgumentResolver());
    }
}
