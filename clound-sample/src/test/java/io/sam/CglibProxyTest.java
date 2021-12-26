package io.sam;

import io.sam.proxy.cglib.CglibInterceptorProxy;
import io.sam.service.impl.TestService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/14 17:12
 */
public class CglibProxyTest {

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(TestService.class);
        // 设置代理逻辑
        enhancer.setCallback(new CglibInterceptorProxy());
        // 创建代理对象
        TestService o = (TestService) enhancer.create();
        o.test();
    }
}
