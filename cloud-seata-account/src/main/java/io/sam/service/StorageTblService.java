package io.sam.service;

import io.sam.domain.StorageTbl;
import io.sam.mapper.StorageTblMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StorageTblService{

    @Resource
    private StorageTblMapper storageTblMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return storageTblMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(StorageTbl record) {
        return storageTblMapper.insert(record);
    }

    
    public int insertSelective(StorageTbl record) {
        return storageTblMapper.insertSelective(record);
    }

    
    public StorageTbl selectByPrimaryKey(Integer id) {
        return storageTblMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(StorageTbl record) {
        return storageTblMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(StorageTbl record) {
        return storageTblMapper.updateByPrimaryKey(record);
    }

}
