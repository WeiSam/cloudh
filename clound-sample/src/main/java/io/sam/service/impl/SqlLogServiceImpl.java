package io.sam.service.impl;

import io.sam.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @classname SqlLogServiceImpl
 * @description
 * @date 2020/9/21 9:48
 */
@Service
@Slf4j
public abstract class SqlLogServiceImpl implements LogService {

    /**
     * 单例内有多例
     */
    PrototypeServiceImpl prototypeService;

    @Override
    public void print() {
        prototypeService = getPrototypeService();
        log.info("prototypeService.hashCode = {}",prototypeService.hashCode());
        log.info("sql日志输出");
    }

    /**
     * @Lookup 每次创建多例
     * @return
     */
    @Lookup
    public abstract PrototypeServiceImpl getPrototypeService();
}
