package io.sam.mapper;

import io.sam.domain.OrderTbl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTbl record);

    int insertSelective(OrderTbl record);

    OrderTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTbl record);

    int updateByPrimaryKey(OrderTbl record);
}