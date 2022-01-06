package io.sam.config;

import io.sam.processor.MyRequestBodyMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhuweimu
 * @description
 * @date 2021/11/24 15:14
 */
@Configuration
public class CustomizeWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    MyRequestBodyMethodArgumentResolver myRequestBodyMethodArgumentResolver;

    /**
     * 添加自定义参数解析器
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(myRequestBodyMethodArgumentResolver);
    }
}
