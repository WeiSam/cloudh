package com.sam.spring;

import io.sam.task.TestTask01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuweimu
 * @classname AnnotationUtilsTest
 * @description
 * @date 2021/3/22 11:03
 */
@Slf4j
public class AnnotationUtilsTest {

    @Test
    public void test(){
        Class targetClass = TestTask01.class;
        //判断指定类是否可以被指定注解标注
        boolean candidateClass = AnnotationUtils.isCandidateClass(targetClass, Test.class);
        Map<Method, Set<Scheduled>> annotatedMethods = null;
        if (candidateClass) {
            annotatedMethods = MethodIntrospector.selectMethods(targetClass,
                    (MethodIntrospector.MetadataLookup<Set<Scheduled>>) method -> {
                        Set<Scheduled> scheduledMethods = AnnotatedElementUtils.getMergedRepeatableAnnotations(
                                method, Scheduled.class, Schedules.class);
                        return (!scheduledMethods.isEmpty() ? scheduledMethods : null);
                    });
        }
        log.info("candidateClass:{}",candidateClass);
    }
}
