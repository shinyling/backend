package com.shiny.ucenter.advice;

import com.shiny.ucenter.dto.JSONResult;
import com.shiny.ucenter.dto.ResultCode;
import com.shiny.ucenter.exception.BusinessException;
import com.shiny.ucenter.exception.RequestLimitException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DELL shiny
 * @create 2018/7/11
 */
@ControllerAdvice
@Log4j2
public class UcenterControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    JSONResult handleException(Exception e){
        log.error("exception :{}!",e.getMessage());
        JSONResult result=new JSONResult(ResultCode.FAILURE);
        return result;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    JSONResult handleBusinessException(BusinessException e){
        log.error(e.getMessage(), e);
        JSONResult result = new JSONResult(ResultCode.FAILURE,e.getMessage());
        return result;
    }

    @ExceptionHandler(RequestLimitException.class)
    @ResponseBody
    JSONResult handleRequstLimitException(RequestLimitException e){
        log.error(e.getMessage(), e);
        JSONResult result = new JSONResult(ResultCode.FAILURE,e.getMessage());
        return result;
    }
}
