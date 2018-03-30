package com.shiny.ucenter.common.dto;

import com.shiny.ucenter.common.constants.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shiny
 **/
@Data
public class Result<T> implements Serializable{

    private T data;

    private String code;

    private String msg;

    public Result(){
        this.code= ResultCode.SUCCESS.code();
        this.msg=ResultCode.SUCCESS.msg();
        this.data=null;
    }

    public Result (T data){
        this.code= ResultCode.SUCCESS.code();
        this.msg= ResultCode.SUCCESS.msg();
        this.data=data;
    }

    public Result (T data,ResultCode resultCode){
        this.code= resultCode.code();
        this.msg=resultCode.msg();
        this.data=data;
    }

    public Result (String msg){
        this.code= ResultCode.FAILURE.code();
        this.msg=msg;
    }

    public boolean isSuccess(){
        return this.code.equals(ResultCode.SUCCESS.code());
    }

}
