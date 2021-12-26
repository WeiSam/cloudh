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
public class GuangDongController {

    @GetMapping("zfpt/api/v1/third/qbpt/qgrkinfo")
    public String getPopulation(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String,Object> param){
        log.info("param:{}",JSON.toJSONString(param));
        return "{\n" +
                "    \"msg\": \"\",\n" +
                "    \"total\": 1,\n" +
                "    \"code\": 999999,\n" +
                "    \"success\": true,\n" +
                "    \"result_infos\": [\n" +
                "        {\n" +
                "            \"csrq\": \"19881005\",\n" +
                "            \"whcd\": \"70\",\n" +
                "            \"zzssxq\": \"\",\n" +
                "            \"qtzzxz\": \"\",\n" +
                "            \"bdyy\": \"\",\n" +
                "            \"jggj\": \"156\",\n" +
                "            \"hkszd\": \"110107\",\n" +
                "            \"sg\": \"167\",\n" +
                "            \"csdxz\": \"\",\n" +
                "            \"byqk\": \"0\",\n" +
                "            \"qtzzssxq\": \"\",\n" +
                "            \"xb\": \"2\",\n" +
                "            \"mz\": \"01\",\n" +
                "            \"hdqr\": \"\",\n" +
                "            \"bdrq\": \"\",\n" +
                "            \"fwcs\": \"\",\n" +
                "            \"hyzk\": \"10\",\n" +
                "            \"sfzh\": \"110107198810050627\",\n" +
                "            \"csd\": \"110107\",\n" +
                "            \"xm\": \"张帆\",\n" +
                "            \"cym\": \"\",\n" +
                "            \"rybh\": \"\",\n" +
                "            \"xp\": \"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\",\n" +
                "            \"zzxz\": \"西下庄村3号\",\n" +
                "            \"jgssx\": \"110107\",\n" +
                "            \"csdgj\": \"156\",\n" +
                "            \"zy\": \"Y00\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

}
