package io.sam.annotation;

import io.sam.lock.DistributedLockInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/7 17:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(value = {DistributedLockInterceptor.class})
public @interface EnableDisLock {
}
