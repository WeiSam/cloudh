package io.sam.utils;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author zhuweimu
 * @description
 * @date 2022/4/25 13:58
 */
public class BufferUtils {

    /**
     * bufferToString
     * @param buffer
     * @return
     */
    public static String bufferToString(ByteBuffer buffer){
        return new String(buffer.array(), buffer.position(), buffer.limit(), StandardCharsets.UTF_8);
    }

    public static String bufferToString(ByteBuffer buffer,int length){
        if (length <= 0) {
            return "";
        }
        return new String(buffer.array(), buffer.position(), length, StandardCharsets.UTF_8);
    }

    public static ByteBuffer stringToBuffer(String str){
        return ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String directBufferToString(ByteBuffer buffer,int length) throws Exception {
        if (length <= 0) {
            return "";
        }
        byte[] bytes = new byte[length];
        buffer.flip();
        buffer.get(bytes);
        return new String(bytes, 0, length, StandardCharsets.UTF_8);
    }
}
