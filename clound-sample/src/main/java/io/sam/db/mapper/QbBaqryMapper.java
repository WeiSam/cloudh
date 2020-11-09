package io.sam.db.mapper;

import io.sam.db.domain.QbBaqry;

/**
 * @classname QbBaqryMapper
 * @description 
 * @date 2020/11/5 15:12
 * @author zhuweimu
 */
public interface QbBaqryMapper {
    int insert(QbBaqry record);

    int insertSelective(QbBaqry record);
}