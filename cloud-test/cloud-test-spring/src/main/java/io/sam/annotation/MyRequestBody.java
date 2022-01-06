package io.sam.annotation;

import java.lang.annotation.*;

/**
 * @author zhuweimu
 * @description
 * @date 2021/11/24 14:45
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface MyRequestBody {

}
