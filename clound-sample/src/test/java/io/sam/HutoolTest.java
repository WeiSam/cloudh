package io.sam;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;

import java.io.File;

public class HutoolTest {

    public static void main(String[] args) {
        download();
    }

    public static void download() {
        String body = "{\"fileName\":\"/home/gosun_record/20220318/f356c9a47aaa4c39bfc26cbf83cbbd9e_20220318-034531_65.mp4\"}";
        String fileUrl = "http://192.168.78.214:15999/vcs/record/download";
        long size = downloadFile(fileUrl,body, FileUtil.file("E:/abc.mp4"),-1,null);
        System.out.println(size);
    }

    public static long downloadFile(String url,String body, File destFile, int timeout, StreamProgress streamProgress) {

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
