package io.sam.mymapper;

import org.apache.ibatis.binding.MapperMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuweimu
 * @classname MyMapperProxyFactory
 * @description
 * @date 2020/11/9 17:41
 */
public class MyMapperProxyFactory<T> {
    private final Class<T> mapperInterface;
    private final Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MyMapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    @SuppressWarnings("unchecked")
    protected T newInstance(MyMapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }

    public T newInstance() {
        final MyMapperProxy<T> mapperProxy = new MyMapperProxy<>(mapperInterface, methodCache);
        return newInstance(mapperProxy);
    }
}
