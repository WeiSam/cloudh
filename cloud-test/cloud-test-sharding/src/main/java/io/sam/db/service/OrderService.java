package io.sam.db.service;

import io.sam.db.domain.Order;
import io.sam.db.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @classname OrderService
 * @description 
 * @date 2020/11/13 15:11
 * @author zhuweimu
 */
@Service
public class OrderService{

    @Resource
    private OrderMapper orderMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

}