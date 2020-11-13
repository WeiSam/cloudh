package io.sam.mymapper;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhuweimu
 * @classname NyMypperFactoryBean
 * @description
 * @date 2020/11/9 17:15
 */
public class MyMypperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;

    public MyMypperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        MyMapperProxyFactory<T> tMyMapperProxyFactory = new MyMapperProxyFactory<T>(mapperInterface);
        return tMyMapperProxyFactory.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
