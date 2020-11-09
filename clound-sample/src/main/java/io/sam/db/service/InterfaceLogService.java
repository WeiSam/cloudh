package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.domain.InterfaceLog;
import io.sam.db.mapper.InterfaceLogMapper;
/**
 * @classname InterfaceLogService
 * @description 
 * @date 2020/11/5 15:09
 * @author zhuweimu
 */
@Service
public class InterfaceLogService{

    @Resource
    private InterfaceLogMapper interfaceLogMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return interfaceLogMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(InterfaceLog record) {
        return interfaceLogMapper.insert(record);
    }

    
    public int insertSelective(InterfaceLog record) {
        return interfaceLogMapper.insertSelective(record);
    }

    
    public InterfaceLog selectByPrimaryKey(Long id) {
        return interfaceLogMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(InterfaceLog record) {
        return interfaceLogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(InterfaceLog record) {
        return interfaceLogMapper.updateByPrimaryKey(record);
    }

}
