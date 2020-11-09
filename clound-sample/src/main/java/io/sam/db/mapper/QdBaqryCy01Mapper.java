package io.sam.db.mapper;

import io.sam.db.domain.QdBaqryCy01;

/**
 * @classname QdBaqryCy01Mapper
 * @description 
 * @date 2020/11/5 15:17
 * @author zhuweimu
 */
public interface QdBaqryCy01Mapper {
    int deleteByPrimaryKey(String rybh);

    int insert(QdBaqryCy01 record);

    int insertSelective(QdBaqryCy01 record);

    QdBaqryCy01 selectByPrimaryKey(String rybh);

    int updateByPrimaryKeySelective(QdBaqryCy01 record);

    int updateByPrimaryKey(QdBaqryCy01 record);
}