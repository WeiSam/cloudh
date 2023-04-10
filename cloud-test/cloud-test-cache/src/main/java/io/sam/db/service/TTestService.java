package io.sam.db.service;

import io.sam.db.domain.TTest;
import io.sam.db.mapper.TTestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @desc 
 * @date 2021/8/29 21:28
 * @author zhuweimu
 */
@Service
public class TTestService {

    @Resource
    private TTestMapper tTestMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return tTestMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TTest record) {
        return tTestMapper.insert(record);
    }

    
    public int insertSelective(TTest record) {
        return tTestMapper.insertSelective(record);
    }

    
    public TTest selectByPrimaryKey(Integer id) {
        return tTestMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TTest record) {
        return tTestMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TTest record) {
        return tTestMapper.updateByPrimaryKey(record);
    }

}
