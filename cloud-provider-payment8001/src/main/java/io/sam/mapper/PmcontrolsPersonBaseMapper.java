package io.sam.mapper;

import io.sam.domain.PmcontrolsPersonBase;

/**
 * @Classname PmcontrolsPersonBaseMapper
 * @Description TODO
 * @Date 2020/7/22 11:13
 * @Auther by zhuweimu
 */
public interface PmcontrolsPersonBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmcontrolsPersonBase record);

    int insertSelective(PmcontrolsPersonBase record);

    PmcontrolsPersonBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmcontrolsPersonBase record);

    int updateByPrimaryKey(PmcontrolsPersonBase record);
}