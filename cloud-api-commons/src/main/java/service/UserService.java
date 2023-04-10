package service;

import model.UserInfo;

import java.util.List;

/**
 * @author zhuweimu
 * @desc
 * @date 2022/3/6 11:10
 */
public interface UserService {

    List<UserInfo> getUserInfo();

    UserInfo getUserInfoById(Integer id);

    UserInfo getUserInfoByAge(Integer age);
}
