package com.shiny.ucenter.exception;

/**
 * @author DELL shiny
 * @create 2018/7/11
 */
public class RequestLimitException extends Exception {

    public RequestLimitException(){
        super("请求次数超限");
    }

    public RequestLimitException(String msg){
        super(msg);
    }
}
