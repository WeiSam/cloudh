package io.sam.strategy.service.impl;

import io.sam.strategy.service.PayService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhuweimu
 * @classname WCPayServiceImpl
 * @description
 * @date 2020/10/3 16:42
 */
@Slf4j
public class WCPayServiceImpl implements PayService {
    @Override
    public String pay() {
        log.info("微信支付");
        return "微信支付方式";
    }
}
