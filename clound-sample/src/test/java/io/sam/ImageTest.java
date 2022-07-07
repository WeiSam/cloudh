package io.sam;

import cn.hutool.core.img.Img;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhuweimu
 * @classname ImageTest
 * @description
 * @date 2020/11/17 10:38
 */
@Slf4j
public class ImageTest {

    @Test
    public void yasuo() throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream outStream1 = new ByteArrayOutputStream();
        Img.from(FileUtil.file("F:\\img\\0a53f3b8-af98-48da-83e2-76b6fba7af0e.jpg")).write(outStream1);
        String s1 = new BASE64Encoder().encode(outStream1.toByteArray()).replaceAll("\\\\s*|\\t|\\r|\\n", "");
        System.out.println(s1);
        Img.from(FileUtil.file("F:\\img\\0a53f3b8-af98-48da-83e2-76b6fba7af0e.jpg"))
                .setQuality(0.99)//压缩比率
                .write(FileUtil.file("F:\\img2\\1.jpg"));

        Img.from(FileUtil.file("F:\\img\\0a53f3b8-af98-48da-83e2-76b6fba7af0e.jpg"))
                .setQuality(2).write(outStream);

        String s = new BASE64Encoder().encode(outStream.toByteArray()).replaceAll("\\\\s*|\\t|\\r|\\n", "");
        System.out.println(s);

