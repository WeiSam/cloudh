package io.sam.db.mapper;

import io.sam.db.domain.InterfaceLog;

/**
 * @classname InterfaceLogMapper
 * @description 
 * @date 2020/11/5 15:09
 * @author zhuweimu
 */
public interface InterfaceLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InterfaceLog record);

    int insertSelective(InterfaceLog record);

    InterfaceLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InterfaceLog record);

    int updateByPrimaryKey(InterfaceLog record);
}