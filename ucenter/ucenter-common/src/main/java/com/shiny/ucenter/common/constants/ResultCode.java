package com.shiny.ucenter.common.constants;

/**
 * @author shiny
 */
public enum ResultCode {

    SUCCESS("200","成功"),

    UNAUTHORIZED("401","参数验证失败"),

    FAILURE("400","失败"),

    INTERNAL_SERVER_ERROR("500","服务器内部错误"),

    NOT_FOUND("404","未找到对应接口");

    private String code;

    private String msg;

    ResultCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String code(){
        return code;
    }

    public String msg(){
        return msg;
    }
}
