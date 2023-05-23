package io.sam.utils;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Editor;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/10 16:54
 */
public class SamBeanUtils {

    /**
     * 对象转Map<br>
     * 通过实现{@link Editor} 可以自定义字段值，如果这个Editor返回null则忽略这个字段，以便实现：
     *
     * <pre>
     * 1. 字段筛选，可以去除不需要的字段
     * 2. 字段变换，例如实现驼峰转下划线
     * 3. 自定义字段前缀或后缀等等
     * </pre>
     *
     * @param bean            bean对象
     * @param targetMap       目标的Map
     * @param ignoreNullValue 是否忽略值为空的字段
     * @param valueEditor       属性字段（Map的value）编辑器，用于筛选、编辑value
     * @return Map
     * @since 4.0.5
     */
    /*public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, boolean ignoreNullValue, Editor<Object> valueEditor) {
        if (bean == null) {
            return null;
        }

        final Collection<BeanDesc.PropDesc> props = BeanUtil.getBeanDesc(bean.getClass()).getProps();

        String key;
        Method getter;
        Object value;
        for (BeanDesc.PropDesc prop : props) {
            key = prop.getFieldName();
            // 过滤class属性
            // 得到property对应的getter方法
            getter = prop.getGetter();
            if (null != getter) {
                // 只读取有getter方法的属性
                try {
                    value = getter.invoke(bean);
                } catch (Exception ignore) {
                    continue;
                }
                if (false == ignoreNullValue || (null != value && false == value.equals(bean))) {
                    if (null != key) {
                        targetMap.put(key, valueEditor == null?value:valueEditor.edit(value));
                    }
                }
            }
        }
        return targetMap;
    }*/

}
