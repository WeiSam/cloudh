package io.sam.processor;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author zhuweimu
 * @classname TestBeanPostProcessor
 * @description
 * @date 2021/3/22 11:13
 */
public class ScheduleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(bean);
        boolean candidateClass = AnnotationUtils.isCandidateClass(targetClass, Scheduled.class);
        return bean;
    }
}
