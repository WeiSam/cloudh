package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.domain.Userinfo;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/20 17:20
 */
@Service
public class UserinfoService {

    @Resource
    private UserinfoMapper userinfoMapper;


    public int deleteByPrimaryKey(Integer id) {
        return userinfoMapper.deleteByPrimaryKey(id);
    }


    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }


    public int insertSelective(Userinfo record) {
        return userinfoMapper.insertSelective(record);
    }


    public Userinfo selectByPrimaryKey(Integer id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Userinfo record) {
        return userinfoMapper.updateByPrimaryKey(record);
    }

}



