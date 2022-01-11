package io.sam.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import common.BaseResponse;
import io.sam.db.service.AccountTblService;
import io.sam.dto.ChongqingRequest;
import io.sam.dto.YanTaiLoginReq;
import io.sam.dto.YanTaiLoginResp;
import io.sam.dto.YanTaiRepositoryResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author zhuweimu
 * @classname TestController
 * @description
 * @date 2020/9/9 16:45
 */
@Slf4j
@RestController
@RequestMapping
public class TestController {

    @Autowired
    AccountTblService accountTblService;

    @RequestMapping({"/oauth2/authorize"})
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String str = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1eWNvYzM2Q1k4ZHFjdnRGeUx5NVhFIiwic3ViIjoiOThiNjBkMzgtM2FlMS00ZTIwLTkwNDMtMTRhZTM5NzBmYWM2IiwiZXhwIjoxNTk5NzE3OTI2LCJuYW1lIjoi6K2m5Yqh5rWL6K-VIiwidXNlcm5hbWUiOiIzNTAxMDAyMDIwMDgyNzAwMDEiLCJsb2dpbl9uYW1lIjoiMzUwMTAwMjAyMDA4MjcwMDAxIiwiZUNvZGUiOiJmemdhIiwiaXNzIjoiaHR0cDovLzQ0LjUzLjIyLjIyL3NzbyIsImdtc2Z6IjoiMzUwMTAwMjAyMDA4MjcwMDAxIn0.2hEfGyRB0Fg0Yu4kexDbEm_HUUfkoV_SDYMDag3LlTw";
//        String redirect_uri = request.getParameter("redirect_uri");
//        redirect_uri = URLDecoder.decode(redirect_uri);
//        //获取到认证信息之后进行各业务本地逻辑，比如再次进行系统内权限校验，信息校验，再把相关信息存放到session，
//        HttpSession session=((HttpServletRequest)request).getSession();
//        session.setAttribute("userAuthJsonStr",str);
        response.sendRedirect("http://192.168.37.193/cmt/view/index.html#/login?aa=90");
    }

    @GetMapping(value = "business/api/storage/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(HttpServletResponse response, HttpServletRequest request){
        String url = "http://192.168.37.193/img/20200718/d2d7d1f515f300089e586c52a84bba6a.jpg";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        long download = HttpUtil.download(url, outputStream, Boolean.TRUE);
        log.info("session_id = {},uri_base64 = {}",request.getHeader("session_id"),request.getParameter("uri_base64"));
        return outputStream.toByteArray();
    }

    @PostMapping("business/api/login")
    public YanTaiLoginResp login(@RequestBody YanTaiLoginReq yanTaiLoginReq,HttpServletRequest request){
        log.info("yanTaiLoginReq = {},session_id", JSON.toJSONString(yanTaiLoginReq),request.getParameter("session_id"));
        YanTaiLoginResp yanTaiLoginResp = new YanTaiLoginResp();
        yanTaiLoginResp.setSession_id(UUID.randomUUID().toString());
        yanTaiLoginResp.setRtn(0);
        yanTaiLoginResp.setMessage("success");
        return yanTaiLoginResp;
    }

    @GetMapping("business/api/repository")
    public YanTaiRepositoryResp getRepository(HttpServletRequest request){
        log.info("session_id = {}",request.getHeader("session_id"));
        return new YanTaiRepositoryResp();
    }

    @GetMapping("test/test.do")
    public String testDo(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return "jkajskj";
    }

    @GetMapping("cache/{id}")
    public BaseResponse testCache(@PathVariable Integer id){
        return BaseResponse.success(accountTblService.selectByPrimaryKey(id));
    }


    /**
     * 模拟异步响应
     */
    HashMap<String, AsyncContext> map = new HashMap<>();
    @RequestMapping({"/asyncContext/{dataId}"})
    public void asyncContext(HttpServletResponse response, HttpServletRequest request,@PathVariable String dataId) throws IOException {
        AsyncContext asyncContext = request.startAsync(request, response);
        map.put(dataId,asyncContext);
    }

    /**
     * 处理异步请求
     * @param response
     * @param request
     * @param dataId
     * @return
     * @throws IOException
     */
    @RequestMapping({"/dealAsyncContext/{dataId}"})
    public String dealAsyncContext(HttpServletResponse response, HttpServletRequest request,@PathVariable String dataId) throws IOException {
        AsyncContext asyncContext = map.get(dataId);
        HttpServletResponse response1 = (HttpServletResponse) asyncContext.getResponse();
        response1.setStatus(HttpServletResponse.SC_ACCEPTED);
        response1.getWriter().println("收到响应了");
        asyncContext.complete();
        return "成功";
    }

    @PostMapping("/receiver/receiveData")
    public String receiveData(@RequestBody ChongqingRequest chongqingRequest, HttpServletRequest request){
        log.info("chongqingRequest = {}", JSON.toJSONString(chongqingRequest));
        return "{\n" +
                "  \"uuid\": \"c26eec3e-67da-4e5d-9b5a-87bffa73fb85\", \n" +
                " \"code\": 200,\n" +
                "\"responseId\": \"ffe3b2f5d31d395b6f26a46fd834b9e1\",\n" +
                "  \"message\": \"ok\"\n" +
                "}";
    }

    @GetMapping("/")
    public void base(){

    }

    @GetMapping("/test/{name}")
    public String test(String name){
        return name;
    }
}
