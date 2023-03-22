package com.sam.reactive;

import com.alibaba.fastjson.JSON;
import io.sam.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuweimu
 * @description
 * @date 2022/2/17 17:07
 */
@Slf4j
public class MonoTest {

    @Test
    public void testMono() {
        log.info("开始");
        final String[] name = new String[1];
        System.out.println(getMono().subscribe(userBean -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            name[0] =userBean.getName();
        }));
        log.info("异步开始,name = {}",name[0]);
    }

    private Mono<UserBean> getMono(){
        return Mono.just(new UserBean().setName("ddddd").setAge(123));
    }
}
