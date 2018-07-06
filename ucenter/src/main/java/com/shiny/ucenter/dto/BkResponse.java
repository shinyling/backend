package com.shiny.ucenter.dto;

import java.io.Serializable;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public class BkResponse<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public BkResponse(){
        this.code=BkResCode.SUCCESS.getCode();
        this.msg=BkResCode.SUCCESS.getMsg();
    }

    public BkResponse(T data){
        this.code=BkResCode.SUCCESS.getCode();
        this.msg=BkResCode.SUCCESS.getMsg();
        this.data=data;
    }

    public BkResponse(BkResCode resCode){
        this.code=resCode.getCode();
        this.msg=resCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
