package io.sam.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.domain.AccountTbl;
import io.sam.mapper.AccountTblMapper;
@Service
public class AccountTblService{

    @Resource
    private AccountTblMapper accountTblMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return accountTblMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(AccountTbl record) {
        return accountTblMapper.insert(record);
    }

    
    public int insertSelective(AccountTbl record) {
        return accountTblMapper.insertSelective(record);
    }

    
    public AccountTbl selectByPrimaryKey(Integer id) {
        return accountTblMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(AccountTbl record) {
        return accountTblMapper.updateByPrimaryKey(record);
    }

}
