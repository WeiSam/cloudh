package io.sam.queue;

import io.sam.config.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/15 9:26
 */
@Component
public class InitNonSenseQueue implements ApplicationRunner {

    @Autowired
    SysConfig sysConfig;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        NonSenseRequestWorkerPool.init(sysConfig);
    }
}
