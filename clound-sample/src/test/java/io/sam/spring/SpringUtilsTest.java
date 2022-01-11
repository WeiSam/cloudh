package io.sam.spring;

import com.alibaba.fastjson.JSON;
import io.sam.config.AutoConfig;
import io.sam.dto.UserDto;
import io.sam.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
        ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        log.info("{}",defaultClassLoader == contextClassLoader);
        List<String> names = SpringFactoriesLoader
                .loadFactoryNames(EnableAutoConfiguration.class, contextClassLoader);
        log.info("EnableAutoConfiguration = {}",names);
        log.info("{}",names.contains("io.sam.config.RedissonAutoConfig"));

        List<LogService> logServices = SpringFactoriesLoader.loadFactories(LogService.class, contextClassLoader);
        log.info("{}",logServices.size());

    }

    @Test
    public void testAutoConfigurationMetadataLoader() {
    }

    @Test
    public void testClassPathResource() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.yml");
        System.out.println(classPathResource.getPath());
        //获取yml配置有问题
        Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);

        System.out.println(properties.getProperty("test.name"));

        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(AutoConfig.class);
        System.out.println(annotationMetadata.getClassName());
        annotationMetadata.getAnnotationTypes().stream().forEach(System.out::println);
//        ConditionEvaluator conditionEvaluator = new ConditionEvaluator(registry, environment, resourceLoader);
    }

    @Test
    public void testResuore() {
        try (InputStream in = ResourceUtils.getURL("classpath:application.yml").openStream()) {
            Properties properties = new Properties();
            properties.load(in);
            String value = properties.getProperty("test.name");
            
        } catch (Exception e) {
            log.error("",e);
        }
    }
}
