package com.shiny.ucenter.config.security;

import com.alibaba.fastjson.JSON;
import com.shiny.ucenter.dto.BkResCode;
import com.shiny.ucenter.dto.BkResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public class AuthenticationHandler implements AuthenticationSuccessHandler,AuthenticationFailureHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        BkResponse bkResponse=new BkResponse();
        out.write(JSON.toJSONString(bkResponse));
        out.flush();
        out.close();
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        BkResponse bkResponse=new BkResponse(BkResCode.FAILURE);
        out.write(JSON.toJSONString(bkResponse));
        out.flush();
        out.close();
    }
}
