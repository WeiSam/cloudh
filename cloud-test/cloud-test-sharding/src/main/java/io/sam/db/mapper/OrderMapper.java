package io.sam.db.mapper;

import io.sam.db.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @classname OrderMapper
 * @description 
 * @date 2020/11/13 15:11
 * @author zhuweimu
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}