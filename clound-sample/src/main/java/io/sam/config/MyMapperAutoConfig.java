package io.sam.config;

import io.sam.annotation.EnableMyMapper;
import io.sam.annotation.MyMapper;
import io.sam.dto.UserDto;
import io.sam.mymapper.ClassPathMyMapperScanner;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname AutoConfigMyMapper
 * @description
 * @date 2020/10/28 14:16
 */
@Slf4j
@Data
@Import(MyMapperAutoConfig.MyMapperScannerRegistrar.class)
public class MyMapperAutoConfig implements ImportBeanDefinitionRegistrar{

    @Value("${test.name}")
    private String name;

    ResourceLoader resourceLoader;

    public MyMapperAutoConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String className = importingClassMetadata.getClassName();
        MergedAnnotations annotations = importingClassMetadata.getAnnotations();
        MergedAnnotation<EnableMyMapper> enableMyMapperMergedAnnotation = annotations.get(EnableMyMapper.class);
        Map<String, Object> packages = importingClassMetadata.getAnnotationAttributes("EnableMyMapper");
        String string = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes("EnableMyMapper"))
                .getString("packages");
        log.info("");
    }

    public static class MyMapperScannerRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware, ResourceLoaderAware {

        private BeanFactory beanFactory;

        private ResourceLoader resourceLoader;

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                            BeanDefinitionRegistry registry) {
            log.info("导入bean定义");
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(UserDto.class);
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            propertyValues.addPropertyValue("age","18");
            beanDefinition.setPropertyValues(propertyValues);
            //设置bean定义回调方法初始化创建bean对象
            beanDefinition.setInstanceSupplier(() -> {return new UserDto().setName("userDtoInstanceSupplier");});
//            beanDefinition.setAttribute("age","18");
            registry.registerBeanDefinition("userDtoInstanceSupplier",beanDefinition);

//            List<String> packages = AutoConfigurationPackages.get(this.beanFactory);

            List<String> packages = new ArrayList<>();
            packages.add("io.sam.service");
            ClassPathMyMapperScanner scanner = new ClassPathMyMapperScanner(registry);
            if (this.resourceLoader != null) {
                scanner.setResourceLoader(this.resourceLoader);
            }
            scanner.setAnnotationClass(MyMapper.class);
            scanner.registerFilters();
            scanner.doScan(StringUtils.toStringArray(packages));

        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.beanFactory = beanFactory;
        }

        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }
    }
}
