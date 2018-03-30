package com.shiny.ucenter.web.exception;

import com.alibaba.fastjson.JSON;
import com.shiny.ucenter.common.dto.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shiny
 **/
@ControllerAdvice
public class WebExceptionAdvice {

    private static Logger logger= LogManager.getLogger(WebExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(Exception e, WebRequest request){
        logger.error("程序异常: {} ",e);
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception=(MethodArgumentNotValidException)e;
            List<ObjectError> errorList= exception.getBindingResult().getAllErrors();
            List<String> msgs=errorList.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
            return new Result(JSON.toJSONString(msgs));
        }
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException constraintViolationException=(ConstraintViolationException)e;
            Set<ConstraintViolation<?>> violationSet=constraintViolationException.getConstraintViolations();
            List<String> msgs=violationSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            return new Result(JSON.toJSONString(msgs));
        }
        return new Result("程序异常");
    }
}
