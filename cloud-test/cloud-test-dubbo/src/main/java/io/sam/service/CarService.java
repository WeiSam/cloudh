package io.sam.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author zhuweimu
 * @classname CarService
 * @description
 * @date 2021/1/14 14:13
 */
@SPI
public interface CarService {

    public String name();
}
