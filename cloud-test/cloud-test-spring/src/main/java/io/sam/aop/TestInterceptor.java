package io.sam.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @classname DistributedLockInterceptor
 * @description
 * @date 2020/9/21 16:20
 */
@Component
@Aspect
@SuppressWarnings("rawtypes")
public class TestInterceptor {
    Logger log = LoggerFactory.getLogger(TestInterceptor.class);

    @Around("execution(* io.sam..*.*(..))")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==============准备执行===============");
        Object proceed = pjp.proceed();
        log.info("==============执行结束===============");
        return proceed;
    }
}
