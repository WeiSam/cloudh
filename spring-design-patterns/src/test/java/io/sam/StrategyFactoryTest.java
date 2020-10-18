package io.sam;

import io.sam.strategy.factory.PayServiceFactory;
import io.sam.strategy.service.impl.OrderPay;
import org.junit.Test;

/**
 * @author zhuweimu
 * @classname StrategyFactoryTest
 * @description 工厂+策略模式
 * @date 2020/10/3 17:05
 */
public class StrategyFactoryTest {

    @Test
    public void testStrategyFactory(){
        OrderPay orderPay = new OrderPay(PayServiceFactory.getPayService(PayServiceFactory.ALI_PAY));
        orderPay.pay();
    }
}
