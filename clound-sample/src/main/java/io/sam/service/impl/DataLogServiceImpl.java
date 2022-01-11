package io.sam.service.impl;

import io.sam.service.BridgedMethodServiceTest;
import io.sam.service.LogService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname DataLogServiceImpl
 * @description
 * @date 2020/9/21 9:50
 */
@Slf4j
public class DataLogServiceImpl implements  BridgedMethodServiceTest<String>,LogService {
    @Override
    public void print() {
        log.info("服务数据日志输出");
    }

    @Override
    public void print(String data) {
        log.info("服务数据日志输出:{}",data);
    }
}
