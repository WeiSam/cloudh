package io.sam.queue.impl;


import io.sam.bean.UserBean;
import io.sam.queue.NonSenseReceiveRo;
import io.sam.queue.NonSenseRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author zhuweimu
 * @description
 * @date 2021/12/14 20:12
 */
@Slf4j
public class NonSenseMatchRequest implements NonSenseRequest {

    UserBean userBean;

    Object nonSenseMatchService;

    public NonSenseMatchRequest(UserBean userBean, Object nonSenseMatchService) {
        this.userBean = userBean;
        this.nonSenseMatchService = nonSenseMatchService;
    }

    /**
     * 业务执行
     */
    @Override
    public void process() {
        //执行匹配逻辑
        log.info("开始消费,id = {}",getPersonMagicId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取人员magicId
     *
     * @return
     */
    @Override
    public String getPersonMagicId() {
        return userBean.getId();
    }
}
