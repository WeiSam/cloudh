package io.sam.controller;

import io.sam.domain.OrderTbl;
import io.sam.mapper.OrderTblMapper;
import io.sam.service.OrderTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhuweimu
 * @Date: 2020/8/2 15:04
 * @Description:
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderTblMapper orderTblMapper;

    @Autowired
    OrderTblService orderService;

    @GetMapping("getOrder/{orderId}")
    public OrderTbl getOrder(@PathVariable Integer orderId){
        return orderTblMapper.selectByPrimaryKey(orderId);
    }

    @GetMapping(value = "/create", produces = "application/json")
    public Boolean create(String userId, String commodityCode, Integer count) {
        orderService.create(userId, commodityCode, count);
        return true;
    }
}
