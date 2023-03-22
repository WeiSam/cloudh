package io.sam;

import io.sam.sdk.LinuxTrackSdkLibrary;
import io.sam.sdk.WindowTrackSdkLibrary;
import io.sam.service.StaticService;
import io.sam.service.StaticService02;
import io.sam.service.TrackSdkService;
import io.sam.utils.BufferUtils;
import io.sam.utils.ByteUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author zhuweimu
 * @classname MainTest
 * @description
 * @date 2021/2/8 14:23
 */
@Slf4j
public class MainTest {

    @Test
    public void test01() {
//        System.setProperty("jna.library.path", "F:\\win");
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_GetVersion(byteBuffer);
        String str = ByteUtils.getString(byteBuffer);
        String version = ByteUtils.bufferToString(byteBuffer);

        IntBuffer intBuffer = IntBuffer.allocate(1);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024*1024);
        int code = LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_PathSearch(1L, "[1,2]", 2, byteBuffer1, intBuffer);
        String result = ByteUtils.bufferToString(byteBuffer);

        log.info("版本信息:{}",version);
        log.info("查询路径路线坐标,result = {},code = {}",result,code);
    }

    @Test
    public void test02() {
//        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.library.path", "F:\\win");
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        WindowTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_GetVersion(byteBuffer);
        String version = new String(byteBuffer.array(), byteBuffer.position(), 0, StandardCharsets.UTF_8);
        log.info("版本信息:{}",version);
    }

    @Test
    public void test03() {
//        System.setProperty("jna.debug_load", "true");
        try {
            System.setProperty("jna.library.path", "F:\\win");
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_GetVersion(byteBuffer);
            String version = ByteUtils.getString(byteBuffer);
            log.info("版本信息:{}",version);
            int code = LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_Init("F:\\win");
            log.info("初始化创建,code = {}",code);
            LongBuffer handle = LongBuffer.allocate(1);
            int isCreate = LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_Create(handle);
            log.info("创建路径图,isCreate = {}",isCreate);
            log.info("创建路径图,handle = {}",handle.get(0));
        }finally {
            LinuxTrackSdkLibrary.INSTANCE.GXX_NSPP_TRACK_CleanUp();
        }
    }

    @Test
    public void test05() {
        LongBuffer handle = LongBuffer.allocate(2);
        handle.put(Long.MAX_VALUE);
        handle.put(11);
        System.out.println(handle.get(0));
        System.out.println(handle.get(0));
        System.out.println(handle.get(1));

        System.out.println(BigDecimal.valueOf(1).compareTo(BigDecimal.valueOf(2)));
    }

    @Test
    public void test07() {
        Object object = null;
        String os = System.getProperty("os.name");
        System.out.println(os);
        List<TrackSdkService> sdkServices = new ArrayList<>();
        ServiceLoader<TrackSdkService> trackSdkServices = ServiceLoader.load(TrackSdkService.class);
        Iterator<TrackSdkService> iterator = trackSdkServices.iterator();
        while (iterator.hasNext()) {
            TrackSdkService next = iterator.next();
            sdkServices.add(next);
        }
        for (int i = 0; i < sdkServices.size(); i++) {
            if (i==0) {
                continue;
            }
            TrackSdkService trackSdkService = sdkServices.get(i);
            System.out.println(trackSdkService.getCode());
        }
    }

    @Test
    public void test06() {
        Class<StaticService02> staticService02Class = StaticService02.class;
        System.out.println(StaticService.CODE1);
        int code = 0;
        if (false){
            code = StaticService.CODE;
        }
        System.out.println(code);
    }

    @Test
    public void test08() {
        IntBuffer intBuffer = IntBuffer.allocate(1);
        intBuffer.put(100);
        System.out.println(intBuffer.get(0));
        intBuffer.clear();
        System.out.println(intBuffer.get(0));
        intBuffer.put(200);
        System.out.println(intBuffer.get(0));
        System.out.println(intBuffer.get(0));
    }

    @Test
    public void test09() throws Exception {
        String str = "埃及地方";
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        byteBuffer.put(str.getBytes());
        String result = BufferUtils.directBufferToString(byteBuffer,str.getBytes().length);
        System.out.println(result);

    }
}
