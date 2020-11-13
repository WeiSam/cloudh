package io.sam.strategy;

import io.sam.strategy.factory.PayServiceFactory;
import io.sam.strategy.service.PayService;

/**
 * @author zhuweimu
 * @classname StrategyFactory
 * @description
 * @date 2020/10/3 16:34
 */
public class StrategyFactoryTest {

    /**
     * 策略+工厂模式
     * @param args
     */
    public static void main(String[] args) {
        PayService payService = PayServiceFactory.getPayService(PayServiceFactory.ALI_PAY);
    }
}
