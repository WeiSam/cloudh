package io.sam.service.impl;

import io.sam.service.LogService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname SqlLogServiceImpl
 * @description
 * @date 2020/9/21 9:48
 */
@Slf4j
public class SqlLogServiceImpl implements LogService {
    @Override
    public void print() {
        log.info("sql日志输出");
    }
}
