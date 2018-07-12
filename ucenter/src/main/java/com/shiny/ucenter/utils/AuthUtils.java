package com.shiny.ucenter.utils;

import com.shiny.ucenter.entity.OauthClientDetails;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import java.util.Random;
import java.util.UUID;


/**
 * @author DELL shiny
 * @create 2018/7/10
 */
public class AuthUtils {

    public static OauthClientDetails getPrincipleFromHeader(String header) throws BusinessException {
        String encrypt=null;
        OauthClientDetails oauthClientDetails=null;
        if(StringUtils.isNotEmpty(header)&&header.length()>6) {
            encrypt = header.substring(6);
        }else {
            throw new BusinessException("Please provider your principal");
        }
        if(StringUtils.isNotEmpty(encrypt)) {
            byte[] decode = Base64Utils.decode(encrypt.getBytes());
            String[] infos= StringUtils.split(new String(decode),":");
            if(infos!=null&&infos.length==2) {
                oauthClientDetails=new OauthClientDetails();
                oauthClientDetails.setClientId(infos[0]);
                oauthClientDetails.setClientSecret(infos[1]);
            }
        }else {
            throw new BusinessException("Please provider your principal");
        }
        return oauthClientDetails;
    }

    public static String generateCode(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static User getUserFromHeader(String authorization) throws BusinessException {
        String encrypt=null;
        User user=null;
        if(StringUtils.isNotEmpty(authorization)&&authorization.length()>6) {
            encrypt = authorization.substring(6);
        }else {
            throw new BusinessException("Please provider your principal");
        }
        if(StringUtils.isNotEmpty(encrypt)) {
            byte[] decode = Base64Utils.decode(encrypt.getBytes());
            String[] infos= StringUtils.split(new String(decode),":");
            if(infos!=null&&infos.length==2) {
                user=new User();
                user.setMobile(infos[0]);
                user.setPassword(infos[1]);
            }
        }else {
            throw new BusinessException("Please provider your principal");
        }
        return user;
    }

    public static String generateAccessToken() {
        String accessToken=UUID.randomUUID().toString();
        return accessToken;
    }
}
