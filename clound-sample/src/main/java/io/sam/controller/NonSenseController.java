package io.sam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhuweimu
 * @classname XianJiangController
 * @description
 * @date 2020/9/28 14:56
 */
@Slf4j
@RestController
@RequestMapping("gocloud/govideo/ppa/")
public class NonSenseController {

    @PostMapping("queryTrack")
    public String queryTrack(){
        return "{\n" +
                "    \"type\": \"String\",\n" +
                "    \"action\": \"String\",\n" +
                "    \"sequenceId\": \"String\",\n" +
                "    \"token\": \"String\",\n" +
                "    \"message\": {\n" +
                "        \"trackInfo\": [\n" +
                "            {\n" +
                "                \"roomId\": 0,\n" +
                "                \"deviceInfo\": [\n" +
                "                    {\n" +
                "                        \"cameraDetail\": \"192.168.78.31\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"startTime\": \"2022-03-30 19:57:31\",\n" +
                "                \"videoClip\": {\n" +
                "                    \"startTime\": \"2022-03-30 19:57:31\",\n" +
                "                    \"endTime\": \"2022-03-30 20:57:31\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"roomId\": 0,\n" +
                "                \"deviceInfo\": [\n" +
                "                    {\n" +
                "                        \"cameraDetail\": \"192.168.78.30\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"videoClip\": {\n" +
                "                    \"startTime\": \"2022-03-30 21:57:31\",\n" +
                "                    \"endTime\": \"2022-03-30 21:58:31\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"roomId\": 0,\n" +
                "                \"deviceInfo\": [\n" +
                "                    {\n" +
                "                        \"cameraDetail\": \"192.168.78.28\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"startTime\": \"2022-03-30 19:57:31\",\n" +
                "                \"videoClip\": {\n" +
                "                    \"startTime\": \"2022-03-30 22:57:31\",\n" +
                "                    \"endTime\": \"2022-03-30 22:58:31\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"errorCode\": \"0\",\n" +
                "        \"description\": \"String\",\n" +
                "        \"operResult\": 0\n" +
                "    }\n" +
                "}";
    }

    public static int ID = 1;
    @PostMapping("createGroup")
    public String createGroup(){
        return "{\n" +
                "  \"type\": \"String\",\n" +
                "  \"action\": \"String\",\n" +
                "  \"sequenceId\": \"String\",\n" +
                "  \"token\": \"String\",\n" +
                "  \"message\": {\n" +
                "  \"group\": [\n" +
                "    {\n" +
                "      \"id\": "+ID+++",\n" +
                "      \"name\": \"String\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"operResult\": 0,\n" +
                "  \"operDescri\": \"成功\"\n" +
                "}\n" +
                "}";
    }

    @PostMapping("modifyGroup")
    public String modifyGroup(){
        return "{\n" +
                "  \"type\": \"String\",\n" +
                "  \"action\": \"String\",\n" +
                "  \"sequenceId\": \"String\",\n" +
                "  \"token\": \"String\",\n" +
                "  \"message\": {\n" +
                "  \"group\": [\n" +
                "    {\n" +
                "      \"id\": "+ID+++",\n" +
                "      \"name\": \"String\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"operResult\": 0,\n" +
                "  \"operDescri\": \"成功\"\n" +
                "}\n" +
                "}";
    }

}
