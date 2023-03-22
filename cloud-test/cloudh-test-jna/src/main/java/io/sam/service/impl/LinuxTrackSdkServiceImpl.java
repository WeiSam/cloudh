package io.sam.service.impl;


import io.sam.sdk.LinuxTrackSdkLibrary;
import io.sam.service.StaticService;
import io.sam.service.TrackSdkService;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/22 14:40
 */
@Slf4j
public class LinuxTrackSdkServiceImpl implements TrackSdkService {
    @Override
    public int GXX_NSPP_TRACK_GetVersion(ByteBuffer version_num) {
        return 0;
    }

    @Override
    public int GXX_NSPP_TRACK_Init(String lic_path) {
        LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_Init(lic_path);
        return 0;
    }

    @Override
    public void GXX_NSPP_TRACK_CleanUp() {

    }

    @Override
    public int GXX_NSPP_TRACK_Create(LongBuffer handle) {
        return 0;
    }

    @Override
    public void GXX_NSPP_TRACK_Release(long handle) {

    }

    @Override
    public int GXX_NSPP_TRACK_SetRegionConnectInfo(long handle, String szJsonParm, int nJsonLen) {
        return 0;
    }

    @Override
    public int getCode() {
        log.info("LinuxTrackSdkServiceImpl.getCode");
        return StaticService.CODE;
    }
}
