package io.sam.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuweimu
 * @classname BaseConfig
 * @description
 * @date 2020/11/17 17:31
 */
public class BaseDicConfig {

    /**
     * 字典属性字段名称关键字
     */
    private static final String DEF_DIC_KEY = "_M_MATCH_";

    /**
     * 保存字典配置值
     */
    public final Map<String,String> dicConfigMap = new ConcurrentHashMap<>(16);

    /**
     * 获取字典配置Map
     * @return
     */
    public Map<String, String> getDicConfigMap() {
        return dicConfigMap;
    }

    /**
     * 保存字典配置
     * @param key
     * @param value
     */
    public void putValue(String key,String value){
        dicConfigMap.put(key, value);
    }

    /**
     * 获取字典配置值
     * @param key
     * @return
     */
    public String getDicValue(String key){
        return dicConfigMap.get(key);
    }

    /**
     * 判断是否人脸配置字典属性
     * 规定规则:public+静态变量+final+字符串类型+字段名包含默认关键字
     * @param field
     * @return
     */
    public Boolean isDicField(Field field){
        return Modifier.isStatic(field.getModifiers())
                && Modifier.isPublic(field.getModifiers())
                && Modifier.isFinal(field.getModifiers())
                && field.getName().contains(DEF_DIC_KEY)
                && String.class.getName().equals(field.getType().getName());
    }

    /**
     * 判断是否人脸配置字典属性
     * 规定规则:public+静态变量+final+字符串类型+字段名包含指定关键字
     * @param field
     * @return
     */
    public Boolean isDicField(Field field,String key){
        return Modifier.isStatic(field.getModifiers())
                && Modifier.isPublic(field.getModifiers())
                && Modifier.isFinal(field.getModifiers())
                && field.getName().contains(key)
                && String.class.getName().equals(field.getType().getName());
    }
}
