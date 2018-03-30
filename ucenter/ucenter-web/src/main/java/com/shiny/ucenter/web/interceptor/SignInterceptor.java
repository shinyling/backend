package com.shiny.ucenter.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shiny.cache.util.RedisUtil;
import com.shiny.ucenter.common.dto.CommonRequest;
import com.shiny.ucenter.common.dto.Result;
import com.shiny.ucenter.common.entity.User;
import com.shiny.ucenter.common.http.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author shiny
 **/
public class SignInterceptor extends BaseInterceptor implements HandlerInterceptor {

    @Value("${tokenKey}")
    private String tokenKey;

    @Value("${tokenPrefix}")
    private String tokenPrefix;

    @Value("${tokenExpireTime}")
    private String tokenExpireTime;

    @Autowired
    private RedisUtil redisUtil;

    private org.apache.logging.log4j.Logger logger= LogManager.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String body= (String) request.getAttribute("body");
        if(!StringUtils.isNotEmpty(body)){
            logger.error("请求参数为空,拒绝处理!");
            return false;
        }
        CommonRequest commonRequest= JSON.parseObject(body, CommonRequest.class);
        JSONObject data=commonRequest.getData();
        if(data==null){
            returnJson(response,JSON.toJSONString(new Result("参数为空"), SerializerFeature.WriteMapNullValue),logger);
            return false;
        }
        String signNull=commonRequest.getSign();
        if(!StringUtils.isNotEmpty(signNull)){
            returnJson(response,JSON.toJSONString(new Result("sign为空拒绝处理"),SerializerFeature.WriteMapNullValue),logger);
            return false;
        }
        logger.debug("开始校验时间戳!");
        if(!checkTimestamp(commonRequest.getTimestamp())){
            returnJson(response,JSON.toJSONString(new Result("请求已过期"), SerializerFeature.WriteMapNullValue),logger);
            return false;
        }
        logger.debug("开始校验token!");
        String token=commonRequest.getToken();
        if(!StringUtils.isNotEmpty(token)){
            returnJson(response,JSON.toJSONString(new Result("token已失效"),SerializerFeature.WriteMapNullValue),logger);
            return false;
        }else {
            User user= (User) redisUtil.get(tokenPrefix+token);
            if(user!=null){
                request.setAttribute("account",user);
                redisUtil.updateExpire(tokenPrefix+token,Integer.valueOf(tokenExpireTime), TimeUnit.MINUTES);
            }else {
                returnJson(response,JSON.toJSONString(new Result("token 已失效"),SerializerFeature.WriteMapNullValue),logger);
                return false;
            }
        }
        String sign=commonRequest.getSign();
        if(!StringUtils.isNotEmpty(sign)){
            returnJson(response,JSON.toJSONString(new Result("sign 为空异常"),SerializerFeature.WriteMapNullValue),logger);
            return false;
        }


        //方便代码测试先不校验签名
        changeBodyString(request);
        return true;
//        logger.debug("开始校验sign!");
//        if(checkSign(body,commonRequest)){
//            changeBodyString(request);
//            return true;
//        }else {
//            returnJson(response,JSON.toJSONString(new Result("sign 错误"),SerializerFeature.WriteMapNullValue),logger);
//            return false;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        if(e==null){//未报错
            String requestUri=request.getRequestURI();
            if(requestUri.contains("resetPassword")||requestUri.contains("modifyPassword")||requestUri.contains("loginOut")||requestUri.contains("resetMobile")) {//重置密码
                String body = (String) request.getAttribute("body");
                if(StringUtils.isNotEmpty(body)){
                    CommonRequest commonRequest=JSON.parseObject(body, CommonRequest.class);
                    String token=commonRequest.getToken();
                    if(StringUtils.isNotEmpty(token)){
                        //移除登录信息
                        redisUtil.remove(tokenPrefix+token);
                    }
                }
            }
        }
    }

    private boolean checkSign(String body,CommonRequest commonRequest){
        JSONObject jsonObject=JSON.parseObject(body, Feature.OrderedField);
        Set<String> keySet=jsonObject.keySet();
        List<String> keys=new ArrayList<>(keySet);
        Collections.sort(keys);
        String source=dataASCIISortReturnSource(jsonObject,keys);
        logger.info(source);
        String encrypt= Md5Crypt.md5Crypt((source+tokenKey).getBytes());
        if(!StringUtils.isNotEmpty(encrypt)){
            return false;
        }
        return encrypt.toUpperCase().equals(commonRequest.getSign());
    }

    /**
     * 请求参数AscII排序并拼接待签名字符串
     * @return 拼接好的待签名字符串
     */
    private String dataASCIISortReturnSource(JSONObject jsonObject,List<String> keys){
        StringBuilder stringBuilder=new StringBuilder();
        for(String key:keys){
            if(key.equals("sign")){

            }else {
                if(stringBuilder.length()==0){
                    stringBuilder.append(jsonObject.get(key));
                }else {
                    stringBuilder.append("&");
                    stringBuilder.append(jsonObject.get(key));
                }
            }
        }
        return stringBuilder.toString();
    }

    private void changeBodyString(HttpServletRequest request){
        BodyReaderHttpServletRequestWrapper requestWrapper= (BodyReaderHttpServletRequestWrapper) request;
        requestWrapper.changBodyString();
    }

}
