package io.sam.service;

import io.sam.bean.UserBean;
import io.sam.dto.ro.UserInfoRo;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/21 10:16
 */
public interface TestApi {

    UserBean getUserBean(UserInfoRo userInfoRo);
}
