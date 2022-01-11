package io.sam;

import io.sam.service.BridgedMethodServiceTest;
import io.sam.service.impl.DataLogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.BridgeMethodResolver;

import java.lang.reflect.Method;

/**
 * @author zhuweimu
 * @description 桥接方法:当类继承或实现泛型的接口或抽象类时,类会为泛型方法生成一个映射的Object的桥接方法,
 * 为了兼容jdk1.5之前不带泛型的情况
 * @date 2021/11/29 10:56
 */
@Slf4j
public class BridgedMethodTest {

    @Test
    public void testBridgedMethod() throws Exception {
        BridgedMethodServiceTest dataLogService = new DataLogServiceImpl();
        Class<? extends BridgedMethodServiceTest> aClass = dataLogService.getClass();
        Method method = aClass.getMethod("print", String.class);
        log.info("method.isBridge = {}",method.isBridge());
        method.invoke(dataLogService,"1234");
        Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);

        //桥接方法
        Method objMethod = aClass.getMethod("print", Object.class);
        log.info("objMethod.isBridge = {}",objMethod.isBridge());
        objMethod.invoke(dataLogService,new Object());
    }
}
