package com.sam;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.fastjson.JSON;
import io.sam.bean.UserBean;
import io.sam.task.TestTask01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.WebDataBinder;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author zhuweimu
 * @description
 * @date 2021/6/16 16:19
 */
@Slf4j
public class MainTest {

    @Test
    public void name() {
        ResolvableType resolvableType = ResolvableType.forClass(MainTest.class);
        System.out.println(resolvableType.getSource());
        System.out.println(resolvableType.getGeneric(0).getSource());
        System.out.println(TestTask01.class.getDeclaringClass());
    }

    @Test
    public void test01() {
        UserBean person = new UserBean();
        WebDataBinder binder = new WebDataBinder(person, "person");

        // 设置属性（此处演示一下默认值）
        MutablePropertyValues pvs = new MutablePropertyValues();

        // 使用!来模拟各个字段手动指定默认值
        //pvs.add("name", "fsx");
        pvs.add("!name", "不知火舞");
        pvs.add("age", 18);
        pvs.add("!age", 10); // 上面有确切的值了，默认值不会再生效

        binder.bind(pvs);
        System.out.println(person);
    }

    @Test
    public void test111() {

        List<UserBean> userBeans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserBean userBean = new UserBean();
            if (i==1) {
                userBean.setId("1234");
            }else {
                userBean.setId("12345");
                userBean.setAge(1);
            }
            userBeans.add(userBean);
        }

        Map<String, Integer> policePersonCountMap =  userBeans.stream()
                .collect(Collectors.toMap(UserBean::getId, UserBean::getAge, Integer::sum));

        System.out.println(policePersonCountMap);
    }

    @Test
    public void test101() throws IOException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("","");
        System.out.println(testNull(null));
        //获取Desktop实例
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create("https://www.baidu.com"));
    }

    public String testNull(@NotNull String str){
        return str;
    }

    @Test
    public void testQr() {
        QrCodeUtil.generate("京津冀快递，分局是看空间的"
                ,new QrConfig(300,300),new File("F:\\文档测试\\图片.jpg"));

        QrCodeUtil.generate("京津冀快递，分局是看空间的"
                ,new QrConfig(300,300));
    }

    @Test
    public void test001() {
        int size = 230;
        int byteSize;
        if (size <= 100) {
            byteSize = 1;
        }else if(size <= 200){
            byteSize = 2;
        }else if(size <= 300){
            byteSize = 3;
        }else {
            byteSize = 5;
        }
        System.out.println(byteSize);
    }
}
