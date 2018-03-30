package com.shiny.ucenter.web.config;

import com.shiny.ucenter.common.http.BodyReaderHttpServletRequestWrapper;
import com.shiny.ucenter.common.http.HttpHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiny
 **/
@Configuration
public class RequestFilter extends OncePerRequestFilter {

    private final Logger logger= LogManager.getLogger(RequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
        String json = HttpHelper.getBodyString(requestWrapper);
        logger.info("request中inputStream的值:{}",json);
        filterChain.doFilter(requestWrapper, httpServletResponse);
    }
}
