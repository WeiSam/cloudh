package io.sam.api;

import io.sam.dto.UserDto;
import io.sam.dto.YanTaiRepositoryResp;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author zhuweimu
 * @description
 * @date 2021/7/21 11:19
 */
public interface TestServiceApi {

    @GET("/test/getUserInfo")
    Call<UserDto> getUserInfo();
}
