package io.sam.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import io.sam.db.mapper.TUserMapper;
import io.sam.db.domain.TUser;

/**
 * @author zhuweimu
 * @description
 * @date 2023/4/10 11:24
 */
@Service
public class TUserService {

    @Autowired
    TUserMapper tUserMapper;

    public int deleteByPrimaryKey(Integer id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    public int insert(TUser record) {
        return tUserMapper.insert(record);
    }

    public int insertSelective(TUser record) {
        return tUserMapper.insertSelective(record);
    }

    public TUser selectByPrimaryKey(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TUser record) {
        return tUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TUser record) {
        return tUserMapper.updateByPrimaryKey(record);
    }
}

