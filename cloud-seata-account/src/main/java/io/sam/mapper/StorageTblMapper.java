package io.sam.mapper;

import io.sam.domain.StorageTbl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageTbl record);

    int insertSelective(StorageTbl record);

    StorageTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageTbl record);

    int updateByPrimaryKey(StorageTbl record);
}