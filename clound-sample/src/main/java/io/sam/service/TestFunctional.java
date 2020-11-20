package io.sam.service;

/**
 * @author zhuweimu
 * @classname TestFunctional
 * @description
 * @date 2020/10/12 17:56
 */
@FunctionalInterface
public interface TestFunctional<T,R> {

    R test(T t);

}
