package io.sam.config;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhuweimu
 * @description
 * @date 2021/5/14 17:45
 */
public class FactoryBeanRegistrarTest implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //bean定义对象构造器,使用工厂bean创建
        BeanDefinitionBuilder definition = BeanDefinitionBuilder
                .genericBeanDefinition(FactoryBeanTest.class);
        //创建bean定义对象
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
        //构造函数
        beanDefinition.getConstructorArgumentValues()
                .addGenericArgumentValue("测试构造函数");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(100);
        //注册bean定义
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "factoryBeanTest");
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
    }
}
