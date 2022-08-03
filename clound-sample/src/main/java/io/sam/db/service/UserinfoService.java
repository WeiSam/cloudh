package io.sam.db.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import io.sam.db.mapper.UserinfoMapper;
import io.sam.db.domain.Userinfo;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public void addAndUpdate() throws Exception {
        Userinfo userinfo = new Userinfo();
        userinfo.setName("yyuyeh");
        userinfo.setAge(178);
        userinfoMapper.insertSelective(userinfo);
        update(userinfo);
    }
    public void update(Userinfo userinfo) throws Exception {
        userinfo.setName("更新"+userinfo.getName());
        userinfoMapper.updateByPrimaryKey(userinfo);
        if (true){
            throw new Exception("");
        }
    }

}



