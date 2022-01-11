package io.sam.controller;

import common.BaseResponse;
import io.sam.bean.UserBean;
import io.sam.queue.NonSenseReceiveRo;
import io.sam.queue.QueueRequestAsyncService;
import io.sam.queue.impl.NonSenseMatchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/15 9:48
 */
@Slf4j
@RestController
@RequestMapping(value = "/test/queue/")
public class TestQueueController {

    @Autowired
    QueueRequestAsyncService queueRequestAsyncService;

    @GetMapping("put/{count}")
    public BaseResponse<String> testLock(@PathVariable Integer count){

        for (int i = 0; i < count; i++) {
            UserBean userBean = new UserBean();
            userBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
            userBean.setName("sam");
            queueRequestAsyncService.process(new NonSenseMatchRequest(userBean,null));
        }

        return BaseResponse.success();
    }
}
