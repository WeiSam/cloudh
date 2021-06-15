package io.sam.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhuweimu
 * @classname XianJiangController
 * @description
 * @date 2020/9/28 14:56
 */
@Slf4j
@RestController
@RequestMapping
public class JiNanController {


    @PostMapping("/uaa/oauth/token")
    public String getToken(HttpServletResponse response, HttpServletRequest request){
        System.out.println("param:"+ JSON.toJSONString(request.getParameterMap()));
        return "{\n" +
                "    \"access_token\": \"bed4d5be-b258-4d26-861e-2dbd900e7de3\",\n" +
                "    \"token_type\": \"bearer\",\n" +
                "    \"expires_in\": 42094,\n" +
                "    \"scope\": \"all\"\n" +
                "}";
    }

    @PostMapping("/zfpt/jn/common/v1/ajxx/getAjxxListByTime")
    public String getAjxxListByTime(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String,Object> param){
        System.out.println("param:"+ JSON.toJSONString(param));
//        response.setHeader("X-Error-Code","access_token_invalid");
        return "{\n" +
                "    \"msg\": \"\",\n" +
                "    \"total\": 0,\n" +
                "    \"code\": 200,\n" +
                "    \"success\": true,\n" +
                "    \"result_infos\": {\n" +
                "        \"total\": 10,\n" +
                "        \"size\": 10,\n" +
                "        \"pages\": 100,\n" +
                "        \"current\": 1,\n" +
                "        \"records\": [\n" +
                "            {\n" +
                "                \"ajbh\": \"A3701022300002019126001\",\n" +
                "                \"aymc\": \"危害国家安全罪\",\n" +
                "                \"cbrSfzh\": \"372323198309060339\",\n" +
                "                \"slsj\": \"2019-12-27 15:43:51\",\n" +
                "                \"cbrXm\": \"韩晓磊\",\n" +
                "                \"cbdwMc\": \"济南市公安局历下区分局东关大街派出所\",\n" +
                "                \"jyaq\": \"12345来电称市民反映此处有人唱歌，扰民求助，联系人：13697678595，张女士。\",\n" +
                "                \"ajzt\": \"已受理\",\n" +
                "                \"XGSJ\": \"2019-12-27 15:43:51\",\n" +
                "                \"ajmc\": \"测试案件名称\",\n" +
                "                \"fadd\": \"广东省深圳市111111111111111111111111111111111\",\n" +
                "                \"AY\": \"010000\",\n" +
                "                \"ajlx\": \"刑事\",\n" +
                "                \"cbdwBh\": \"370100241000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ajbh\": \"A3701022300002019126002\",\n" +
                "                \"aymc\": \"危害国家安全罪\",\n" +
                "                \"cbrSfzh\": \"372323198309060339\",\n" +
                "                \"slsj\": \"2019-12-27 15:43:51\",\n" +
                "                \"cbrXm\": \"韩晓磊\",\n" +
                "                \"cbdwMc\": \"济南市公安局历下区分局东关大街派出所\",\n" +
                "                \"jyaq\": \"12345来电称市民反映此处有人唱歌，扰民求助，联系人：13697678595，张女士。\",\n" +
                "                \"ajzt\": \"已受理\",\n" +
                "                \"XGSJ\": \"2019-12-27 15:43:51\",\n" +
                "                \"ajmc\": \"测试案件名称\",\n" +
                "                \"fadd\": \"广东省深圳市111111111111111111111111111111111\",\n" +
                "                \"AY\": \"010000\",\n" +
                "                \"ajlx\": \"刑事\",\n" +
                "                \"cbdwBh\": \"370100241000\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }

    @PostMapping("/zfpt/jn/common/v1/jqxx/getJqxxListByTime")
    public String getJqxxListByTime(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String,Object> param){
        System.out.println("param:"+ JSON.toJSONString(param));
        return "{\n" +
                "    \"msg\": \"\",\n" +
                "    \"total\": 10,\n" +
                "    \"code\": 200,\n" +
                "    \"success\": true,\n" +
                "    \"result_infos\": {\n" +
                "        \"total\": 10,\n" +
                "        \"size\": 10,\n" +
                "        \"pages\": 100,\n" +
                "        \"current\": 1,\n" +
                "        \"records\": [\n" +
                "            {\n" +
                "                \"bjnr\": \"报警人称3月12日晚在此丢失一箱货物（价值1万元），请求协助查看监控。\",\n" +
                "                \"cjrXm\": \"东风\",\n" +
                "                \"cjnr\": \"民警到达现场，已给予其相应帮助\",\n" +
                "                \"bjrlxdh\": \"18560419779\",\n" +
                "                \"afdd\": \"二环东路与山大北路路口路东\",\n" +
                "                \"bjrxm\": \"匿名\",\n" +
                "                \"lrsj\": \"2020-03-19 15:41:48\",\n" +
                "                \"jqzt\": \"已撤销\",\n" +
                "                \"bjsj\": \"2020-03-15 11:33:33\",\n" +
                "                \"djsj\": \"2020-03-15 11:35:18\",\n" +
                "                \"cjrSfzh\": \"372323198309060339\",\n" +
                "                \"cjdw\": \"济南市公安局历城区分局东风派出所\",\n" +
                "                \"cjdw_bh\": \"370100241000\",\n" +
                "                \"fpjg\": \"重复警情\",\n" +
                "                \"id\": \"A13B5ADBD2433EB4E053093212388B09\",\n" +
                "                \"bjfs\": \"110指令\",\n" +
                "                \"jqbh\": \"370100012020031511333300001916\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"bjnr\": \"报警人称3月12日晚在此丢失一箱货物（价值1万元），请求协助查看监控。\",\n" +
                "                \"cjrXm\": \"东风\",\n" +
                "                \"cjnr\": \"民警到达现场，已给予其相应帮助\",\n" +
                "                \"bjrlxdh\": \"18560419779\",\n" +
                "                \"afdd\": \"二环东路与山大北路路口路东\",\n" +
                "                \"bjrxm\": \"匿名\",\n" +
                "                \"lrsj\": \"2020-03-19 15:41:48\",\n" +
                "                \"jqzt\": \"已撤销\",\n" +
                "                \"bjsj\": \"2020-03-15 11:33:33\",\n" +
                "                \"djsj\": \"2020-03-15 11:35:18\",\n" +
                "                \"cjrSfzh\": \"110101197907290018\",\n" +
                "                \"cjdw\": \"济南市公安局历城区分局东风派出所\",\n" +
                "                \"cjdw_bh\": \"440114680000\",\n" +
                "                \"fpjg\": \"重复警情\",\n" +
                "                \"id\": \"A13B5ADBD2433EB4E053093212388B09\",\n" +
                "                \"bjfs\": \"110指令\",\n" +
                "                \"jqbh\": \"370100012020031511333300001917\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
    }

    @PostMapping("/GoAnalyse/ppa/queryTrack")
    public String queryTrack(){
        return "{\n" +
                "    \"description\": \"String\",\n" +
                "    \"trackInfo\": [\n" +
                "        {\n" +
                "            \"roomId\": 0,\n" +
                "            \"deviceInfo\": [\n" +
                "                {\n" +
                "                    \"deviceId\": \"1\",\n" +
                "                    \"cameraDetail\": \"192.168.35.140\",\n" +
                "                    \"captureUrl\": \"String\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"startTime\": \"1990-06-22 17:12:10\",\n" +
                "            \"endTime\": \"1990-06-22 17:15:10\",\n" +
                "            \"videoClip\": {\n" +
                "                \"startTime\": \"2021-04-09 16:31:14\",\n" +
                "                \"endTime\": \"2021-04-09 16:39:14\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"roomId\": 0,\n" +
                "            \"deviceInfo\": [\n" +
                "                {\n" +
                "                    \"deviceId\": \"1\",\n" +
                "                    \"cameraDetail\": \"192.168.35.134\",\n" +
                "                    \"captureUrl\": \"String\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"startTime\": \"1990-06-22 17:20:10\",\n" +
                "            \"endTime\": \"1990-06-22 17:25:10\",\n" +
                "            \"videoClip\": {\n" +
                "                \"startTime\": \"2021-04-09 17:31:14\",\n" +
                "                \"endTime\": \"2021-04-09 17:39:14\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"errorCode\": \"0\"\n" +
                "}";
    }
}
