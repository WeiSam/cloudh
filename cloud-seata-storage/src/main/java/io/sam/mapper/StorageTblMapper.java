package io.sam.mapper;

import io.sam.domain.StorageTbl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageTbl record);

    int insertSelective(StorageTbl record);

    StorageTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageTbl record);

    int updateByPrimaryKey(StorageTbl record);

    void deduct(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}