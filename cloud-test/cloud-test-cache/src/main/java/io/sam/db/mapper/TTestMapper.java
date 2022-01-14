package io.sam.db.mapper;

import io.sam.db.domain.TTest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @desc 
 * @date 2021/8/29 21:28
 * @author zhuweimu
 */
@Mapper
public interface TTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TTest record);

    int insertSelective(TTest record);

    TTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TTest record);

    int updateByPrimaryKey(TTest record);
}