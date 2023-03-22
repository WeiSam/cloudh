package io.sam.service.impl;

import io.sam.db.domain.TUser;
import io.sam.db.mapper.TUserMapper;
import model.UserInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuweimu
 * @desc
 * @date 2022/3/6 11:11
 */
@DubboService
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper tUserMapper;


    @Override
    public List<UserInfo> getUserInfo() {
        List<TUser> tUsers = tUserMapper.selectAll();
        return tUsers.stream().map(user -> {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(user,userInfo);
            return userInfo;
        }).collect(Collectors.toList());
    }

    @Override
    public UserInfo getUserInfoById(Integer id) {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(tUser,userInfo);
        return userInfo;
    }

    @Override
    public UserInfo getUserInfoByAge(Integer age) {
        List<TUser> userInfoByAge = tUserMapper.getUserInfoByAge(age);
        return new UserInfo();
    }
}
