package io.sam.db.mapper;

import io.sam.db.domain.TOrder1;

/**
 * @classname TOrder1Mapper
 * @description 
 * @date 2020/11/20 15:52
 * @author zhuweimu
 */
public interface TOrder1Mapper {
    int deleteByPrimaryKey(String id);

    int insert(TOrder1 record);

    int insertSelective(TOrder1 record);

    TOrder1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TOrder1 record);

    int updateByPrimaryKey(TOrder1 record);
}