package io.sam.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuweimu
 * @description
 * @date 2021/9/22 11:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OperateLog {

    String logOpt();
    String logBizDesc();
    String record();
}
