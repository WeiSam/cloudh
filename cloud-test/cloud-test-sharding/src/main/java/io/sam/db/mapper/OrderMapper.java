package io.sam.db.mapper;

import io.sam.db.domain.Order;

import java.util.List;

/**
 * @author zhuweimu
 * @classname OrderMapper
 * @description
 * @date 2020/11/24 10:30
 */
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectAll();

    List<Order> selectByName(String name);
}