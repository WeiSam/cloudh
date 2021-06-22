package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname SpringUtilsTest
 * @description
 * @date 2020/10/20 13:42
 */
@Slf4j
public class SpringUtilsTest {

    @Test
    public void testAnnotationConfigUtils(){
//        AnnotationConfigUtils.attributesFor(null, Scope.class);

    }

    @Test
    public void testPropertyAccessorFactory() {
        UserDto userDto = new UserDto();
        userDto.setName("sam");
        userDto.setAge(0);
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(userDto);
        System.out.println(JSON.toJSONString(beanWrapper));
    }

    @Test
    public void beanMap() {
        UserDto userDto = new UserDto();
        userDto.setName("sam");
        userDto.setAge(0);
        Map<String,Object> map = BeanMap.create(userDto);
        Map<String, Object> toMap = beanToMap(userDto,false);
        System.out.println(toMap);
    }

    /**
     * bean转Map
     * @param bean
     * @param ignoreNullValue 是否忽略null值
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean,boolean ignoreNullValue) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                Object value = beanMap.get(key);
                if (ignoreNullValue && value == null) {
                    continue;
                }
                map.put(key + "", value);
            }
        }
        return map;
    }

    /**
     * bean转Map 忽略null值字段
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        return beanToMap(bean,true);
    }

    @Test
    public void testSpringFactoriesLoader() {
        List<String> names = SpringFactoriesLoader
                .loadFactoryNames(EnableAutoConfiguration.class, Thread.currentThread().getContextClassLoader());
        List<EnableAutoConfiguration> factories = SpringFactoriesLoader.loadFactories(EnableAutoConfiguration.class, Thread.currentThread().getContextClassLoader());
        log.info("EnableAutoConfiguration = {}",names);
        log.info("{}",names.contains("io.sam.config.RedissonAutoConfig"));

    }

    @Test
    public void testAutoConfigurationMetadataLoader() {
    }
}
