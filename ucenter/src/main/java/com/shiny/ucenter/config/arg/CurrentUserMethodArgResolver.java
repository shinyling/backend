package com.shiny.ucenter.config.arg;

import com.shiny.ucenter.config.token.CurrentUser;
import com.shiny.ucenter.dto.ResultCode;
import com.shiny.ucenter.entity.User;
import com.shiny.ucenter.exception.BusinessException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author DELL shiny
 * @create 2018/7/11
 */
public class CurrentUserMethodArgResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        User user = (User) nativeWebRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new BusinessException(ResultCode.REQUIRE_LOGIN.getMsg());
    }
}
