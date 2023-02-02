package com.sam.service;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.sam.BaseTest;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.*;

/**
 * @author zhuweimu
 * @description
 * @date 2022/9/2 9:18
 */
public class FreemarkerTest extends BaseTest {

    @Autowired
    private Configuration configuration;

/*    @Test
    public void testFreemarker() throws Exception {
        String fileName = "qrcode.doc";
        String path = "F://"+fileName;
        BufferedReader bufferedReader = null;
        BufferedWriter bw = null;
        File file = null;

        Template template = configuration.getTemplate("testqrcode.xml");
        String result = FreeMarkerTemplateUtils.processTemplateIntoString(template,new Object());
        ResponseEntity<byte[]> responseEntity = FileUtil.exportWord(result.getBytes("UTF-8"), fileName);
        InputStream inputStream = new ByteArrayInputStream(responseEntity.getBody());
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        String tempString = "";
        while ((tempString = bufferedReader.readLine()) != null) {
            bw.write(tempString);
            bw.flush();
        }
        bufferedReader.close();
        bw.close();
    }*/


}
