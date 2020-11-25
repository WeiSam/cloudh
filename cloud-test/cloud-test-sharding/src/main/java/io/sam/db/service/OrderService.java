package io.sam.db.service;

import io.sam.db.domain.Order;
import io.sam.db.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @classname OrderService
 * @description
 * @date 2020/11/13 15:11
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public int insert(Order record) {
        return orderMapper.insert(record);
    }


    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }


    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }
}



