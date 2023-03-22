package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import model.OrderInfo;
import model.Payment;
import org.apache.dubbo.config.annotation.DubboService;
import service.OrderService;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @description
 * @date 2022/1/19 15:02
 */
@Slf4j
@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderInfo getOrder(Long seconds) {
        log.info("OrderServiceImpl.getOrder被调用");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return OrderInfo.builder().id(seconds).name("order").build();
    }
}
