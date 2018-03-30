package com.shiny.ucenter.web.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * @author shiny
 **/
public class ArgumentResolver  implements HandlerMethodArgumentResolver{

    private final Logger logger= LogManager.getLogger(ArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request=nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String body=IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
        logger.info("body 中的值为:{}",body);
        JSONObject jsonObject= JSON.parseObject(body);
        if(jsonObject==null){
            logger.info("未传入参数!");
        }else {
            logger.info("参数值:{}",jsonObject);
            String paramName=methodParameter.getParameterName();
            Object obj= jsonObject.get(paramName);
            NotNull notNull=methodParameter.getParameterAnnotation(NotNull.class);
            if(notNull!=null){
                if(obj==null){
                    logger.error("参数:{}不允许空值",paramName);
                }
            }
            if(obj!=null){
                if (webDataBinderFactory != null) {
                    WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, obj, methodParameter.getParameterName());
                    binder.convertIfNecessary(obj, methodParameter.getParameterType(), methodParameter);
                }
                return obj;
            }else{
                Class clazz=methodParameter.getParameterType();
                Object instance=clazz.newInstance();
                Field[] fields=clazz.getDeclaredFields();
                for (Field field:fields){
                    String fieldName=field.getName();
                    Object fieldValue=jsonObject.get(fieldName);
                    if(fieldValue!=null){
                        Annotation[] annotations=field.getAnnotations();
                        if(annotations==null||annotations.length==0){
                            invokeSet(clazz,instance,field,fieldValue);
                        }else {
                            for(Annotation annotation:annotations){
                                if(annotation==null){
                                    invokeSet(clazz,instance,field,fieldValue);
                                }else {
                                    if(annotation instanceof Length){
                                        Length length=(Length) annotation;
                                        int min=length.min();
                                        int max=length.max();
                                        String value=fieldValue.toString();
                                        int valueLen=value.length();
                                        if(min<valueLen&&valueLen<max){
                                            invokeSet(clazz,instance,field,value);
                                        }else {
                                            logger.error("{}校验失败:{}",fieldName,length.message());
                                        }
                                    }
                                }
                            }
                        }
                        if (webDataBinderFactory != null) {
                            WebDataBinder binder = webDataBinderFactory.createBinder(nativeWebRequest, instance, methodParameter.getParameterName());
                            binder.convertIfNecessary(instance, methodParameter.getParameterType(), methodParameter);
                        }
                    }else {
                        NotNull notNull2=field.getAnnotation(NotNull.class);
                        if(notNull2!=null){
                            logger.error("{}不为空字段未设置!或未找到参数对应属性",fieldName);
                        }
                    }
                }
                return instance;
            }
        }
        return null;
    }

    private void invokeSet(Class clazz,Object instance,Field field,Object object){
        try {
            PropertyDescriptor descriptor=new PropertyDescriptor(field.getName(),clazz);
            Method method=descriptor.getWriteMethod();
            method.invoke(instance,object);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
