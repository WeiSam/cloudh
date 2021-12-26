package io.sam.service;

import io.sam.bean.UserBean;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/26 10:35
 */
public class AService extends AbstractService<UserBean>{

    @Override
    public UserBean getT() {
        return new UserBean();
    }

    public void getB(){

    }
}
