package io.sam.strategy.factory;

import io.sam.strategy.service.PayService;
import io.sam.strategy.service.impl.AliPayServiceImpl;
import io.sam.strategy.service.impl.JdPayServiceImpl;
import io.sam.strategy.service.impl.WCPayServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname PayServiceFactory
 * @description
 * @date 2020/10/3 16:49
 */
@Slf4j
public class PayServiceFactory {

    public static String WC_PAY = "WC_PAY";
    public static String JD_PAY = "JD_PAY";
    public static String ALI_PAY = "ALI_PAY";
    public final static Map<String, PayService> PAY_MAP = new HashMap<>();

    static {
        PAY_MAP.put(PayServiceFactory.ALI_PAY,new AliPayServiceImpl());
        PAY_MAP.put(PayServiceFactory.JD_PAY,new JdPayServiceImpl());
        PAY_MAP.put(PayServiceFactory.WC_PAY,new WCPayServiceImpl());
        log.info("支付方式初始化成功");
    }

    public static PayService getPayService(String payWay){
        return PAY_MAP.get(payWay);
    }
}
