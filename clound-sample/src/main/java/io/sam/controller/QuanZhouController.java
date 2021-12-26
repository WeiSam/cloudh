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
public class QuanZhouController {

    @PostMapping("api-gateway/gateway/88psmrrs/faces/retrieval/results")
    public String getFace(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,Object> param){
        System.out.println("Authentication:"+request.getHeader("Authentication"));
        System.out.println("param:"+ JSON.toJSONString(param));
//        response.setHeader("X-Error-Code","access_token_invalid");
        return "{\n" +
                "  \"msg\" : \"成功\",\n" +
                "  \"rows\" : 2,\n" +
                "  \"rtn\" : \"0\",\n" +
                "  \"results\" : [ {\n" +
                "    \"birthday\" : \"xxxx-xx-xx\",\n" +
                "    \"faceUrl\" : \"xxx\",\n" +
                "    \"sexCode\" : \"x\",\n" +
                "    \"address\" : \"xxx\",\n" +
                "    \"libId\" : \"xxx\",\n" +
                "    \"gender\" : \"x\",\n" +
                "    \"idCard\" : \"xxx\",\n" +
                "    \"name\" : \"xxx\",\n" +
                "    \"threshold\" : \"70\",\n" +
                "    \"faceId\" : \"xxx\",\n" +
                "    \"bkgUrl\" : \"xxx\"\n" +
                "  } ]\n" +
                "}";
    }

    @GetMapping("/api-gateway/gateway/get-token")
    public String getToken(HttpServletResponse response, HttpServletRequest request){
        System.out.println("param:"+ JSON.toJSONString(request.getParameterMap()));
        return "{\n" +
                "            \"access_token\": \"9048b91accd24d31a55e7be0fb7ea9b8\",\n" +
                "            \"expires_in\": \"3600\",\n" +
                "            \"refresh_token\": \"1c97ee1a22fb4dcf97faec2d111c15b6\",\n" +
                "            \"re_expires_in\": \"3600\"\n" +
                "        }";
    }

    @PostMapping("api-gateway/gateway/hzcxjgkg/apiJJZQuery/jjzxxcxHj")
    public String getPopulation(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,Object> param){
        System.out.println("Authentication:"+request.getHeader("Authentication"));
        System.out.println("param:"+ JSON.toJSONString(param));
//        response.setHeader("X-Error-Code","access_token_invalid");
        return "{\n" +
                "  \"message\" : \"\",\n" +
                "  \"content\" : {\n" +
                "    \"pidIssueUnitName\" : \"惠安县公安局\",\n" +
                "    \"whenOut\" : \"\",\n" +
                "    \"dob\" : \"1900-09-12 00:00:00\",\n" +
                "    \"whenIn\" : \"200x-xx-xx 00:00:00\",\n" +
                "    \"name\" : \"xxx\",\n" +
                "    \"genderCn\" : \"男\",\n" +
                "    \"pid18\" : \"35052xxxx\",\n" +
                "    \"nativePlaceCn\" : \"福建省xxx\",\n" +
                "    \"hjgs\" : \"福建省xxx\",\n" +
                "    \"zxbz\" : \"有效\",\n" +
                "    \"jlGxsj\" : \"2020103xxxxx\"\n" +
                "  },\n" +
                "  \"statusCode\" : \"200\"\n" +
                "}";
    }

}
