package com.mapper;

import com.domain.PmcontrolsPersonCheck;

/**
 * @Classname PmcontrolsPersonCheckMapper
 * @Description TODO
 * @Date 2020/7/22 13:55
 * @Auther by zhuweimu
 */
public interface PmcontrolsPersonCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PmcontrolsPersonCheck record);

    int insertSelective(PmcontrolsPersonCheck record);

    PmcontrolsPersonCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmcontrolsPersonCheck record);

    int updateByPrimaryKey(PmcontrolsPersonCheck record);
}