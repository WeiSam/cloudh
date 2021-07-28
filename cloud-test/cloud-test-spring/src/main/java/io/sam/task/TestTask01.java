package io.sam.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.TaskManagementConfigUtils;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author zhuweimu
 * @classname TestTask01
 * @description
 * @date 2021/3/16 16:53
 */
@Component
public class TestTask01 extends TestTask implements ApplicationContextAware {

    Logger logger = LoggerFactory.getLogger(TestTask01.class);

    ApplicationContext applicationContext;

    private static Integer count = 0;

    @Override
    public void run() throws Exception {
        logger.info("开始执行,threadName = {},count = {}",Thread.currentThread().getName(),count++);
        if (count > 10) {
            TestTask01 testTask01 = (TestTask01) applicationContext.getBean("testTask01");
            ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor = (ScheduledAnnotationBeanPostProcessor) applicationContext
                    .getBean(TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME);
            Set<ScheduledTask> scheduledTasks = scheduledAnnotationBeanPostProcessor.getScheduledTasks();
            scheduledAnnotationBeanPostProcessor.postProcessBeforeDestruction(testTask01,"testTask01");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
