package io.sam.service;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/22 14:39
 */
public interface TrackSdkService {

    /**
     * 获取版本信息
     * @param version_num
     * @return
     */
    int GXX_NSPP_TRACK_GetVersion(ByteBuffer version_num);

    /**
     * 初始化-申请资源
     * @param lic_path
     * @return
     */
    int GXX_NSPP_TRACK_Init(String lic_path);

    /**
     * 是否资源
     */
    void GXX_NSPP_TRACK_CleanUp();

    /**
     * 创建路径图handle
     * @param handle
     * @return
     */
    int GXX_NSPP_TRACK_Create(LongBuffer handle);

    /**
     * 释放路径图资源
     * @param handle
     */
    void GXX_NSPP_TRACK_Release(long handle);

    /**
     * 设置路径图信息
     * @param handle
     * @param szJsonParm
     * @param nJsonLen
     * @return
     */
    int GXX_NSPP_TRACK_SetRegionConnectInfo(long handle, String szJsonParm, int nJsonLen);

    int getCode();
}
