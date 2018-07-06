package com.shiny.ucenter.dto;

import org.springframework.http.HttpStatus;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public enum  BkResCode {

    SUCCESS(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase()),

    FAILURE(9999,"System error"),

    REQUIRE_LOGIN(HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED.getReasonPhrase());

    private int code;

    private String msg;

    BkResCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
