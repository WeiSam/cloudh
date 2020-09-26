package io.sam.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuweimu
 * @Classname TaiWeiSiController
 * @Description
 * @Date 2020/7/24 10:31
 */
@RestController
@RequestMapping("haiou/v2/api/")
@Slf4j
public class TaiWeiSiController {

    @PostMapping("createCompareTask")
    public String createCompareTask(@RequestBody TaiWeiSiTaskReq taiWeiSiTaskReq, HttpServletRequest request){
        System.out.println("taiWeiSiTaskReq = "+ JSON.toJSONString(taiWeiSiTaskReq));
        System.out.println("request = "+ JSON.toJSONString(request.getHeader("sign")));
        return "{\n" +
                "  \"taskId\": 127995,\n" +
                "  \"loopInterval\": 20\n" +
                "}";
    }

    @GetMapping("getRepositoryList")
    public String getRepositoryList(HttpServletRequest request){
        return "[\n" +
                "  {\n" +
                "    \"id\": \"10065\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"新疆维吾尔自治区\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10044\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"广东\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10043\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"湖南\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10046\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"海南\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10045\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"广西壮族自治区\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10014\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"陕西\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10015\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"内蒙古自治区\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10011\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"北京\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10012\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"天津\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10013\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"河北\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10041\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"河南\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10042\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"湖北\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10061\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"陕西\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10062\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"甘肃\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10063\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"青海\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10064\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"宁夏回族自治区\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10037\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"山东\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10054\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"西藏自治区\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10036\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"江西\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10035\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"福建\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10034\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"安徽\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10033\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"浙江\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10032\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"江苏\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"100104\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"重点人员\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"100105\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"在逃人员\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10023\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"黑龙江\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10021\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"辽宁\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10022\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"吉林\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10031\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"上海\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10052\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"贵州\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10053\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"云南\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10050\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"重庆\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"10051\",\n" +
                "    \"description\": null,\n" +
                "    \"name\": \"四川\"\n" +
                "  }\n" +
                "]";
    }

    @GetMapping("getAlgorithmList")
    public String getAlgorithmList(HttpServletRequest request){
        return "[\n" +
                "  {\n" +
                "    \"id\": \"117\",\n" +
                "    \"name\": \"深醒算法\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"115\",\n" +
                "    \"name\": \"云天励飞算法\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"113\",\n" +
                "    \"name\": \"Face++算法\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"110\",\n" +
                "    \"name\": \"商汤算法\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"111\",\n" +
                "    \"name\": \"依图算法\"\n" +
                "  }\n" +
                "]";
    }

    @GetMapping("getCompareTask")
    public String getCompareTask(HttpServletRequest request){
        System.out.println("getRequestURI:"+request.getRequestURI());
        System.out.println("ParameterMap:"+JSON.toJSONString(request.getParameterMap()));
        System.out.println("request = "+ JSON.toJSONString(request.getHeader("sign")));
        System.out.println("request = "+ JSON.toJSONString(request.getHeader("appId")));
        System.out.println("request = "+ JSON.toJSONString(request.getHeaderNames()));
        return "{\n" +
                "    \"status\": \"FINISH\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"dataList\": [\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 98,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/828.jpg\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 98,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/827.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmId\": \"111\",\n" +
                "            \"name\": \"依图算法\",\n" +
                "            \"code\": \"0\",\n" +
                "            \"msg\": \"比对成功\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dataList\": [\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 97,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/828.jpg\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 97,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/827.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmId\": \"110\",\n" +
                "            \"name\": \"商汤算法\",\n" +
                "            \"code\": \"0\",\n" +
                "            \"msg\": \"比对成功\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dataList\": [\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 92,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/828.jpg\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 91.99,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/154/927/241.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmId\": \"113\",\n" +
                "            \"name\": \"Face++算法\",\n" +
                "            \"code\": \"0\",\n" +
                "            \"msg\": \"比对成功\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dataList\": [\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 94.99,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/828.jpg\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省清远\",\n" +
                "                    \"name\": \"徐某明\",\n" +
                "                    \"similarity\": 94,\n" +
                "                    \"personId\": \"44010319880818xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省广州市荔湾区恩洲北横街66号2104房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/000/932/827.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmId\": \"115\",\n" +
                "            \"name\": \"云天励飞算法\",\n" +
                "            \"code\": \"0\",\n" +
                "            \"msg\": \"比对成功\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"dataList\": [\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省湛江市\",\n" +
                "                    \"name\": \"唐某立\",\n" +
                "                    \"similarity\": 90.90,\n" +
                "                    \"personId\": \"44088119880826xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省廉江市塘蓬镇潭村7号\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/156/707/071.jpg\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"nativePlace\": \"广东省吴川市\",\n" +
                "                    \"name\": \"陈某登\",\n" +
                "                    \"similarity\": 90.99,\n" +
                "                    \"personId\": \"44088319940816xxxx\",\n" +
                "                    \"nativePlaceAddr\": \"广东省吴川市黄坡镇平城村98号102房\",\n" +
                "                    \"repositoryName\": \"广东\",\n" +
                "                    \"tagAry\": [\n" +
                "                        \"广东\"\n" +
                "                    ],\n" +
                "                    \"repositoryId\": \"10044\",\n" +
                "                    \"url\": \"http://10.40.145.31/pic/440/089/522/122.jpg\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"algorithmId\": \"117\",\n" +
                "            \"name\": \"深醒算法\",\n" +
                "            \"code\": \"0\",\n" +
                "            \"msg\": \"比对成功\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
