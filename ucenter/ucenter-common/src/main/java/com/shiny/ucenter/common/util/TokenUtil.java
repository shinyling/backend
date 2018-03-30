package com.shiny.ucenter.common.util;

import org.apache.commons.codec.digest.Md5Crypt;

/**
 * @author shiny
 **/
public class TokenUtil {

    public static String generateToken(String userId){
        String token=Md5Crypt.md5Crypt(userId.getBytes());
        return token;
    }
}
