package io.sam.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import io.sam.dto.GuiPingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname GuiPingController
 * @description
 * @date 2020/10/9 17:19
 */
@Slf4j
@RestController
@RequestMapping
public class GuiPingController {

    @PostMapping(value = "bazxsjjk/service/uploadFile")
    public GuiPingResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileUtil.writeBytes(file.getBytes(),new File("F://img/"+file.getOriginalFilename()));
        log.info("{},{},{}",file.getName(),file.getContentType(),file.getOriginalFilename());
        return new GuiPingResponse();
    }

    @PostMapping(value = "bazxsjjk/service/getToken")
    public GuiPingResponse getToken(@RequestParam("username") String username,@RequestParam("password") String password) throws IOException {
        log.info("{},{}",username,password);
        GuiPingResponse guiPingResponse = new GuiPingResponse();
        guiPingResponse.setStatusCode("00");
        guiPingResponse.setTokenStr("561256152gsafagsfgaf");
        return guiPingResponse;
    }

    @PostMapping(value = "bazxsjjk/service/record")
    public GuiPingResponse record(@RequestParam("recordStr") String recordStr,String bcStr,String hcjgStr) throws IOException {
        log.info("{},{},{}",recordStr,bcStr,hcjgStr);
        String str = "{\"centerCode\":\"440000888888\",\"orgCode\":\"1234\",\"orgName\":\"testest\",\"outReason\":\"custody\",\"outType\":\"directly_leave\",\"policeCode\":\"管理员\"}";
        return new GuiPingResponse();
    }

    @PostMapping(value = "bazxsjjk/service/leave")
    public GuiPingResponse leave(@Header("token") String token, HttpServletRequest httpRequest) throws IOException {
        String token1 = httpRequest.getHeader("token");
        log.info("token = {},token1 = {}",token,token1);
        GuiPingResponse guiPingResponse = new GuiPingResponse();
        guiPingResponse.setData("");
        guiPingResponse.setDate("");
        return guiPingResponse;
    }

    @PostMapping(value = "/checkToken/ajAqBaqsyqkdjb/save")
    public String save(HttpServletRequest httpRequest,@RequestBody Map map) throws IOException {
        log.info("map={}", JSON.toJSONString(map));
        String str = "{\"count\":0,\"content\":{},\"statusMessage\":\"string\",\"statusCode\":\"string\"}";
        return str;
    }

    @PostMapping(value = "/checkToken/ajAqBaqsyqkdjb/saveBatch")
    public String saveBatch(@RequestBody Map map) throws IOException {
        log.info("map={}", JSON.toJSONString(map));
        String str = "{\"count\":0,\"content\":{},\"statusMessage\":\"string\",\"statusCode\":\"string\"}";
        return str;
    }

}
