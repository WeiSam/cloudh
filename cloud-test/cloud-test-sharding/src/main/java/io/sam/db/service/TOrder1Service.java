package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.TOrder1Mapper;
import io.sam.db.domain.TOrder1;
/**
 * @classname TOrder1Service
 * @description 
 * @date 2020/11/20 15:52
 * @author zhuweimu
 */
@Service
public class TOrder1Service{

    @Resource
    private TOrder1Mapper tOrder1Mapper;

    
    public int deleteByPrimaryKey(String id) {
        return tOrder1Mapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TOrder1 record) {
        return tOrder1Mapper.insert(record);
    }

    
    public int insertSelective(TOrder1 record) {
        return tOrder1Mapper.insertSelective(record);
    }

    
    public TOrder1 selectByPrimaryKey(String id) {
        return tOrder1Mapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TOrder1 record) {
        return tOrder1Mapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(TOrder1 record) {
        return tOrder1Mapper.updateByPrimaryKey(record);
    }

}
