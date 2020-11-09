package io.sam.annotation;

import io.sam.config.MyMapperAutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuweimu
 * @classname EnableMyMapper
 * @description
 * @date 2020/10/28 14:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(MyMapperAutoConfig.class)
public @interface EnableMyMapper {
}
