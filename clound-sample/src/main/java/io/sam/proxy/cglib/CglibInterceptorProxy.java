package io.sam.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/14 17:06
 */
@Slf4j
public class CglibInterceptorProxy implements MethodInterceptor {

    private Integer acount;

    public CglibInterceptorProxy(Integer acount) {
        this.acount = acount;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("执行cglib代理对象方法:{}",acount);
        return methodProxy.invokeSuper(o,objects);
    }
}
