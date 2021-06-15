package io.sam.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.sam.BaseTest;
import io.sam.db.domain.Order;
import io.sam.db.mapper.OrderMapper;
import io.sam.db.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert() {
        for (int i=1;i<11;i++){
            Order order = new Order();
            order.setName("order"+i);
            order.setAmount("10");
            order.setMoney("10");
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            orderService.insertSelective(order);
        }
    }

    @Test
    public void testSelect() {
        List<Order> orders = orderMapper.selectByName("order3");
        log.info("{}", orders.size());
    }

    @Test
    public void selectAll() {
        for (int i = 0;i<10;i++){
            PageHelper.startPage(i,2).setOrderBy("name");
            List<Order> orders = orderMapper.selectAll();
            PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
            System.out.println(orderPageInfo.getTotal());
            System.out.println(orderPageInfo.getList());
        }
    }

    @Test
    public void testUpdate() {
        Order order = new Order();
        order.setId(536506096894869505L);
        order.setName("order100");
        order.setAmount("100");
        orderService.updateByPrimaryKeySelective(order);
    }

}
