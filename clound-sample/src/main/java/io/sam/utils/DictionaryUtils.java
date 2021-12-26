package io.sam.utils;


import java.lang.reflect.Field;

/**
 * @author zhuweimu
 * @classname DictionaryUtils
 * @description
 * @date 2021/2/2 16:01
 */
public class DictionaryUtils {


    /**
     * 获取指定规则的字典配置
     * @param p
     * @return
     * @throws Exception
     */
    public static <P extends BaseDicConfig> P getDicFieldValue(P p) throws Exception {
        Field[] fields = p.getClass().getFields();
        //获取字典配置值
        for (Field field : fields) {
            //是否字典属性，配置类决定
            if (p.isDicField(field)) {
                //获取静态变量的值
                String key = (String) field.get(p);
                //从redis缓存获取值
                String dicValueFromTransfer = "";
                p.putValue(key,dicValueFromTransfer);
            }
        }
        return p;
    }

}
