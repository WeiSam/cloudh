package io.sam.service;

import io.sam.feign.OrderFeignClient;
import io.sam.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 16:33
 * @Description:
 */
@Service
public class BusinessService {

    @Autowired
    private StorageFeignClient storageFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageFeignClient.deduct(commodityCode, orderCount);
        orderFeignClient.create(userId, commodityCode, orderCount);
        if (orderCount > 30) {
            throw new RuntimeException("账户或库存不足,执行回滚");
        }
    }
}
