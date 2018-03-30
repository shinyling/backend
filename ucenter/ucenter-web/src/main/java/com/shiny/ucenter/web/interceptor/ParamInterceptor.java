package com.shiny.ucenter.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shiny.ucenter.common.dto.CommonRequest;
import com.shiny.ucenter.common.dto.Result;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author shiny
 **/
public class ParamInterceptor extends BaseInterceptor implements HandlerInterceptor {

    private static final Logger logger= LogManager.getLogger(ParamInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String body= IOUtils.toString(httpServletRequest.getInputStream(), Charset.defaultCharset());
        if(!StringUtils.isNotEmpty(body)){
            logger.error("请求参数为空,拒绝处理!");
            return false;
        }
        httpServletRequest.setAttribute("body",body);
        CommonRequest commonRequest= null;
        try {
            commonRequest = JSON.parseObject(body, CommonRequest.class);
        } catch (Exception e) {
            logger.error("传入参数非JSON格式，拒绝处理!"+body);
            return false;
        }
        logger.info("收到请求,请求IP:{},请求URL:{},请求参数{}",getIpAddress(httpServletRequest),httpServletRequest.getRequestURI(),JSON.toJSONString(commonRequest, SerializerFeature.WriteMapNullValue));
        JSONObject jsonObject=commonRequest.getData();
        //解决无参数接口空指针
        if(jsonObject!=null) {
            Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
            Iterator<Map.Entry<String, Object>> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                Object object = entry.getValue();
                if (object == null) {
                    returnJson(httpServletResponse, JSON.toJSONString(new Result("参数为空"), SerializerFeature.WriteMapNullValue), logger);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        httpServletRequest.removeAttribute("body");
        httpServletRequest.removeAttribute("account");
    }

}
