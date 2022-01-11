package io.sam.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author zhuweimu
 * @description
 * @date 2021/9/6 9:36
 */
@Slf4j
@Service
public class RetryTestService {

    @Retryable
    public String getUser(Integer id) throws Exception {
        log.info("获取人员:id = {}",id);
        if (id == 0) {
            throw new Exception("");
        }
        return "";
    }
}
