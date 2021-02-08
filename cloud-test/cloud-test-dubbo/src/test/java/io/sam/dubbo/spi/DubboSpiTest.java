package io.sam.dubbo.spi;

import io.sam.service.CarService;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.junit.Test;
import service.PaymentService;

/**
 * @author zhuweimu
 * @classname DubboSpiTest
 * @description
 * @date 2021/1/14 14:04
 */
public class DubboSpiTest {


    @Test
    public void testDubboSPI() {
        ExtensionLoader<CarService> extensionLoader = ExtensionLoader.getExtensionLoader(CarService.class);
        CarService car1 = extensionLoader.getExtension("car1");
        car1.name();

        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
    }


    @Test
    public void testReferenceConfig() {
        ReferenceConfig<PaymentService> reference = new ReferenceConfig<PaymentService>();
        reference.setInterface(PaymentService.class);
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setClient("test");
        consumerConfig.setVersion("01");
        consumerConfig.setGroup("5555");
//        consumerConfig.setRegistry();
        reference.setConsumer(consumerConfig);
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        reference.setRegistry(registryConfig);


        reference.setProtocol("127.0.0.1:1999");
        reference.setRetries(0);

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("test");
        reference.setApplication(applicationConfig);
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        PaymentService paymentService = cache.get(reference);
        System.out.println(paymentService.getPaymentById(1L));
    }
}
