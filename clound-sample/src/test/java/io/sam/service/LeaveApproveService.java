package io.sam.service;

import com.alibaba.fastjson.JSON;
import io.sam.BaseTest;
import io.sam.api.TestServiceApi;
import io.sam.dto.UserDto;
import io.sam.dto.YanTaiRepositoryResp;
import io.sam.mq.producer.LeaveApproveProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author zhuweimu
 * @classname LeaveApproveService
 * @description
 * @date 2020/9/29 10:07
 */
public class LeaveApproveService extends BaseTest {

    @Autowired
    LeaveApproveProducer leaveApproveProducer;

    @Autowired
    TestServiceApi testServiceApi;

    @Test
    public void testRabbitMq() throws InterruptedException {
        leaveApproveProducer.send(new UserDto().setName("sam").setAge(18));
        Thread.sleep(1000*10);
    }

    @Test
    public void testApi() throws IOException {
        Call<UserDto> call = testServiceApi.getUserInfo();
        Response<UserDto> execute = call.execute();
        UserDto body = execute.body();
        System.out.println(JSON.toJSONString(body));
    }
}
