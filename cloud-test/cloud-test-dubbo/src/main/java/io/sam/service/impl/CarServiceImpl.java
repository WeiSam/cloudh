package io.sam.service.impl;

import io.sam.service.CarService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname CarServiceImpl
 * @description
 * @date 2021/1/14 14:09
 */
@Slf4j
public class CarServiceImpl implements CarService {
    @Override
    public String name() {
        log.info("class:{}",this.getClass().getName());
        return this.getClass().getName();
    }
}
