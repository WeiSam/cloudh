package io.sam.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhuweimu
 * @classname AbstractFaceService
 * @description
 * @param <P> 封装需要的请求参数
 * @param <R> 请求三方响应参数
 * @date 2020/11/17 16:20
 */
abstract class AbstractFaceService<P,R>{

    public  Class getClazz(){
        return getClassGenricType(this.getClass(),0);
    }

    public static Class getClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if ((index >= params.length) || (index < 0)) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }
}
