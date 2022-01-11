package io.sam.processor;

import com.alibaba.fastjson.JSONObject;
import io.sam.annotation.MyRequestBody;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @author zhuweimu
 * @des 自定义请求参数解析器
 * @date 2021/11/24 14:48
 */
@Component
public class MyRequestBodyMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 是否支持参数类型,使用自定义解析器逻辑处理
     * @param parameter 请求参数封装类
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasParameterAnnotation = parameter.hasParameterAnnotation(MyRequestBody.class);
        return hasParameterAnnotation;
    }

    /**
     * 解析请求参数返回参数类型
     *
     * @param parameter    请求参数封装类
     * @param mavContainer  当前请求的 ModelAndViewContainer
     * @param webRequest    当前请求
     * @param binderFactory 创建WebDataBinder的工厂类,可能为null
     * @return 解析参数后返回的值
     * @throws Exception in case of errors with the preparation of argument values
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = servletRequest.getReader();
        String str;
        while (!StringUtils.isEmpty((str = reader.readLine()))) {
            stringBuilder.append(str);
        }
        return JSONObject.parseObject(stringBuilder.toString(),parameter.getParameterType());
    }
}
