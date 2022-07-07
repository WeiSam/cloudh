package io.sam.service;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/22 15:23
 */
public interface StaticService02 {

    int CODE = StaticService02.getCode();
    StaticService02 SERVICE_02 = null;

    static int getCode() {
        System.out.println("StaticService02初始化");
        return 2;
    }
}
