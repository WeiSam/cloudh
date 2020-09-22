package io.sam.lock;

import io.sam.annotation.DisLock;
import io.sam.model.LockResult;
import io.sam.service.LockService;
import io.sam.service.RedisKeyGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname DistributedLockInterceptor
 * @description
 * @date 2020/9/21 16:20
 */
@Aspect
@ConditionalOnClass({RedissonClient.class})
@Component
public class DistributedLockInterceptor {
    Logger log = LoggerFactory.getLogger(DistributedLockInterceptor.class);

    @Autowired
    Map<String,LockService> lockServiceMap;

    @Autowired
    RedisKeyGenerator keyGenerator;

    @Around("execution(public * *(..)) && @annotation(io.sam.annotation.DisLock)")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //生成key
        String key = keyGenerator.generate(pjp);
        LockResult lockResult = null;
        DisLock disLock = method.getAnnotation(DisLock.class);
        LockService lockService = lockServiceMap.get(disLock.distributeLockType().getValue());
        try {
            lockResult = lockService.lock(key, disLock.waitTime(), disLock.keepTime(), disLock.timeUnit());
            boolean isSuccess = lockResult.isSuccess();
            if (log.isDebugEnabled()) {
                log.debug("Distributed lock key is [{}] and status is [{}]", key, isSuccess);
            }
            if (!isSuccess) {
                if (disLock.throwError()) {
                    throw new Exception(disLock.message()+";key:"+key);
                }else {
                    return null;
                }
            }
            return pjp.proceed();
        }catch (Throwable e){
            log.error("分布式锁异常，key: {},异常原因：{}",key,e.getMessage(),e);
            return null;
        }finally {
            lockService.unlock(lockResult);
        }
    }
}
