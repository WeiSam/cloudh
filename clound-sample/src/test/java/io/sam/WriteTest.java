package io.sam;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import io.sam.easyexcel.ComplexHeadData;
import io.sam.easyexcel.CustomizeMergeStrategy;
import io.sam.utils.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 写的常见写法
 *
 * @author Jiaju Zhuang
 */
//@Ignore
@Slf4j
public class WriteTest {

    public static String formUpload(String uploadUrl, InputStream inputStream, String fileName) {
        StringBuilder postData = new StringBuilder();
        HttpURLConnection conn = null;
        String boundary = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(uploadUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream out = new DataOutputStream(conn.getOutputStream());

            String contentType = null;
            if(fileName.endsWith("bmp")) {
                contentType = "image/bmp";
            }
            else if(fileName.endsWith("png")) {
                contentType = "image/png";
            }else {
                contentType = new MimetypesFileTypeMap().getContentType(fileName);
            }
            //contentType = new MimetypesFileTypeMap().getContentType(fileName);
            //String contentType = "image/jpeg";

            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(boundary).append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"" + fileName + "\"; filename=\"" + fileName
                    + "\"\r\n");
            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

            out.write(strBuf.toString().getBytes());
            postData.append(strBuf.toString());

            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = inputStream.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            inputStream.close();

            byte[] endData = ("\r\n--" + boundary + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuffer.append(line).append("\n");
            }
            String responseStr = strBuffer.toString();


            postData.append(responseStr);
            reader.close();
            reader = null;

        } catch (Exception e) {
            log.error("上传请求[{}]出现异常：{}", uploadUrl, e);
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block

                }
            }
        }
        return postData.toString();
    }

    @Test
    public void testMerge3() {
        String name = "人员情况统计"+System.currentTimeMillis();
        String format = ".xlsx";
        // 方法2 自定义合并单元格策略
        String fileName = TestFileUtil.getPath() + name + format;
        CustomizeMergeStrategy customizeMergeStrategy = new CustomizeMergeStrategy();
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭

        File tempFile = FileUtil.createTempFile(name, format, true);

        log.info("文件目录:{}",tempFile.getAbsolutePath());
        EasyExcel.write(tempFile, ComplexHeadData.class)
                .registerWriteHandler(customizeMergeStrategy)
                .sheet("模板").doWrite(data2());


        HashMap<String, Object> paramMap = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file",tempFile);
        String result= HttpUtil.post("192.168.78.193/upload", paramMap);
        log.info("结果:{}",result);
    }

    @Test
    public void testMerge2() {
        // 方法2 自定义合并单元格策略
        String fileName = "人员情况统计" + System.currentTimeMillis() + ".xlsx";
        CustomizeMergeStrategy customizeMergeStrategy = new CustomizeMergeStrategy();

        log.info("文件目录:{}",fileName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        EasyExcel.write(outputStream, ComplexHeadData.class)
                .autoCloseStream(true)
                .registerWriteHandler(customizeMergeStrategy)
                .sheet("模板").doWrite(data2());

        String result= formUpload("http://192.168.78.193/upload", IoUtil.toStream(outputStream),fileName);
        log.info("结果:{}",result);
    }

    @Test
    public void testMerge1() {
        // 方法1 注解
        String fileName = TestFileUtil.getPath() + "mergeWrite" + System.currentTimeMillis() + ".xlsx";
        // 方法2 自定义合并单元格策略
        fileName = TestFileUtil.getPath() + "mergeWrite" + System.currentTimeMillis() + ".xlsx";
//        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        CustomizeMergeStrategy customizeMergeStrategy = new CustomizeMergeStrategy();
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class)
                .registerWriteHandler(customizeMergeStrategy)
                .sheet("模板").doWrite(data2());
    }

    private List<ComplexHeadData> data2() {
        List<ComplexHeadData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ComplexHeadData data = new ComplexHeadData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            data.setAge(10);
            data.setName("Sam"+i);
            data.setNameA("别名"+i);
            list.add(data);
        }
        return list;
    }
}
