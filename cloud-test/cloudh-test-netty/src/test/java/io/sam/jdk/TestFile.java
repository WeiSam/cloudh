package io.sam.jdk;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author zhuweimu
 * @desc
 * @date 2021/12/19 10:00
 */
public class TestFile {

    @Test
    public void testFileChannel() {
        try (FileChannel fileInChannel = new FileInputStream("F:\\test\\data.txt").getChannel();
             FileChannel fileOutChannel = new FileOutputStream(new File("F:\\test\\from.txt")).getChannel();){
            //一次拷贝最大为2g,超过需要分批次
            fileInChannel.transferTo(0,fileInChannel.size(),fileOutChannel);

            //多次拷贝
            long size = fileInChannel.size();
            for (long left = size; left > 0;) {
                left  -= fileInChannel.transferTo(size - left, left, fileOutChannel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
