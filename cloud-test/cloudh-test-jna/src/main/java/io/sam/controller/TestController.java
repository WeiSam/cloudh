package io.sam.controller;

import common.BaseResponse;
import io.sam.sdk.LinuxTrackSdkLibrary;
import io.sam.utils.ByteUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2021/1/8 11:36
 */
@Slf4j
@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @GetMapping(value = "getVersion")
    public BaseResponse getVersion(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_GetVersion(byteBuffer);
        String version = ByteUtils.getString(byteBuffer);
        log.info("版本信息:{}",version);
        return BaseResponse.success(version);
    }

}
