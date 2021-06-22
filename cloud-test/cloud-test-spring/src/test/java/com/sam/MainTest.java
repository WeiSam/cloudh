package com.sam;

import com.alibaba.fastjson.JSON;
import io.sam.bean.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 16:19
 */
@Slf4j
public class MainTest {

    @Test
    public void name() {
        log.info(JSON.toJSONString(new UserBean()));
    }
}
