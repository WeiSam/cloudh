package io.sam.service;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/22 15:23
 */
public interface StaticService {

    int CODE = StaticService.getCode();

    int CODE1 = 19;


    static int getCode() {
        System.out.println("StaticService初始化");
        return 1;
    }

    static int getCode02() {
        return 100;
    }
}
