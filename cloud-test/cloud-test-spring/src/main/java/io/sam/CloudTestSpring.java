package io.sam;

import io.sam.config.TestImportConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: zhuweimu
 * @Date: 2020/11/8 12:46
 * @Description:
 *
 * exposeProxy = true 保存当前代理对象到当前进程,
 * 使用AopContext.currentProxy()获取,为了解决:a方法调b方法,b也能用上代理
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
@EnableScheduling
@SpringBootApplication
@Import(TestImportConfig.class)
public class CloudTestSpring implements ApplicationRunner, CommandLineRunner, DisposableBean {

    public static void main(String[] args) {
        SpringApplication.run(CloudTestSpring.class,args);
        log.info("CloudTestSpring服务启动成功");
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("ApplicationRunner启动完成");
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner启动完成");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        log.info("服务关闭");
    }
}
