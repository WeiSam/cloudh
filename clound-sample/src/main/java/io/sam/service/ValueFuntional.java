package io.sam.service;

/**
 * @author zhuweimu
 * @classname ValueFuntional
 * @description
 * @date 2020/11/19 17:08
 */
@FunctionalInterface
public interface ValueFuntional<T> {

    /**
     * 生成值
     * @return
     */
    T value();
}
