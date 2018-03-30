package com.shiny.ucenter.web.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * @author shiny
 **/
public class BaseInterceptor {

    private static final Logger logger= LogManager.getLogger(BaseInterceptor.class);

    protected void returnJson(HttpServletResponse response, String json, Logger logger){
        logger.info("返回数据:{}",json);
        PrintWriter writer=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        }catch (Exception e){
            logger.error("response error",e);
        }finally {
            if(writer!=null){
                writer.close();
            }
        }
    }

    protected boolean checkTimestamp(String timestamp){
        Timestamp systemTimestamp=new Timestamp(System.currentTimeMillis());
        Timestamp paramTimestamp=new Timestamp(Long.parseLong(timestamp));
        long between=Math.abs(systemTimestamp.getTime()-paramTimestamp.getTime())/(1000*60);
        return between<=5&&between>=0;
    }

    protected String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }

}
