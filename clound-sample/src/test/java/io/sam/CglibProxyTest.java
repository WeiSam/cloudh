package io.sam;

import io.sam.mymapper.MyMapperProxy;
import io.sam.proxy.cglib.CglibInterceptorProxy;
import io.sam.service.MyMapperNameTest;
import io.sam.service.impl.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/14 17:12
 */
@Slf4j
public class CglibProxyTest {

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(TestService.class);
        // 设置代理逻辑
//        enhancer.setCallback(new CglibInterceptorProxy(1));

/*        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                log.info("InvocationHandler 代理增强");
                return null;
            }
        });*/

        /**
         * Callbacks 与 CallbackFilter结合使用,挑选使用哪个Callback
         */
        enhancer.setCallbacks(new Callback[]{new CglibInterceptorProxy(1)
                ,new CglibInterceptorProxy(2),
                new CglibInterceptorProxy(3)});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 2;
            }
        });
        // 创建代理对象
        TestService testService = (TestService) enhancer.create();
//        testService.test("InvocationHandler");
        testService.testFinal();
    }

    @Test
    public void testJdk() {
        MyMapperNameTest myMapperNameTest = (MyMapperNameTest)Proxy.newProxyInstance(MyMapperNameTest.class.getClassLoader(),new Class[] {MyMapperNameTest.class},new MyMapperProxy(null,null));
        System.out.println(myMapperNameTest.age());
        System.out.println(myMapperNameTest.name());
    }
}
