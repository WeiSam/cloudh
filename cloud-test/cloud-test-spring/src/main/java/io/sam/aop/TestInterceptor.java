package io.sam.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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

    @Around("execution(* io.sam.service.AspectService.logInfo(..))")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==============准备执行===============");
        Object proceed = pjp.proceed();
        log.info("==============执行结束===============");
        return proceed;
    }

    @Around("execution(* io.sam.service.AspectService.logInfo(..))")
    public Object aroundArgs(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==============准备执行===============");
        Object[] args = pjp.getArgs();
        args[0] = "修改参数";
        Object proceed = pjp.proceed(args);
        log.info("==============执行结束===============");
        return proceed;
    }

    @Before("execution(* io.sam.service.AspectService.before(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("==============前置通知===============");
        Object[] args = joinPoint.getArgs();
        log.info("参数:{}", JSON.toJSONString(args));
        log.info("==============前置通知===============");
    }

    /**
     * 在连接点方法结束后执行，无论连接点方法是否抛出异常，增强方法都会执行。
     * @param joinPoint
     * @throws Throwable
     */
    @After("execution(* io.sam.service.AspectService.after(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("==============后置通知===============");
        Object[] args = joinPoint.getArgs();
        log.info("参数:{}", JSON.toJSONString(args));
    }

    /**
     * 在连接点方法结束后执行，只有连接点方法正常执行结束没有抛出异常时，增强方法才会执行。
     * @param joinPoint
     * @throws Throwable
     */
    @AfterReturning("execution(* io.sam.service.AspectService.afterReturn(..))")
    public void afterReturn(JoinPoint joinPoint) throws Throwable {
        log.info("==============连接点方法正常退出后置通知===============");
        Object[] args = joinPoint.getArgs();
        log.info("参数:{}", JSON.toJSONString(args));
    }

    /**
     * 在连接点方法结束后执行，只有连接点方法抛出异常时，增强方法才会执行。
     * @param joinPoint
     * @throws Throwable
     */
    @AfterThrowing("execution(* io.sam.service.AspectService.afterThrowing(..))")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable {
        log.info("==============连接点方法抛出异常退出后置通知===============");
        Object[] args = joinPoint.getArgs();
        log.info("参数:{}", JSON.toJSONString(args));
    }
}