        File file = new File("F:\\img\\0a53f3b8-af98-48da-83e2-76b6fba7af0e.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream22 = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while((len = fileInputStream.read(b)) != -1) {
            outputStream22.write(b, 0, len);
        }
        System.out.println(new BASE64Encoder().encode(outputStream22.toByteArray()).replaceAll("\\\\s*|\\t|\\r|\\n", ""));
    }

    @Test
    public void name() throws IOException {
        File file;
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\img2\\3.jpg");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        FileUtil.writeToStream(FileUtil.file("F:\\img\\0a53f3b8-af98-48da-83e2-76b6fba7af0e.jpg"),outStream);

        byte[] bytes = outStream.toByteArray();
        fileOutputStream.write(bytes);
        System.out.println(new BASE64Encoder().encode(outStream.toByteArray()).replaceAll("\\\\s*|\\t|\\r|\\n", ""));
    }

    @Test
    public void hutool() {
        String url = "http://192.168.37.193/img/20200923/e5a8db209f64cc55912664c381d0e689.jpg";
        InputStream inputStream = getInputStreamByUrl(url);
        byte[] bytes = IoUtil.readBytes(inputStream);
        byte[] bytes1 = yasuo2(bytes, 30);
        FileUtil.writeBytes(bytes1,new File("F:\\img2\\ya6.jpg"));
    }
    public byte[] yasuo2(byte[] bytes,Integer maxKb){
        log.info("要求：{},,,目前大小：{}",maxKb*1024,bytes.length);
        if (maxKb*1024 >= bytes.length) {
            return bytes;
        }
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        double q = NumberUtil.div(maxKb*1024,bytes.length,2, RoundingMode.HALF_DOWN)-0.01;
        System.out.println("q:"+q);
        Img.from(new ByteArrayInputStream(bytes))
                .setQuality(q)//压缩比率
                .write(outStream);
        return yasuo2(outStream.toByteArray(),maxKb);
    }

    @Test
    public void thumbnailator() throws IOException {
/*        String url = "http://192.168.37.193/img/20200923/e5a8db209f64cc55912664c381d0e689.jpg";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        HttpUtil.downloadFile(url,"F:\\img2\\new.jpg");
        long download = HttpUtil.download(url, outputStream, Boolean.TRUE);
        InputStream inputStream = getInputStreamByUrl(url);*/

        InputStream inputStream = IoUtil.toStream(new File("F:\\img\\1befa7a0-fa06-4478-a12c-8a1454f29146.jpg"));
        byte[] bytes = IoUtil.readBytes(inputStream);
        System.out.println("bytes:"+bytes.length);
        byte[] bytes1 = yasuo(bytes, 30,0.3);
        FileUtil.writeBytes(bytes1,new File("F:\\img2\\ya8.jpg"));
//        Thumbnails.of(new ByteArrayInputStream(bytes))
//                .scale(1)
//                .outputQuality(0.33)
//                .toFile(new File("F:\\img2\\ya3.jpg"));

    }


    public byte[] yasuo( byte[] bytes,Integer maxKb,double q1) throws IOException {
        log.info("要求：{},,,目前大小：{}",maxKb*1024,bytes.length);
        if (maxKb*1024 >= bytes.length) {
            return bytes;
        }
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        double q = NumberUtil.div(maxKb*1024,bytes.length,1, RoundingMode.HALF_DOWN);
//        double q = 0.95;
        BufferedImage bim = ImageIO.read(new ByteArrayInputStream(bytes));
        int imgWidth = bim.getWidth();
        int imgHeight = bim.getHeight();
        // 如果不处理size,只用quality,可能导致一致压缩不到目标值，一致递归在当前方法中！！
        int desWidth = new BigDecimal(imgWidth).multiply(new BigDecimal(q)).intValue();
        int desHeight = new BigDecimal(imgHeight).multiply(new BigDecimal(q)).intValue();
        System.out.println("q:"+q);
        Thumbnails.of(new ByteArrayInputStream(bytes))
//                .size(desWidth,desHeight)
                .scale(0.95)
                .outputQuality(0.8)
                .outputFormat("jpg")
                .toOutputStream(outStream);
        return yasuo(outStream.toByteArray(),maxKb,q);
    }

    public static InputStream getInputStreamByUrl(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(1000);
            InputStream inStream = conn.getInputStream();
            return inStream;
        } catch (Exception e) {
            return null;
        }
    }

    static boolean flag = true;
    @Test
    public void test0001() {

        HttpUtil.downloadFile("http://192.168.37.163:14444/default/video/2022-01-18/all.mp4", new File("E:\\all.mp4"), new StreamProgress() {
            @Override
            public void start() {
                log.info("开始下载");
            }

            @Override
            public void progress(long progressSize) {

                int randomInt = RandomUtil.randomInt(100, 500);
                if (randomInt > 450) {
                    log.info("下载中:{}",progressSize);
                }
                try {
                    if (flag) {
//                        log.info("==================开始休眠==========================");
                        Thread.sleep(1000*1);
                        flag = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void finish() {
                log.info("下载完成");
            }
        });
    }

    @Test
    public void test0() {

        String body = "{\"fileName\":\"/home/gosun_record/20220318/f356c9a47aaa4c39bfc26cbf83cbbd9e_20220318-034531_65.mp4\"}";
        ImageTest.downloadFile2("http://192.168.78.214:15999/vcs/record/download",body, new File("E:\\all00.mp4"),-1, new StreamProgress() {
            @Override
            public void start() {
                log.info("开始下载");
            }

            @Override
            public void progress(long progressSize) {

            }

            @Override
            public void finish() {
                log.info("下载完成");
            }
        });

    }

    public static long downloadFile(String url,String body, File destFile, int timeout, StreamProgress streamProgress) {
        if (StrUtil.isBlank(url)) {
            throw new NullPointerException("[url] is null!");
        }
        if (null == destFile) {
            throw new NullPointerException("[destFile] is null!");
        }
        final HttpResponse response = HttpRequest
                .post(url)
                .header("authorization","Auth123456")
                .body(body,"application/json")
                .timeout(timeout)
                .executeAsync();
        if (false == response.isOk()) {
            throw new HttpException("Server response error with status code: [{}]", response.getStatus());
        }
        return response.writeBody(destFile, streamProgress);
    }

    public static long downloadFile2(String url,String body, File destFile, int timeout, StreamProgress streamProgress) {

        if (StrUtil.isBlank(url)) {
            throw new NullPointerException("[url] is null!");
        } else if (null == destFile) {
            throw new NullPointerException("[destFile] is null!");
        } else {
            HttpResponse response = HttpRequest.post(url)
                    .header("authorization","Auth123456")
                    .body(body,"application/json")
                    .timeout(timeout)
                    .executeAsync();
            if (!response.isOk()) {
                throw new HttpException("Server response error with status code: [{}]", new Object[]{response.getStatus()});
            } else {
                return response.writeBody(destFile, streamProgress);
            }
        }
    }
}
