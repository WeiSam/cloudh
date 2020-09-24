package io.sam.service;

import io.sam.domain.OrderTbl;
import io.sam.feign.UserFeignClient;
import io.sam.mapper.OrderTblMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OrderTblService{

    @Resource
    private OrderTblMapper orderTblMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return orderTblMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(OrderTbl record) {
        return orderTblMapper.insert(record);
    }

    
    public int insertSelective(OrderTbl record) {
        return orderTblMapper.insertSelective(record);
    }

    
    public OrderTbl selectByPrimaryKey(Integer id) {
        return orderTblMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(OrderTbl record) {
        return orderTblMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(OrderTbl record) {
        return orderTblMapper.updateByPrimaryKey(record);
    }


    @Autowired
    UserFeignClient userFeignClient;

    public void create(String userId, String commodityCode, Integer count) {
        Integer orderMoney = 100 * count;
        //创建订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(orderMoney);
        this.insert(orderTbl);
        //扣减金额
        userFeignClient.reduce(userId, orderMoney);
    }
}
