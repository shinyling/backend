package com.shiny.ucenter.dto;

import java.io.Serializable;

/**
 * @author DELL shiny
 * @create 2018/7/5
 */
public class JSONResult implements Serializable {

    private int code;

    private String msg;

    private Object data;

    public JSONResult(){
        this.code=ResultCode.SUCCESS.getCode();
        this.msg=ResultCode.SUCCESS.getMsg();
    }

    public JSONResult(ResultCode code,String msg){
        this.code=code.getCode();
        this.msg=msg;
    }

    public JSONResult(Object data){
        this.code=ResultCode.SUCCESS.getCode();
        this.msg=ResultCode.SUCCESS.getMsg();
        this.data=data;
    }

    public JSONResult(ResultCode resCode){
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
