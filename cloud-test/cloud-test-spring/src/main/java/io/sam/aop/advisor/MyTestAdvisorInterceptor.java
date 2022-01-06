package io.sam.aop.advisor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author zhuweimu
 * @description
 * @date 2021/8/3 16:46
 */
@Slf4j
public class MyTestAdvisorInterceptor implements MethodInterceptor {

    /**
     * Implement this method to perform extra treatments before and
     * after the invocation. Polite implementations would certainly
     * like to invoke {@link Joinpoint#proceed()}.
     *
     * @param invocation the method invocation joinpoint
     * @return the result of the call to {@link Joinpoint#proceed()};
     * might be intercepted by the interceptor
     * @throws Throwable if the interceptors or the target object
     *                   throws an exception
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("MyTestAdvisorInterceptor增强");
        return invocation.proceed();
    }
}
