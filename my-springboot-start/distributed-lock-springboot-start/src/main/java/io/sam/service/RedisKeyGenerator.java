package io.sam.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface RedisKeyGenerator {


    /**
     * 获取AOP参数,生成指定缓存Key
     * @param pjp       PJP
     * @return 缓存KEY
     */
    String generate(ProceedingJoinPoint pjp);
}