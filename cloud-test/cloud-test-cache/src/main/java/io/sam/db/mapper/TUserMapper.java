package io.sam.db.mapper;

import io.sam.db.domain.TUser;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 12:37
 */
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}