package io.sam.service;

import io.sam.BaseTest;
import io.sam.db.domain.Order;
import io.sam.db.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author zhuweimu
 * @classname SharingJdbcTest
 * @description
 * @date 2020/11/13 15:51
 */
public class SharingJdbcTest extends BaseTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testInsert() {
        for (int i=1;i<11;i++){
            Order order = new Order();
            order.setId(i);
            order.setName("order"+i);
            order.setAmount("10");
            order.setMoney("10");
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            orderService.insert(order);
        }
    }
}
