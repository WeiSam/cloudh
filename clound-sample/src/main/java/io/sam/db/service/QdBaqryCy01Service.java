package io.sam.db.service;

import io.sam.db.domain.QdBaqryCy01;
import io.sam.db.mapper.QdBaqryCy01Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhuweimu
 * @classname QdBaqryCy01Service
 * @description
 * @date 2020/11/5 15:00
 */
@Service
public class QdBaqryCy01Service {

    @Resource
    private QdBaqryCy01Mapper qdBaqryCy01Mapper;


    public int insert(QdBaqryCy01 record) {
        return qdBaqryCy01Mapper.insert(record);
    }


    public int insertSelective(QdBaqryCy01 record) {
        return qdBaqryCy01Mapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(String rybh) {
        return qdBaqryCy01Mapper.deleteByPrimaryKey(rybh);
    }

    public QdBaqryCy01 selectByPrimaryKey(String rybh) {
        return qdBaqryCy01Mapper.selectByPrimaryKey(rybh);
    }

    public int updateByPrimaryKeySelective(QdBaqryCy01 record) {
        return qdBaqryCy01Mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(QdBaqryCy01 record) {
        return qdBaqryCy01Mapper.updateByPrimaryKey(record);
    }
}




