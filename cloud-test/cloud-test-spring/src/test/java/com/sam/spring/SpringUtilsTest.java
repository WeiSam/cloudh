package com.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.service.AService;
import io.sam.service.AbstractService;
import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/26 10:35
 */
public class SpringUtilsTest {

    @Test
    public void testResolvableType() throws NoSuchMethodException {
        Method[] methods = AService.class.getMethods();
        Method[] declaredMethods = AService.class.getDeclaredMethods();
        Method getT = AService.class.getMethod("getT", null);
//        ResolvableType resolvableType = ResolvableType.forClass(AbstractService.class);
        ResolvableType resolvableType = ResolvableType.forMethodReturnType(ClassUtils.getMethod(AService.class,"getT",null));
        ResolvableType[] generics = resolvableType.getGenerics();
        ResolvableType[] interfaces = resolvableType.getInterfaces();
        System.out.println(JSON.toJSONString(generics));
    }
}
