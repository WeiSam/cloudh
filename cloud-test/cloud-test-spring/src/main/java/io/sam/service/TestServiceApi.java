package io.sam.service;

import io.sam.bean.UserBean;
import io.sam.dto.ro.UserInfoRo;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/21 10:22
 */
public class TestServiceApi implements TestApi{
    @Override
    public UserBean getUserBean(UserInfoRo userInfoRo) {
        return new UserBean().setName("sam").setAge(18);
    }
}
