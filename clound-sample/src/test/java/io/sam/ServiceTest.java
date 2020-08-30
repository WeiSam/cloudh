package io.sam;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dto.vo.PaymentVo;
import io.sam.service.MyJsonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author zhuweimu
 * @Classname service
 * @Description
 * @date 2020/8/24 9:33
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ServiceTest {

    @Autowired
    MyJsonService myJsonService;

    @Test
    public void test01(){
        String str1 = "LEAVE_TIME_START";
        String symbol = "=";
        if (StrUtil.containsIgnoreCase(str1,"time") && StrUtil.containsIgnoreCase(str1,"start")) {
            symbol = ">=";
        }else if (StrUtil.containsIgnoreCase(str1,"time") && StrUtil.containsIgnoreCase(str1,"end")){
            symbol = "<=";
        }
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        System.out.println(Long.parseLong(StrUtil.format("{}{}",new Date().getTime(),Integer.MAX_VALUE)));

        System.out.println(Integer.MAX_VALUE+String.valueOf(new Date().getTime()));


        System.out.println(String.valueOf(new Date().getTime())+RandomUtil.randomString(13));

//        PaymentVo paymentVo = PaymentVo.builder().id(12819L).build();
//        System.out.println("null".matches("^[a-z0-9A-Z]+$"));
//        System.out.println(StrUtil.toUnderlineCase("isDeleted").toUpperCase());
    }

    @Test
    public void test02(){
        String str = "{UPDATE}:{配玉}:{com.gosuncn.repository.dao.system.entity.Dictionary}:{{\"createUser\":\"1\",\"createdTime\":\"2020-08-20 10:32:45\",\"fieldCode\":\"440000888888\",\"fieldValue\":\"0\",\"id\":203819,\"isDeleted\":\"N\",\"magicId\":\"583010da04508cd16dc45f8eaa730ed2\",\"sortNum\":0,\"typeMagicId\":\"cce96208b496dc293c051e223e90ef7c\",\"updatedTime\":\"2020-08-25 09:47:58\",\"updatedUser\":\"b338316193add0e16ead5b1a2566352b\"}}";
        String requestSql = getRequestSql(1, str);
        System.out.println(JSON.isValidObject(requestSql));
        Map map = JSONObject.parseObject(requestSql);
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        cn.hutool.core.lang.UUID.randomUUID();
        System.out.println(RandomUtil.randomString(32));
        System.out.println(JSON.toJSONString(map));
    }

    private String getRequestSql(int logType, String logContent){
        if(logType == 0){
            return null;
        }

        int first = logContent.indexOf("{") + 1;
        int second = logContent.indexOf("{", first) + 1;
        int third = logContent.indexOf("{", second) + 1;
        int last = logContent.indexOf("{", third)+1;
        String substring = logContent.substring(last, logContent.lastIndexOf("}"));
        return substring;

    }
}
