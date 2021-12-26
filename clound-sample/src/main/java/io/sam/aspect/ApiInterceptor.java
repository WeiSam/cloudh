package io.sam.aspect;

import com.alibaba.fastjson.JSON;
import common.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import retrofit2.Call;

/**
 * @author zhuweimu
 * @description
 * @date 2020/9/21 16:20
 */
@Component
@Aspect
public class ApiInterceptor {
    Logger log = LoggerFactory.getLogger(ApiInterceptor.class);

    @Around("execution(* io.sam.api.TestServiceApi.*(..))")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==============准备执行===============");
        Object proceed = pjp.proceed();
        log.info("{}",proceed instanceof Call);
        if (Call.class.isAssignableFrom(proceed.getClass())) {
            Call call = (Call) proceed;
        }else {
            throw new Exception("响应错误");
        }
        log.info("==============执行结束===============");
        return proceed;
    }
}
