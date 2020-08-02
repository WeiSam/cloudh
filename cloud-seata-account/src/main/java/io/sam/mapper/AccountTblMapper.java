package io.sam.mapper;

import io.sam.domain.AccountTbl;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTbl record);

    int insertSelective(AccountTbl record);

    AccountTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountTbl record);

    int updateByPrimaryKey(AccountTbl record);
}