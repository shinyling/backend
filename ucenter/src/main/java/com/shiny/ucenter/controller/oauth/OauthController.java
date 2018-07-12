package com.shiny.ucenter.controller.oauth;

import com.shiny.ucenter.config.token.AuthIgnore;
import com.shiny.ucenter.config.token.RequestLimit;
import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.entity.OauthClientDetails;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.service.OauthClientDetailsService;
import com.shiny.ucenter.service.UserService;
import com.shiny.ucenter.utils.AuthUtils;
import com.shiny.ucenter.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL shiny
 * @create 2018/7/10
 */
@RestController
@RequestMapping("oauth")
public class OauthController {

    private final static String KEY="Authorization";

    private final static String RES_TYPE="code";

    private final static String GRANT_TYPE="authorization_code";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;

    @RequestLimit(count = 5)
    @PostMapping("authorize")
    @AuthIgnore
    private JSONResult authorize(HttpServletRequest request, String responseType, String redirectUri) throws BusinessException {
        if(StringUtils.isEmpty(responseType)){
            throw new BusinessException("Parameter responseType can not be null");
        }
        if(!RES_TYPE.equals(responseType)){
            throw new BusinessException("Project only support responseType is code");
        }
        String authorization=request.getHeader(KEY);
        if(authorization==null||authorization.length()==0){
            throw new BusinessException("请提供授权凭证");
        }
        OauthClientDetails oauthClientDetails=AuthUtils.getPrincipleFromHeader(authorization);
        if(oauthClientDetails==null){
            throw new BusinessException("Bad credentials");
        }
        oauthClientDetails=oauthClientDetailsService.queryByPrinciple(oauthClientDetails);
        if(oauthClientDetails==null){
            throw new BusinessException("Bad credentials");
        }
        if(StringUtils.isEmpty(redirectUri)){
            throw new BusinessException("redirectUri can not be null");
        }
        if(!redirectUri.equals(oauthClientDetails.getWebServerRedirectUri())){
            throw new BusinessException("redirectUri incorrect");
        }
        Map<String,String> resultMap=new HashMap(2);
        String code=AuthUtils.generateCode(6);
        resultMap.put("code",code);
        redisUtil.set(oauthClientDetails.getClientId(),code,10*60);
        resultMap.put("expire","600");
        return new JSONResult(resultMap);
    }

    @RequestLimit(count = 5)
    @PostMapping("token")
    @AuthIgnore
    public JSONResult token(HttpServletRequest request,String clientId, String grantType, String code, String redirectUri) throws BusinessException {
        if(StringUtils.isEmpty(grantType)){
            throw new BusinessException("Parameter grantType can not be null");
        }
        if(!GRANT_TYPE.equals(grantType)){
            throw new BusinessException("Parameter grantType must be "+GRANT_TYPE);
        }
        if(StringUtils.isEmpty(code)){
            throw new BusinessException("Parameter code can not be null");
        }
        if(StringUtils.isEmpty(redirectUri)){
            throw new BusinessException("Parameter redirectUri can not be null");
        }
        if(StringUtils.isEmpty(clientId)){
            throw new BusinessException("Parameter clientId can not be null");
        }
        String storedCode= (String) redisUtil.get(clientId);
        if(!code.equals(storedCode)){
            throw new BusinessException("Please authorize first");
        }
        redisUtil.del(clientId);
        String authorization=request.getHeader(KEY);
        if(authorization==null||authorization.length()==0){
            throw new BusinessException("请提供授权凭证");
        }
        User user=AuthUtils.getUserFromHeader(authorization);
        if(user==null){
            throw new BusinessException("Bad credentials");
        }
        user=userService.queryByPrincipal(user);
        if(user==null){
            throw new BusinessException("账号密码错误!");
        }
        Map<String,String> resultMap=new HashMap(2);
        String accessToken=AuthUtils.generateAccessToken();
        redisUtil.set(accessToken,user,600);
        resultMap.put("accessToken",accessToken);
        resultMap.put("expire","600");
        return new JSONResult(resultMap);
    }
}
