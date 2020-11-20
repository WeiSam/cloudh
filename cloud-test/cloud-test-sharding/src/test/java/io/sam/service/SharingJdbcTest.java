package io.sam.service;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.db.domain.Order;
import io.sam.db.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author zhuweimu
 * @classname SharingJdbcTest
 * @description
 * @date 2020/11/13 15:51
 */
@Slf4j
public class SharingJdbcTest extends BaseTest {

    @Autowired
    OrderService orderService;

    @Test
    public void testInsert() {
        for (int i=1;i<11;i++){
            Order order = new Order();
            order.setName("order"+i);
            order.setAmount("10");
            order.setMoney("10");
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            orderService.insert(order);
        }
    }

    @Test
    public void testSelect() {
        Order order = orderService.selectByPrimaryKey("536506096894869505");
        log.info("{}", JSON.toJSONString(order));
    }
}
