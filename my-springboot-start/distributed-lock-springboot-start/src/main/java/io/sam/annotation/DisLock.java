package io.sam.annotation;

import io.sam.enums.LockServiceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @classname DisLock
 * @description
 * @date 2020/9/21 10:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DisLock {

    /**
     * 锁key的前缀
     * @return 锁key的前缀
     */
    String prefix() default "";
    /**
     * 锁key
     * @return
     */
    String key() default "";

    /**
     * <p>
     * Key的分隔符（默认 :）
     * </p>
     * <p>
     * 生成的Key：N:SO1008:500
     * </p>
     *
     * @return String
     */
    String delimiter() default ":";

    /**
     * 等待时间
     * @return
     */
    long waitTime() default 0;

    /**
     * 持有锁时间
     * @return
     */
    long keepTime() default 60;

    /**
     * 时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * 提示消息
     * @return String
     */
    String message() default "该资源已被占用!";

    /**
     * 是否抛出错误
     *
     * @return boolean
     */
    boolean throwError() default true;

    /**
     * 使用锁类型
     * @return
     */
    LockServiceType lockServiceType() default LockServiceType.REDISSON;
}
