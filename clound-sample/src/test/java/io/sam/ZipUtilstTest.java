package io.sam;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zhuweimu
 * @description
 * @date 2021/11/29 9:37
 */
public class ZipUtilstTest {

    public static String ZIP_FILE = "F:\\doc\\test.zip";
    public static String JPG_FILE = "F:\\img2\\1.jpg";
    public static String FILE_NAME = "testZip.jpg";
    public static String SUFFIX_FILE = "zip";
    public static Long FILE_SIZE = 3000L;
    private static void printInfo(long beginTime) {
        System.out.println("耗时"+beginTime);
    }

    @Test
    public void zipFileNoBuffer() {
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            //开始时间
            long beginTime = System.currentTimeMillis();

            for (int i = 0; i < 1; i++) {
                try (InputStream input = new FileInputStream(JPG_FILE)) {
                    zipOut.putNextEntry(new ZipEntry(FILE_NAME + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zipFileBuffer() {
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            //开始时间
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_FILE))) {
                    zipOut.putNextEntry(new ZipEntry(FILE_NAME + i));
                    int temp = 0;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(temp);
                    }
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFileChannel() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_FILE).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(i + SUFFIX_FILE));
                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFileMap() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {

                zipOut.putNextEntry(new ZipEntry(i + SUFFIX_FILE));

                //内存中的映射文件
                MappedByteBuffer mappedByteBuffer = new RandomAccessFile(JPG_FILE, "r").getChannel()
                        .map(FileChannel.MapMode.READ_ONLY, 0, FILE_SIZE);

                writableByteChannel.write(mappedByteBuffer);
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Version 5 使用Pip
    public static void zipFilePip() {

        long beginTime = System.currentTimeMillis();
        try(WritableByteChannel out = Channels.newChannel(new FileOutputStream(ZIP_FILE))) {
            Pipe pipe = Pipe.open();
            //异步任务
            CompletableFuture.runAsync(()->runTask(pipe));

            //获取读通道
            ReadableByteChannel readableByteChannel = pipe.source();
            ByteBuffer buffer = ByteBuffer.allocate(3000);
            while (readableByteChannel.read(buffer)>= 0) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        printInfo(beginTime);

    }

    //异步任务
    public static void runTask(Pipe pipe) {

        try(ZipOutputStream zos = new ZipOutputStream(Channels.newOutputStream(pipe.sink()));
            WritableByteChannel out = Channels.newChannel(zos)) {
            System.out.println("Begin");
            for (int i = 0; i < 10; i++) {
                zos.putNextEntry(new ZipEntry(i+SUFFIX_FILE));

                FileChannel jpgChannel = new FileInputStream(new File(JPG_FILE)).getChannel();

                jpgChannel.transferTo(0, FILE_SIZE, out);

                jpgChannel.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
