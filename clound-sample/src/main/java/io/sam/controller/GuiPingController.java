package io.sam.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import io.sam.annotation.OperateLog;
import io.sam.dto.GuiPingResponse;
import io.sam.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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

    @OperateLog(logOpt = "test",logBizDesc = "test",record = "#userDto.name")
    @PostMapping(value = "bazxsjjk/service/getToken")
    public GuiPingResponse getToken(@RequestBody UserDto userDto, @RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        log.info("{},{}",username,password);
        if (username.equals("11")) {
            throw new Exception("异常");
        }
        GuiPingResponse guiPingResponse = new GuiPingResponse();
        guiPingResponse.setStatusCode("00");
        guiPingResponse.setTokenStr("561256152gsafagsfgaf");
        return guiPingResponse;
    }

    @OperateLog(logOpt = "test2",logBizDesc = "test2",record = "#recordStr")
    @PostMapping(value = "bazxsjjk/service/record")
    protected void record(@RequestParam("recordStr") String recordStr,String bcStr,String hcjgStr) throws Exception {
        log.info("{},{},{}",recordStr,bcStr,hcjgStr);
        if (recordStr.equals("11")) {
            throw new Exception("异常");
        }
        String str = "{\"centerCode\":\"440000888888\",\"orgCode\":\"1234\",\"orgName\":\"testest\",\"outReason\":\"custody\",\"outType\":\"directly_leave\",\"policeCode\":\"管理员\"}";
        return ;
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

    @PostMapping(value = "bazxsjjk/service/testAn")
    public GuiPingResponse testAn(HttpServletRequest httpRequest) throws IOException {
        GuiPingResponse guiPingResponse = new GuiPingResponse();
        guiPingResponse.setData("");
        guiPingResponse.setDate("");
        return guiPingResponse;
    }

    @PostMapping(value = "/WLZFBA-SERVICE/webservice/rest/common/getZfqySuspects")
    public String getZfqySuspects(HttpServletRequest httpRequest,@RequestBody Map map) throws IOException {
        log.info("map={}", JSON.toJSONString(map));
        String str = "{\"msg\":\"调用被拒绝，您没有调用此服务权限\",\"success\":\"false\"}";
        return str;
    }

    @PostMapping(value = "/kms/work/save")
    protected Map test001(@RequestParam Map map) throws Exception {
        log.info("map={}", JSON.toJSONString(map));
        Map<String, String> ret = new HashMap<>();
        ret.put("token",(String)map.get("token"));
        return map;
    }
}
