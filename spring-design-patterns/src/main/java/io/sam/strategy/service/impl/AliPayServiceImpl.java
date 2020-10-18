package io.sam.strategy.service.impl;

import io.sam.strategy.service.PayService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname AliPayServiceImpl
 * @description
 * @date 2020/10/3 16:47
 */
@Slf4j
public class AliPayServiceImpl implements PayService {
    @Override
    public String pay() {
        log.info("支付宝支付");
        return "支付宝支付";
    }
}
