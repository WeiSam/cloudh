package io.sam.service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/26 10:42
 */
public abstract class AbstractService<T> implements TestService<T>{

    public abstract T getT();
}
