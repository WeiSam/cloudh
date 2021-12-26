package io.sam.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhuweimu
 * @description
 * @date 2020/9/28 14:56
 */
@Slf4j
@RestController
@RequestMapping
public class FoShanController {


    @PostMapping("/restcloud/fh_gateway/v1/epdimic/queryinfo/apitokenxx")
    public String getToken(HttpServletResponse response, HttpServletRequest request){
        System.out.println("param:"+ JSON.toJSONString(request.getParameterMap()));
        return "{\n" +
                "    \"meta\": {\n" +
                "        \"status\": 0,\n" +
                "        \"message\": \"ok\"\n" +
                "    },\n" +
                "    \"data\": {\n" +
                "        \"identitytoken\": \"eyJhbGciOiJI11111112222222\",\n" +
                "        \"state\": true,\n" +
                "        \"userName\": \"fenghuo1\",\n" +
                "        \"userId\": \"fenghuo12\"\n" +
                "    }\n" +
                "}";
    }

    @PostMapping("/restcloud/tydkapi/v1/gdfszaczrkxt/czrkjbxx")
    public String czrkjbxx(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,Object> param){
        System.out.println("param:"+ JSON.toJSONString(param));
        log.info("header:{}",request.getHeader("identitytoken"));
       return "{\n" +
               "    \"code\": \"10000\",\n" +
               "    \"data\": [\n" +
               "        {\n" +
               "            \"totalSize\": 5514000\n" +
               "        },\n" +
               "        {\n" +
               "            \"qlbzqldssxqmc\": \"广东省佛山市禅城区\",\n" +
               "            \"gxdwbh\": \"440604000000\",\n" +
               "            \"xinxijbmc\": \"五级\",\n" +
               "            \"xijgajgjgdm\": \"440604000000\",\n" +
               "            \"disbyzd10\": \"\",\n" +
               "            \"disbyzd11\": \"\",\n" +
               "            \"hkxzmc\": \"居民户口\",\n" +
               "            \"disbyzd12\": \"\",\n" +
               "            \"disbyzd13\": \"\",\n" +
               "            \"disbyzd14\": \"\",\n" +
               "            \"jhryzjlxmc\": \"\",\n" +
               "            \"disbyzd15\": \"\",\n" +
               "            \"disbyzd16\": \"\",\n" +
               "            \"ztbsdm\": \"1\",\n" +
               "            \"disbyzd17\": \"\",\n" +
               "            \"disbyzd18\": \"\",\n" +
               "            \"yxqqsrq\": \"20180321\",\n" +
               "            \"disbyzd19\": \"\",\n" +
               "            \"swzmbh\": \"\",\n" +
               "            \"cymxmhypy\": \"\",\n" +
               "            \"jgssxdm\": \"440682\",\n" +
               "            \"qlbzqqldjlxdm\": \"000017\",\n" +
               "            \"zhuxyydm\": \"\",\n" +
               "            \"nzfbsmc\": \"农业户\",\n" +
               "            \"zuoszwxxbsmc\": \"\",\n" +
               "            \"cszqfrq\": \"\",\n" +
               "            \"gjgwybsdm\": \"\",\n" +
               "            \"pcsmc\": \"江湾派出所\",\n" +
               "            \"qianwdgjhdqdm\": \"\",\n" +
               "            \"yhzgxdm\": \"20\",\n" +
               "            \"zazykgxsj\": \"\",\n" +
               "            \"qlbzqqldsqjcwhmc\": \"和平社区居委会\",\n" +
               "            \"sfhjdsfzbsdm\": \"\",\n" +
               "            \"yuanshkxzmc\": \"\",\n" +
               "            \"shengbyzd19\": \"\",\n" +
               "            \"zylbmc\": \"学生\",\n" +
               "            \"csdgjhdqdm\": \"156\",\n" +
               "            \"shengbyzd17\": \"\",\n" +
               "            \"shengbyzd18\": \"\",\n" +
               "            \"xldm\": \"70\",\n" +
               "            \"bh\": \"440604201710270000000000264914\",\n" +
               "            \"cqshcbsmc\": \"\",\n" +
               "            \"yjhrygxdm\": \"\",\n" +
               "            \"zjxydm\": \"00\",\n" +
               "            \"dsmc\": \"广东省佛山市\",\n" +
               "            \"qlbzqiryydm\": \"0500\",\n" +
               "            \"byzkdm\": \"\",\n" +
               "            \"gengxrbh\": \"440601196907010660\",\n" +
               "            \"mqzjlxdm\": \"111\",\n" +
               "            \"hyzkdm\": \"10\",\n" +
               "            \"fqzjlxmc\": \"居民身份证\",\n" +
               "            \"qlbsqldssxqmc\": \"\",\n" +
               "            \"sg\": \"\",\n" +
               "            \"yjhregxmc\": \"\",\n" +
               "            \"cszmbh\": \"\",\n" +
               "            \"shengbyzd11\": \"\",\n" +
               "            \"bz\": \"\",\n" +
               "            \"shengbyzd12\": \"\",\n" +
               "            \"shengbyzd10\": \"\",\n" +
               "            \"shengbyzd15\": \"\",\n" +
               "            \"shengbyzd16\": \"\",\n" +
               "            \"shengbyzd13\": \"\",\n" +
               "            \"shengbyzd14\": \"\",\n" +
               "            \"qlbsqiryyms\": \"\",\n" +
               "            \"ssxqmc\": \"广东省佛山市禅城区\",\n" +
               "            \"jggjdqmc\": \"中华人民共和国\",\n" +
               "            \"yszwxxbsmc\": \"\",\n" +
               "            \"sfzfazhyydm\": \"22\",\n" +
               "            \"disbyzd20\": \"\",\n" +
               "            \"sfzqfdwjigmc\": \"佛山市公安局禅城分局\",\n" +
               "            \"qlbzqqldpcsdm\": \"440604560000\",\n" +
               "            \"cym2\": \"\",\n" +
               "            \"jhrexm\": \"\",\n" +
               "            \"jlxdm\": \"000417\",\n" +
               "            \"sfsxjthbsdm\": \"\",\n" +
               "            \"x\": \"\",\n" +
               "            \"shengbyzd20\": \"\",\n" +
               "            \"xtbh\": \"foshan44067\",\n" +
               "            \"qlbzqqldjlxxqmc\": \"跃进路\",\n" +
               "            \"rhrqsj\": \"2009-12-22 11:37:27\",\n" +
               "            \"sfzqfrq\": \"2018-03-21 00:00:00\",\n" +
               "            \"qlbsqldxxdz\": \"\",\n" +
               "            \"csrq\": \"1998-10-21 00:00:00\",\n" +
               "            \"dzmc\": \"广东省佛山市禅城区张槎青柯旧吴村大街六巷2号之二\",\n" +
               "            \"sjqm\": \"\",\n" +
               "            \"tdrybsdm\": \"\",\n" +
               "            \"csdssxmc\": \"广东省佛山市南海区\",\n" +
               "            \"chuangjrxm\": \"系统管理员\",\n" +
               "            \"hlxdm\": \"1\",\n" +
               "            \"scsj\": \"\",\n" +
               "            \"mzmzwz\": \"汉族\",\n" +
               "            \"pozjlxmc\": \"\",\n" +
               "            \"qlbzqirrqsj\": \"2017-10-27 15:43:17\",\n" +
               "            \"cjdwmc\": \"石湾派出所\",\n" +
               "            \"sjjzddzmc\": \"\",\n" +
               "            \"qlbzqiryyms\": \"市内移居\",\n" +
               "            \"qlbsmc\": \"市内移居\",\n" +
               "            \"biadyydm\": \"0500\",\n" +
               "            \"bzksjgxsj\": \"2020-10-15 23:15:03\",\n" +
               "            \"jhrezjhm\": \"\",\n" +
               "            \"gddwmc\": \"佛山市公安局禅城分局\",\n" +
               "            \"jlxxqmc\": \"张槎青柯旧吴村\",\n" +
               "            \"cym\": \"\",\n" +
               "            \"qlbzqqldxzjddm\": \"440604001\",\n" +
               "            \"qlbzqldxxdz\": \"广东省佛山市禅城区跃进路27号之二404房\",\n" +
               "            \"zujsbywlxmc\": \"身份证管理申换补领\",\n" +
               "            \"qlyydm\": \"\",\n" +
               "            \"skbsdm\": \"\",\n" +
               "            \"yuancfxjhkjmxm\": \"\",\n" +
               "            \"qlbsqldgjhdqmc\": \"\",\n" +
               "            \"csbzbsdm\": \"\",\n" +
               "            \"mzdm\": \"01\",\n" +
               "            \"cqwybsh\": \"\",\n" +
               "            \"xbdm\": \"1\",\n" +
               "            \"zakxxrksj\": \"\",\n" +
               "            \"shcbsdm\": \"0\",\n" +
               "            \"kghkbsmc\": \"\",\n" +
               "            \"zrqsqjcwhdm\": \"\",\n" +
               "            \"jinjilxryddh\": \"\",\n" +
               "            \"cssj\": \"\",\n" +
               "            \"xzjddm\": \"440604003\",\n" +
               "            \"zwcjqkms\": \"\",\n" +
               "            \"sqjcwhmc\": \"青柯村委会\",\n" +
               "            \"qianwdxxdz\": \"广东省佛山市禅城区张槎青柯旧吴村大街六巷2号之二\",\n" +
               "            \"jthsxh\": \"3\",\n" +
               "            \"qtmzdm\": \"\",\n" +
               "            \"disbyzd9\": \"\",\n" +
               "            \"xm\": \"吴煜彬\",\n" +
               "            \"lshh\": \"\",\n" +
               "            \"disbyzd7\": \"\",\n" +
               "            \"disbyzd8\": \"\",\n" +
               "            \"yddh\": \"\",\n" +
               "            \"disbyzd5\": \"\",\n" +
               "            \"rybh\": \"440604201205130000000271889760\",\n" +
               "            \"disbyzd6\": \"\",\n" +
               "            \"disbyzd3\": \"\",\n" +
               "            \"sfedzbsmc\": \"是\",\n" +
               "            \"disbyzd4\": \"\",\n" +
               "            \"disbyzd1\": \"\",\n" +
               "            \"disbyzd2\": \"\",\n" +
               "            \"biadqvymc\": \"\",\n" +
               "            \"jhrezjlxdm\": \"\",\n" +
               "            \"poxm\": \"\",\n" +
               "            \"hh\": \"012001619\",\n" +
               "            \"gengxrxm\": \"李淑贤\",\n" +
               "            \"yuanshkxzdm\": \"\",\n" +
               "            \"shoucfszykxxrksj\": \"2020-05-20 21:29:51\",\n" +
               "            \"jhrezjlxmc\": \"\",\n" +
               "            \"qlbzqqlddzbm\": \"4406040000000226531911\",\n" +
               "            \"jhryzjlxdm\": \"\",\n" +
               "            \"jggjdqdm\": \"156\",\n" +
               "            \"xinxijbdm\": \"5\",\n" +
               "            \"hkxzdm\": \"1\",\n" +
               "            \"zykcqgxsj\": \"2020-09-25 04:51:00\",\n" +
               "            \"ztbsmc\": \"在用\",\n" +
               "            \"lxdh\": \"\",\n" +
               "            \"gjgwybsmc\": \"\",\n" +
               "            \"qianwdssxqdm\": \"440604\",\n" +
               "            \"yhzgxmc\": \"子\",\n" +
               "            \"siwzxrqsj\": \"\",\n" +
               "            \"qianwdgjhdqmc\": \"\",\n" +
               "            \"kghkbsdm\": \"\",\n" +
               "            \"pcsdm\": \"440604620000\",\n" +
               "            \"fqxm\": \"吴志强\",\n" +
               "            \"zyrbzksj\": \"2020-10-15 23:15:03\",\n" +
               "            \"fwcs\": \"\",\n" +
               "            \"sfhjdsfzbsmc\": \"\",\n" +
               "            \"jgssxmc\": \"广东省佛山市南海区\",\n" +
               "            \"zylbdm\": \"971\",\n" +
               "            \"ccdjrq\": \"\",\n" +
               "            \"shengbyzd1\": \"\",\n" +
               "            \"gxsj\": \"2017-10-27 15:44:16\",\n" +
               "            \"shengbyzd2\": \"\",\n" +
               "            \"shengbyzd3\": \"\",\n" +
               "            \"shengbyzd4\": \"\",\n" +
               "            \"yjhrygxmc\": \"\",\n" +
               "            \"shengbyzd5\": \"\",\n" +
               "            \"waibhh\": \"\",\n" +
               "            \"shengbyzd6\": \"\",\n" +
               "            \"shengbyzd7\": \"\",\n" +
               "            \"shengbyzd8\": \"\",\n" +
               "            \"shengbyzd9\": \"\",\n" +
               "            \"zy\": \"学生\",\n" +
               "            \"yjhregxdm\": \"\",\n" +
               "            \"hyzkmc\": \"未婚\",\n" +
               "            \"byzkmc\": \"\",\n" +
               "            \"qlbsqiryydm\": \"\",\n" +
               "            \"sfzfazhyyms\": \"证件有效期满换领\",\n" +
               "            \"zqzbh\": \"\",\n" +
               "            \"dzbm\": \"440604400406429\",\n" +
               "            \"mqzjlxmc\": \"居民身份证\",\n" +
               "            \"cymxmhypy2\": \"\",\n" +
               "            \"csdgjhdqmc\": \"中华人民共和国\",\n" +
               "            \"chuangjrbh\": \"000000000000000001\",\n" +
               "            \"sfzfazhyymc\": \"22\",\n" +
               "            \"gxdwmc\": \"禅城分局\",\n" +
               "            \"nzfbsdm\": \"5\",\n" +
               "            \"biadrqsj\": \"2017-10-27 15:43:17\",\n" +
               "            \"fqzjlxdm\": \"111\",\n" +
               "            \"xuexmc\": \"\",\n" +
               "            \"qlbsqldssxqdm\": \"\",\n" +
               "            \"xzzdzmc\": \"\",\n" +
               "            \"hlxmc\": \"家庭户口\",\n" +
               "            \"xbmzwz\": \"男\",\n" +
               "            \"ssxqdm\": \"440604\",\n" +
               "            \"qyzbh\": \"\",\n" +
               "            \"yszwxxbsdm\": \"\",\n" +
               "            \"jhryxm\": \"\",\n" +
               "            \"sfsxjthbsmc\": \"\",\n" +
               "            \"csdxxdz\": \"\",\n" +
               "            \"dsdm\": \"440600\",\n" +
               "            \"qlbzqldssxqdm\": \"440604\",\n" +
               "            \"yuancfxjhkjmdzmc\": \"\",\n" +
               "            \"cqshcbsdm\": \"\",\n" +
               "            \"xijgajgjgmc\": \"佛山市公安局禅城分局\",\n" +
               "            \"biadqydm\": \"\",\n" +
               "            \"gmsfhm\": \"440682199810215012\",\n" +
               "            \"qlbzqqldpcsmc\": \"石湾派出所\",\n" +
               "            \"tdrybsmc\": \"\",\n" +
               "            \"qlbsqldgjhdqdm\": \"\",\n" +
               "            \"pozjlxdm\": \"\",\n" +
               "            \"biadyyms\": \"市内移居\",\n" +
               "            \"qlbsqirrqsj\": \"\",\n" +
               "            \"jhryzjhm\": \"\",\n" +
               "            \"csdssxdm\": \"440682\",\n" +
               "            \"qlyyms\": \"\",\n" +
               "            \"jthryrswgx\": \"\",\n" +
               "            \"yuancfxjhkjmgmsfhm\": \"\",\n" +
               "            \"mqzjhm\": \"440622197201075020\",\n" +
               "            \"mqxm\": \"霍美心\",\n" +
               "            \"skbsmc\": \"\",\n" +
               "            \"xxdm\": \"\",\n" +
               "            \"xlmc\": \"初中\",\n" +
               "            \"zujsbywbh\": \"4406040002018032100074\",\n" +
               "            \"zujsbywlxdm\": \"0301\",\n" +
               "            \"xmhypy\": \"WUYUBIN\",\n" +
               "            \"qlbzqqldxzjdmc\": \"石湾镇街道\",\n" +
               "            \"zjxymc\": \"无宗教信仰\",\n" +
               "            \"yxqjzrq\": \"20280321\",\n" +
               "            \"pozjhm\": \"\",\n" +
               "            \"qtmzmzwz\": \"\",\n" +
               "            \"zhuxyyms\": \"\",\n" +
               "            \"qlbsdm\": \"0500\",\n" +
               "            \"zwcjqkdm\": \"\",\n" +
               "            \"zrqsqjcwhmc\": \"\",\n" +
               "            \"csbzbsmc\": \"\",\n" +
               "            \"qlbzqqldsqjcwhdm\": \"440604001001\",\n" +
               "            \"shcbsmc\": \"否\",\n" +
               "            \"qianwdssxqmc\": \"广东省佛山市禅城区\",\n" +
               "            \"zuoszwxxbsdm\": \"\",\n" +
               "            \"sqjcwhdm\": \"440604003016\",\n" +
               "            \"zhuxrqsj\": \"\",\n" +
               "            \"jinjilxrxm\": \"\",\n" +
               "            \"cjdwbh\": \"440604560000\",\n" +
               "            \"sfedzbsdm\": \"1\",\n" +
               "            \"xzjdmc\": \"张槎街道\",\n" +
               "            \"fqzjhm\": \"440601197001193477\"\n" +
               "        }\n" +
               "    ],\n" +
               "    \"message\": \"成功\",\n" +
               "    \"seqid\": \"0ebeaf105dfc4da4a0a6d909c9260fb1\"\n" +
               "}";
    }

    @PostMapping("/restcloud/tydkapi/v1/gdfsjzxt/ajxx")
    public String ajxx(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,Object> param){
        log.info("param:{}",JSON.toJSONString(param));
        log.info("header:{}",request.getHeader("identitytoken"));
        return "{\n" +
                "    \"code\": \"10000\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"totalSize\": 2605834\n" +
                "        },\n" +
                "        {\n" +
                "            \"mmdjdm\": \"1\",\n" +
                "            \"ajbh\": \"A4406045100002020010008\",\n" +
                "            \"whcddm\": \"04\",\n" +
                "            \"fzztlxmc\": \"自然人\",\n" +
                "            \"lazuihxgsj\": \"\",\n" +
                "            \"byzd9\": \"\",\n" +
                "            \"xzbwmc\": \"\",\n" +
                "            \"asjysrqsj\": \"2020-02-18 14:48:00\",\n" +
                "            \"sazongjjermby\": 0,\n" +
                "            \"byzd6\": \"4406045200000113\",\n" +
                "            \"xzbwdm\": \"\",\n" +
                "            \"ysdwbgdh\": \"\",\n" +
                "            \"byzd2\": \"\",\n" +
                "            \"byzd1\": \"\",\n" +
                "            \"byzd4\": \"22.97145\",\n" +
                "            \"bmmc\": \"佛山市公安局禅城分局城南派出所\",\n" +
                "            \"byzd3\": \"113.0111\",\n" +
                "            \"sssqjcwhmc\": \"环市朝安社区\",\n" +
                "            \"asjdbjbdm\": \"\",\n" +
                "            \"mmdjmc\": \"普通\",\n" +
                "            \"faasjzz\": \"2020-01-03 19:33:41\",\n" +
                "            \"ysdwdwbh2\": \"\",\n" +
                "            \"fzztlxdm\": \"1\",\n" +
                "            \"zhuybaryjh\": \"062156\",\n" +
                "            \"fadxzqhdm\": \"\",\n" +
                "            \"sssqjcwhdm\": \"440604002033416\",\n" +
                "            \"ab\": \"贩卖毒品案\",\n" +
                "            \"ejgongzbmbh\": \"\",\n" +
                "            \"tbrxm\": \"\",\n" +
                "            \"shangcbsmc\": \"\",\n" +
                "            \"ysdwdwmc\": \"\",\n" +
                "            \"padwbh\": \"\",\n" +
                "            \"zyrbzksj\": \"2020-10-22 01:52:57\",\n" +
                "            \"yisrqsj\": \"\",\n" +
                "            \"chuangjrxm1\": \"182621\",\n" +
                "            \"gxsj\": \"2020-02-12 12:17:59\",\n" +
                "            \"fxxsmc\": \"\",\n" +
                "            \"lapzrxm\": \"\",\n" +
                "            \"slsj\": \"2020-01-03 20:28:00\",\n" +
                "            \"larq\": \"2020-01-03 21:53:00\",\n" +
                "            \"cjrqsj\": \"2020-01-03 19:58:05\",\n" +
                "            \"abdm\": \"060702\",\n" +
                "            \"zaztmc\": \"既遂\",\n" +
                "            \"xbxcyxm\": \"陈子彤,钟少华,霍浩滨,梁敏强,潘国纯,华昶,李昭宏,\",\n" +
                "            \"jjdwmc\": \"\",\n" +
                "            \"xzcsdm\": \"2216\",\n" +
                "            \"ajmc\": \"罗金水贩卖毒品案\",\n" +
                "            \"aqshejgjhdqmc\": \"中国\",\n" +
                "            \"zaztdm\": \"1\",\n" +
                "            \"shangcbsdm\": \"\",\n" +
                "            \"jzajajbh\": \"\",\n" +
                "            \"bz\": \"\",\n" +
                "            \"aqshejgjhdqdm\": \"CHN\",\n" +
                "            \"mtzajdwbh\": \"\",\n" +
                "            \"lalrrjh\": \"\",\n" +
                "            \"jjshoulbh\": \"\",\n" +
                "            \"rqsj1\": \"\",\n" +
                "            \"asjdbjbmc\": \"\",\n" +
                "            \"zyzasd\": \"预备手段,100\",\n" +
                "            \"rqsj2\": \"\",\n" +
                "            \"ssxqdm\": \"\",\n" +
                "            \"shouldwmc\": \"佛山市公安局禅城分局城南派出所\",\n" +
                "            \"shoucshjgmc\": \"进一步审查\",\n" +
                "            \"psztdm\": \"\",\n" +
                "            \"byzd010\": \"\",\n" +
                "            \"zhjdm\": \"\",\n" +
                "            \"bmgxajbh\": \"\",\n" +
                "            \"blayymc\": \"\",\n" +
                "            \"lazhxgrjh\": \"\",\n" +
                "            \"gxyjztbrqsj\": \"\",\n" +
                "            \"zbdwdwmc\": \"佛山市公安局禅城分局城南派出所\",\n" +
                "            \"fxxsdm\": \"\",\n" +
                "            \"xtbh\": \"c4edc0a26f6961f2016f6b450e981b4c\",\n" +
                "            \"shoucshjgdm\": \"11\",\n" +
                "            \"baarylxdh\": \"\",\n" +
                "            \"blayydm\": \"\",\n" +
                "            \"whjzwy\": 0,\n" +
                "            \"zbdwbh\": \"440604510000\",\n" +
                "            \"jjfsmc\": \"工作发现\",\n" +
                "            \"sqjcwhdm1\": \"\",\n" +
                "            \"larjh\": \"\",\n" +
                "            \"sqjcwhdm2\": \"\",\n" +
                "            \"anjlxmc\": \"刑事\",\n" +
                "            \"xzwpmc\": \"\",\n" +
                "            \"sfcxlabsdm\": \"\",\n" +
                "            \"faddymc\": \"城区\",\n" +
                "            \"zuihxgsj\": \"2020-03-16 15:56:38\",\n" +
                "            \"lalrsj\": \"\",\n" +
                "            \"mtzajrqsj\": \"\",\n" +
                "            \"anjlxdm\": \"01\",\n" +
                "            \"bsmc\": \"\",\n" +
                "            \"jyaq\": \"2019年12月30日我局根据线索抓获吸毒人员范剑锋（广东广宁县人）、李志明（广东河源市人）、潘全钊（广西贵港市人）、梁锦成（广东省云浮市人）四人，后根据其四人供述吸食毒品是在范剑锋在佛山市内的出租屋一起吸食毒品的，范剑锋在佛山市内有容留他人吸毒的行为，并且供述四人一起吸食的毒品是向广东肇庆四会市东城区一名叫“啊水”（电话号码：13660910969，广东省四会市人）的男子在佛山市禅城区朝安北路路段购买的，现查实名叫“啊水”的男子有贩卖毒品的行为。\",\n" +
                "            \"sftgtjsjspbsdm\": \"\",\n" +
                "            \"ladwmc\": \"\",\n" +
                "            \"xzsjdm\": \"\",\n" +
                "            \"xzwpdm\": \"\",\n" +
                "            \"sftgtjsjspbsmc\": \"\",\n" +
                "            \"zars\": 0,\n" +
                "            \"juzajwsbh\": \"c4edc0a26f6961f2016f6b450ee61b4d\",\n" +
                "            \"swrs\": 0,\n" +
                "            \"byzd07\": \"\",\n" +
                "            \"byzd09\": \"\",\n" +
                "            \"fxsj\": \"\",\n" +
                "            \"byzd05\": \"\",\n" +
                "            \"byzd06\": \"\",\n" +
                "            \"xzsjmc\": \"\",\n" +
                "            \"zyzasddm\": \"1000,100\",\n" +
                "            \"anjztdm\": \"07\",\n" +
                "            \"fadqhnxxdz\": \"广东省佛山市禅城区朝安路路段\",\n" +
                "            \"yusblajbsdm\": \"\",\n" +
                "            \"fadwdwmc\": \"\",\n" +
                "            \"xzcsmc\": \"商店\",\n" +
                "            \"fadssxqdm\": \"440604\",\n" +
                "            \"cxajrqsj\": \"\",\n" +
                "            \"aqsfswbsdm\": \"0\",\n" +
                "            \"fadxzjdmc\": \"朝安路\",\n" +
                "            \"ysdwbgdh2\": \"\",\n" +
                "            \"zhuanabsdm\": \"\",\n" +
                "            \"aqsfswbsmc\": \"否\",\n" +
                "            \"anjztmc\": \"已移交\",\n" +
                "            \"yusgtysajdwbh\": \"\",\n" +
                "            \"slrjh\": \"\",\n" +
                "            \"bjsj\": \"2019-12-30 19:33:45\",\n" +
                "            \"jjfsdm\": \"04\",\n" +
                "            \"bzksjgxsj\": \"2020-10-22 01:52:57\",\n" +
                "            \"ssjqdm\": \"4406045200000113\",\n" +
                "            \"xzdxdm\": \"303\",\n" +
                "            \"bsdm\": \"0\",\n" +
                "            \"sfcxlabsmc\": \"\",\n" +
                "            \"fadssxqmc\": \"广东省佛山市禅城区\",\n" +
                "            \"shouldwbh\": \"440604510000\",\n" +
                "            \"zhuanabsmc\": \"\",\n" +
                "            \"sjuztdm\": \"\",\n" +
                "            \"fadxzjddm\": \"440604006509\",\n" +
                "            \"fadshcsdm\": \"\",\n" +
                "            \"anjwybsh\": \"佛禅公立字[20200599\",\n" +
                "            \"ssjqmc\": \"环市朝安东警区\",\n" +
                "            \"jjdwbh\": \"\",\n" +
                "            \"zuihxgrjh\": \"183253\",\n" +
                "            \"yscbrxm2\": \"\",\n" +
                "            \"anjlydm\": \"\",\n" +
                "            \"shcbsdm\": \"0\",\n" +
                "            \"xbrjh\": \"182621,189476,182250,182434,183125,183035,183241,\",\n" +
                "            \"xiacbsdm\": \"\",\n" +
                "            \"dbxx\": \"\",\n" +
                "            \"shcbsmc\": \"否\",\n" +
                "            \"lapzrqsj\": \"\",\n" +
                "            \"zhuyajbh\": \"\",\n" +
                "            \"btglarqsj\": \"\",\n" +
                "            \"dccfzyzdshqrxm\": \"\",\n" +
                "            \"zagjmc\": \"1\",\n" +
                "            \"xiacbsmc\": \"\",\n" +
                "            \"faasjcz\": \"2019-12-30 16:33:25\",\n" +
                "            \"ladwbh\": \"370114050100\",\n" +
                "            \"ssjzrmby\": 0,\n" +
                "            \"afdpcsdm\": \"\",\n" +
                "            \"jarqsj\": \"\",\n" +
                "            \"zbzcyxm\": \"王梓诚\",\n" +
                "            \"sjuyzm\": \"\",\n" +
                "            \"zagjdm\": \"1\",\n" +
                "            \"dccfzyzdlxdm\": \"\",\n" +
                "            \"dccfzyzdlxmc\": \"\",\n" +
                "            \"xzjddm\": \"\",\n" +
                "            \"parqsj\": \"\",\n" +
                "            \"whcdmc\": \"一般\",\n" +
                "            \"ejgongzbmmc\": \"\",\n" +
                "            \"jutajly\": \"\",\n" +
                "            \"faddydm1\": \"\",\n" +
                "            \"byzd36\": \"\",\n" +
                "            \"faddydm2\": \"1\",\n" +
                "            \"ysdwdwbh\": \"\",\n" +
                "            \"yscbrxm\": \"\",\n" +
                "            \"tianbrqsj\": \"2020-01-03 19:33:45\",\n" +
                "            \"zjmc\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mmdjdm\": \"\",\n" +
                "            \"ajbh\": \"A4406056108002020010010\",\n" +
                "            \"whcddm\": \"\",\n" +
                "            \"fzztlxmc\": \"\",\n" +
                "            \"lazuihxgsj\": \"\",\n" +
                "            \"byzd9\": \"error\",\n" +
                "            \"xzbwmc\": \"\",\n" +
                "            \"asjysrqsj\": \"\",\n" +
                "            \"sazongjjermby\": \"\",\n" +
                "            \"byzd6\": \"440605610603\",\n" +
                "            \"xzbwdm\": \"\",\n" +
                "            \"ysdwbgdh\": \"\",\n" +
                "            \"byzd2\": \"\",\n" +
                "            \"byzd1\": \"\",\n" +
                "            \"byzd4\": \"22\",\n" +
                "            \"bmmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"byzd3\": \"112\",\n" +
                "            \"sssqjcwhmc\": \"九江下北村委\",\n" +
                "            \"asjdbjbdm\": \"\",\n" +
                "            \"mmdjmc\": \"\",\n" +
                "            \"faasjzz\": \"2020-01-03 17:17:30\",\n" +
                "            \"ysdwdwbh2\": \"\",\n" +
                "            \"fzztlxdm\": \"\",\n" +
                "            \"zhuybaryjh\": \"008553\",\n" +
                "            \"fadxzqhdm\": \"\",\n" +
                "            \"sssqjcwhdm\": \"440605111003\",\n" +
                "            \"ab\": \"吸毒\",\n" +
                "            \"ejgongzbmbh\": \"\",\n" +
                "            \"tbrxm\": \"卢庆江\",\n" +
                "            \"shangcbsmc\": \"\",\n" +
                "            \"ysdwdwmc\": \"\",\n" +
                "            \"padwbh\": \"\",\n" +
                "            \"zyrbzksj\": \"2020-10-22 01:19:46\",\n" +
                "            \"yisrqsj\": \"\",\n" +
                "            \"chuangjrxm1\": \"185195\",\n" +
                "            \"gxsj\": \"2020-01-03 17:22:27\",\n" +
                "            \"fxxsmc\": \"\",\n" +
                "            \"lapzrxm\": \"\",\n" +
                "            \"slsj\": \"2020-01-03 18:15:00\",\n" +
                "            \"larq\": \"\",\n" +
                "            \"cjrqsj\": \"2020-01-03 17:20:31\",\n" +
                "            \"abdm\": \"372103\",\n" +
                "            \"zaztmc\": \"\",\n" +
                "            \"xbxcyxm\": \"卢庆江,何伟源\",\n" +
                "            \"jjdwmc\": \"\",\n" +
                "            \"xzcsdm\": \"\",\n" +
                "            \"ajmc\": \"劳杰凡吸毒案\",\n" +
                "            \"aqshejgjhdqmc\": \"\",\n" +
                "            \"zaztdm\": \"\",\n" +
                "            \"shangcbsdm\": \"\",\n" +
                "            \"jzajajbh\": \"\",\n" +
                "            \"bz\": \"\",\n" +
                "            \"aqshejgjhdqdm\": \"\",\n" +
                "            \"mtzajdwbh\": \"\",\n" +
                "            \"lalrrjh\": \"\",\n" +
                "            \"jjshoulbh\": \"\",\n" +
                "            \"rqsj1\": \"\",\n" +
                "            \"asjdbjbmc\": \"\",\n" +
                "            \"zyzasd\": \"\",\n" +
                "            \"rqsj2\": \"\",\n" +
                "            \"ssxqdm\": \"\",\n" +
                "            \"shouldwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"shoucshjgmc\": \"\",\n" +
                "            \"psztdm\": \"\",\n" +
                "            \"byzd010\": \"\",\n" +
                "            \"zhjdm\": \"XZ06\",\n" +
                "            \"bmgxajbh\": \"\",\n" +
                "            \"blayymc\": \"\",\n" +
                "            \"lazhxgrjh\": \"\",\n" +
                "            \"gxyjztbrqsj\": \"\",\n" +
                "            \"zbdwdwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"fxxsdm\": \"\",\n" +
                "            \"xtbh\": \"c4edc0a26f6961f2016f6ab4cea610a3\",\n" +
                "            \"shoucshjgdm\": \"\",\n" +
                "            \"baarylxdh\": \"\",\n" +
                "            \"blayydm\": \"\",\n" +
                "            \"whjzwy\": \"\",\n" +
                "            \"zbdwbh\": \"440605610800\",\n" +
                "            \"jjfsmc\": \"工作发现\",\n" +
                "            \"sqjcwhdm1\": \"\",\n" +
                "            \"larjh\": \"\",\n" +
                "            \"sqjcwhdm2\": \"\",\n" +
                "            \"anjlxmc\": \"行政\",\n" +
                "            \"xzwpmc\": \"\",\n" +
                "            \"sfcxlabsdm\": \"\",\n" +
                "            \"faddymc\": \"乡村\",\n" +
                "            \"zuihxgsj\": \"2020-01-03 19:36:59\",\n" +
                "            \"lalrsj\": \"\",\n" +
                "            \"mtzajrqsj\": \"\",\n" +
                "            \"anjlxdm\": \"02\",\n" +
                "            \"bsmc\": \"\",\n" +
                "            \"jyaq\": \"2019年1月3日17时许，九江派出所民警经侦查发现在佛山市南海区九江镇下北大道信基广场对开路边有一名男子涉嫌吸毒，后民警去到上址将该名男子抓获并传唤到九江派出所进行询问。\",\n" +
                "            \"sftgtjsjspbsdm\": \"\",\n" +
                "            \"ladwmc\": \"\",\n" +
                "            \"xzsjdm\": \"\",\n" +
                "            \"xzwpdm\": \"\",\n" +
                "            \"sftgtjsjspbsmc\": \"\",\n" +
                "            \"zars\": \"\",\n" +
                "            \"juzajwsbh\": \"c4edc0a26f6961f2016f6ab4cea610a2\",\n" +
                "            \"swrs\": \"\",\n" +
                "            \"byzd07\": \"\",\n" +
                "            \"byzd09\": \"\",\n" +
                "            \"fxsj\": \"\",\n" +
                "            \"byzd05\": \"\",\n" +
                "            \"byzd06\": \"\",\n" +
                "            \"xzsjmc\": \"\",\n" +
                "            \"zyzasddm\": \"\",\n" +
                "            \"anjztdm\": \"60\",\n" +
                "            \"fadqhnxxdz\": \"广东省佛山市南海区九江镇下北大道信基广场对开路边\",\n" +
                "            \"yusblajbsdm\": \"\",\n" +
                "            \"fadwdwmc\": \"\",\n" +
                "            \"xzcsmc\": \"\",\n" +
                "            \"fadssxqdm\": \"440605\",\n" +
                "            \"cxajrqsj\": \"\",\n" +
                "            \"aqsfswbsdm\": \"0\",\n" +
                "            \"fadxzjdmc\": \"-\",\n" +
                "            \"ysdwbgdh2\": \"\",\n" +
                "            \"zhuanabsdm\": \"\",\n" +
                "            \"aqsfswbsmc\": \"否\",\n" +
                "            \"anjztmc\": \"已处罚\",\n" +
                "            \"yusgtysajdwbh\": \"\",\n" +
                "            \"slrjh\": \"\",\n" +
                "            \"bjsj\": \"2020-01-03 17:18:47\",\n" +
                "            \"jjfsdm\": \"04\",\n" +
                "            \"bzksjgxsj\": \"2020-10-22 01:19:46\",\n" +
                "            \"ssjqdm\": \"440605610603\",\n" +
                "            \"xzdxdm\": \"\",\n" +
                "            \"bsdm\": \"\",\n" +
                "            \"sfcxlabsmc\": \"\",\n" +
                "            \"fadssxqmc\": \"广东省佛山市南海区\",\n" +
                "            \"shouldwbh\": \"440605610800\",\n" +
                "            \"zhuanabsmc\": \"\",\n" +
                "            \"sjuztdm\": \"\",\n" +
                "            \"fadxzjddm\": \"440605\",\n" +
                "            \"fadshcsdm\": \"13\",\n" +
                "            \"anjwybsh\": \"\",\n" +
                "            \"ssjqmc\": \"九江下北警区\",\n" +
                "            \"jjdwbh\": \"\",\n" +
                "            \"zuihxgrjh\": \"185195\",\n" +
                "            \"yscbrxm2\": \"\",\n" +
                "            \"anjlydm\": \"\",\n" +
                "            \"shcbsdm\": \"0\",\n" +
                "            \"xbrjh\": \",185195,185070\",\n" +
                "            \"xiacbsdm\": \"\",\n" +
                "            \"dbxx\": \"\",\n" +
                "            \"shcbsmc\": \"否\",\n" +
                "            \"lapzrqsj\": \"\",\n" +
                "            \"zhuyajbh\": \"\",\n" +
                "            \"btglarqsj\": \"\",\n" +
                "            \"dccfzyzdshqrxm\": \"\",\n" +
                "            \"zagjmc\": \"\",\n" +
                "            \"xiacbsmc\": \"\",\n" +
                "            \"faasjcz\": \"2020-01-03 17:17:28\",\n" +
                "            \"ladwbh\": \"370114050100\",\n" +
                "            \"ssjzrmby\": \"\",\n" +
                "            \"afdpcsdm\": \"\",\n" +
                "            \"jarqsj\": \"\",\n" +
                "            \"zbzcyxm\": \"卢庆江\",\n" +
                "            \"sjuyzm\": \"\",\n" +
                "            \"zagjdm\": \"\",\n" +
                "            \"dccfzyzdlxdm\": \"\",\n" +
                "            \"dccfzyzdlxmc\": \"\",\n" +
                "            \"xzjddm\": \"\",\n" +
                "            \"parqsj\": \"\",\n" +
                "            \"whcdmc\": \"\",\n" +
                "            \"ejgongzbmmc\": \"\",\n" +
                "            \"jutajly\": \"\",\n" +
                "            \"faddydm1\": \"\",\n" +
                "            \"byzd36\": \"\",\n" +
                "            \"faddydm2\": \"4\",\n" +
                "            \"ysdwdwbh\": \"\",\n" +
                "            \"yscbrxm\": \"\",\n" +
                "            \"tianbrqsj\": \"2020-01-03 17:18:47\",\n" +
                "            \"zjmc\": \"违法嫌疑人的陈述和申辩\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mmdjdm\": \"\",\n" +
                "            \"ajbh\": \"A4406056108002020010009\",\n" +
                "            \"whcddm\": \"\",\n" +
                "            \"fzztlxmc\": \"\",\n" +
                "            \"lazuihxgsj\": \"\",\n" +
                "            \"byzd9\": \"error\",\n" +
                "            \"xzbwmc\": \"\",\n" +
                "            \"asjysrqsj\": \"\",\n" +
                "            \"sazongjjermby\": \"\",\n" +
                "            \"byzd6\": \"440605610603\",\n" +
                "            \"xzbwdm\": \"\",\n" +
                "            \"ysdwbgdh\": \"\",\n" +
                "            \"byzd2\": \"\",\n" +
                "            \"byzd1\": \"\",\n" +
                "            \"byzd4\": \"22\",\n" +
                "            \"bmmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"byzd3\": \"112\",\n" +
                "            \"sssqjcwhmc\": \"九江下北村委\",\n" +
                "            \"asjdbjbdm\": \"\",\n" +
                "            \"mmdjmc\": \"\",\n" +
                "            \"faasjzz\": \"2020-01-03 17:14:11\",\n" +
                "            \"ysdwdwbh2\": \"\",\n" +
                "            \"fzztlxdm\": \"\",\n" +
                "            \"zhuybaryjh\": \"185195\",\n" +
                "            \"fadxzqhdm\": \"\",\n" +
                "            \"sssqjcwhdm\": \"440605111003\",\n" +
                "            \"ab\": \"吸毒\",\n" +
                "            \"ejgongzbmbh\": \"\",\n" +
                "            \"tbrxm\": \"\",\n" +
                "            \"shangcbsmc\": \"\",\n" +
                "            \"ysdwdwmc\": \"\",\n" +
                "            \"padwbh\": \"\",\n" +
                "            \"zyrbzksj\": \"2020-10-22 01:40:18\",\n" +
                "            \"yisrqsj\": \"\",\n" +
                "            \"chuangjrxm1\": \"185195\",\n" +
                "            \"gxsj\": \"2020-01-03 17:22:50\",\n" +
                "            \"fxxsmc\": \"\",\n" +
                "            \"lapzrxm\": \"\",\n" +
                "            \"slsj\": \"2020-01-03 18:15:00\",\n" +
                "            \"larq\": \"\",\n" +
                "            \"cjrqsj\": \"2020-01-03 17:16:14\",\n" +
                "            \"abdm\": \"372103\",\n" +
                "            \"zaztmc\": \"\",\n" +
                "            \"xbxcyxm\": \"卢庆江,何伟源\",\n" +
                "            \"jjdwmc\": \"\",\n" +
                "            \"xzcsdm\": \"\",\n" +
                "            \"ajmc\": \"甘锡前吸毒案\",\n" +
                "            \"aqshejgjhdqmc\": \"\",\n" +
                "            \"zaztdm\": \"\",\n" +
                "            \"shangcbsdm\": \"\",\n" +
                "            \"jzajajbh\": \"\",\n" +
                "            \"bz\": \"\",\n" +
                "            \"aqshejgjhdqdm\": \"\",\n" +
                "            \"mtzajdwbh\": \"\",\n" +
                "            \"lalrrjh\": \"\",\n" +
                "            \"jjshoulbh\": \"\",\n" +
                "            \"rqsj1\": \"\",\n" +
                "            \"asjdbjbmc\": \"\",\n" +
                "            \"zyzasd\": \"\",\n" +
                "            \"rqsj2\": \"\",\n" +
                "            \"ssxqdm\": \"\",\n" +
                "            \"shouldwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"shoucshjgmc\": \"\",\n" +
                "            \"psztdm\": \"\",\n" +
                "            \"byzd010\": \"\",\n" +
                "            \"zhjdm\": \"XZ06\",\n" +
                "            \"bmgxajbh\": \"\",\n" +
                "            \"blayymc\": \"\",\n" +
                "            \"lazhxgrjh\": \"\",\n" +
                "            \"gxyjztbrqsj\": \"\",\n" +
                "            \"zbdwdwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"fxxsdm\": \"\",\n" +
                "            \"xtbh\": \"c4edc0a26f6961f2016f6ab0e11e108c\",\n" +
                "            \"shoucshjgdm\": \"\",\n" +
                "            \"baarylxdh\": \"\",\n" +
                "            \"blayydm\": \"\",\n" +
                "            \"whjzwy\": \"\",\n" +
                "            \"zbdwbh\": \"440605610800\",\n" +
                "            \"jjfsmc\": \"工作发现\",\n" +
                "            \"sqjcwhdm1\": \"\",\n" +
                "            \"larjh\": \"\",\n" +
                "            \"sqjcwhdm2\": \"\",\n" +
                "            \"anjlxmc\": \"行政\",\n" +
                "            \"xzwpmc\": \"\",\n" +
                "            \"sfcxlabsdm\": \"\",\n" +
                "            \"faddymc\": \"乡村\",\n" +
                "            \"zuihxgsj\": \"2020-01-03 19:21:43\",\n" +
                "            \"lalrsj\": \"\",\n" +
                "            \"mtzajrqsj\": \"\",\n" +
                "            \"anjlxdm\": \"02\",\n" +
                "            \"bsmc\": \"\",\n" +
                "            \"jyaq\": \"2019年1月3日17时许，九江派出所民警经侦查发现在佛山市南海区九江镇下北大道信基广场对开路边有一名男子涉嫌吸毒，后民警去到上址将该名男子抓获并传唤到九江派出所进行询问。\",\n" +
                "            \"sftgtjsjspbsdm\": \"\",\n" +
                "            \"ladwmc\": \"\",\n" +
                "            \"xzsjdm\": \"\",\n" +
                "            \"xzwpdm\": \"\",\n" +
                "            \"sftgtjsjspbsmc\": \"\",\n" +
                "            \"zars\": \"\",\n" +
                "            \"juzajwsbh\": \"c4edc0a26f6961f2016f6ab0e10e108b\",\n" +
                "            \"swrs\": \"\",\n" +
                "            \"byzd07\": \"\",\n" +
                "            \"byzd09\": \"\",\n" +
                "            \"fxsj\": \"\",\n" +
                "            \"byzd05\": \"\",\n" +
                "            \"byzd06\": \"\",\n" +
                "            \"xzsjmc\": \"\",\n" +
                "            \"zyzasddm\": \"\",\n" +
                "            \"anjztdm\": \"60\",\n" +
                "            \"fadqhnxxdz\": \"广东省佛山市南海区九江镇下北大道信基广场对开路边\",\n" +
                "            \"yusblajbsdm\": \"\",\n" +
                "            \"fadwdwmc\": \"\",\n" +
                "            \"xzcsmc\": \"\",\n" +
                "            \"fadssxqdm\": \"440605\",\n" +
                "            \"cxajrqsj\": \"\",\n" +
                "            \"aqsfswbsdm\": \"0\",\n" +
                "            \"fadxzjdmc\": \"-\",\n" +
                "            \"ysdwbgdh2\": \"\",\n" +
                "            \"zhuanabsdm\": \"\",\n" +
                "            \"aqsfswbsmc\": \"否\",\n" +
                "            \"anjztmc\": \"已处罚\",\n" +
                "            \"yusgtysajdwbh\": \"\",\n" +
                "            \"slrjh\": \"\",\n" +
                "            \"bjsj\": \"2020-01-03 17:13:17\",\n" +
                "            \"jjfsdm\": \"04\",\n" +
                "            \"bzksjgxsj\": \"2020-10-22 01:40:18\",\n" +
                "            \"ssjqdm\": \"440605610603\",\n" +
                "            \"xzdxdm\": \"\",\n" +
                "            \"bsdm\": \"\",\n" +
                "            \"sfcxlabsmc\": \"\",\n" +
                "            \"fadssxqmc\": \"广东省佛山市南海区\",\n" +
                "            \"shouldwbh\": \"440605610800\",\n" +
                "            \"zhuanabsmc\": \"\",\n" +
                "            \"sjuztdm\": \"\",\n" +
                "            \"fadxzjddm\": \"440605\",\n" +
                "            \"fadshcsdm\": \"13\",\n" +
                "            \"anjwybsh\": \"\",\n" +
                "            \"ssjqmc\": \"九江下北警区\",\n" +
                "            \"jjdwbh\": \"\",\n" +
                "            \"zuihxgrjh\": \"185195\",\n" +
                "            \"yscbrxm2\": \"\",\n" +
                "            \"anjlydm\": \"\",\n" +
                "            \"shcbsdm\": \"0\",\n" +
                "            \"xbrjh\": \",185195,185070\",\n" +
                "            \"xiacbsdm\": \"\",\n" +
                "            \"dbxx\": \"\",\n" +
                "            \"shcbsmc\": \"否\",\n" +
                "            \"lapzrqsj\": \"\",\n" +
                "            \"zhuyajbh\": \"\",\n" +
                "            \"btglarqsj\": \"\",\n" +
                "            \"dccfzyzdshqrxm\": \"\",\n" +
                "            \"zagjmc\": \"\",\n" +
                "            \"xiacbsmc\": \"\",\n" +
                "            \"faasjcz\": \"2020-01-03 17:14:06\",\n" +
                "            \"ladwbh\": \"\",\n" +
                "            \"ssjzrmby\": \"\",\n" +
                "            \"afdpcsdm\": \"\",\n" +
                "            \"jarqsj\": \"\",\n" +
                "            \"zbzcyxm\": \"卢庆江\",\n" +
                "            \"sjuyzm\": \"\",\n" +
                "            \"zagjdm\": \"\",\n" +
                "            \"dccfzyzdlxdm\": \"\",\n" +
                "            \"dccfzyzdlxmc\": \"\",\n" +
                "            \"xzjddm\": \"\",\n" +
                "            \"parqsj\": \"\",\n" +
                "            \"whcdmc\": \"\",\n" +
                "            \"ejgongzbmmc\": \"\",\n" +
                "            \"jutajly\": \"\",\n" +
                "            \"faddydm1\": \"\",\n" +
                "            \"byzd36\": \"\",\n" +
                "            \"faddydm2\": \"4\",\n" +
                "            \"ysdwdwbh\": \"\",\n" +
                "            \"yscbrxm\": \"\",\n" +
                "            \"tianbrqsj\": \"2020-01-03 17:13:17\",\n" +
                "            \"zjmc\": \"违法嫌疑人的陈述和申辩\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mmdjdm\": \"\",\n" +
                "            \"ajbh\": \"A4406056108002020010008\",\n" +
                "            \"whcddm\": \"\",\n" +
                "            \"fzztlxmc\": \"\",\n" +
                "            \"lazuihxgsj\": \"\",\n" +
                "            \"byzd9\": \"error\",\n" +
                "            \"xzbwmc\": \"\",\n" +
                "            \"asjysrqsj\": \"\",\n" +
                "            \"sazongjjermby\": \"\",\n" +
                "            \"byzd6\": \"440605610802\",\n" +
                "            \"xzbwdm\": \"\",\n" +
                "            \"ysdwbgdh\": \"\",\n" +
                "            \"byzd2\": \"\",\n" +
                "            \"byzd1\": \"\",\n" +
                "            \"byzd4\": \"22\",\n" +
                "            \"bmmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"byzd3\": \"112\",\n" +
                "            \"sssqjcwhmc\": \"九江下西村委\",\n" +
                "            \"asjdbjbdm\": \"\",\n" +
                "            \"mmdjmc\": \"\",\n" +
                "            \"faasjzz\": \"2020-01-03 16:16:05\",\n" +
                "            \"ysdwdwbh2\": \"\",\n" +
                "            \"fzztlxdm\": \"\",\n" +
                "            \"zhuybaryjh\": \"185195\",\n" +
                "            \"fadxzqhdm\": \"\",\n" +
                "            \"sssqjcwhdm\": \"440605111018\",\n" +
                "            \"ab\": \"赌博\",\n" +
                "            \"ejgongzbmbh\": \"\",\n" +
                "            \"tbrxm\": \"\",\n" +
                "            \"shangcbsmc\": \"\",\n" +
                "            \"ysdwdwmc\": \"\",\n" +
                "            \"padwbh\": \"\",\n" +
                "            \"zyrbzksj\": \"2020-10-22 01:54:05\",\n" +
                "            \"yisrqsj\": \"\",\n" +
                "            \"chuangjrxm1\": \"185195\",\n" +
                "            \"gxsj\": \"2020-01-08 11:28:55\",\n" +
                "            \"fxxsmc\": \"\",\n" +
                "            \"lapzrxm\": \"\",\n" +
                "            \"slsj\": \"2020-01-03 16:35:00\",\n" +
                "            \"larq\": \"\",\n" +
                "            \"cjrqsj\": \"2020-01-03 16:17:56\",\n" +
                "            \"abdm\": \"370102\",\n" +
                "            \"zaztmc\": \"\",\n" +
                "            \"xbxcyxm\": \"程绍荣,何伟强\",\n" +
                "            \"jjdwmc\": \"\",\n" +
                "            \"xzcsdm\": \"\",\n" +
                "            \"ajmc\": \"杨正伟等人赌博案（快办）\",\n" +
                "            \"aqshejgjhdqmc\": \"\",\n" +
                "            \"zaztdm\": \"\",\n" +
                "            \"shangcbsdm\": \"\",\n" +
                "            \"jzajajbh\": \"\",\n" +
                "            \"bz\": \"\",\n" +
                "            \"aqshejgjhdqdm\": \"\",\n" +
                "            \"mtzajdwbh\": \"\",\n" +
                "            \"lalrrjh\": \"\",\n" +
                "            \"jjshoulbh\": \"\",\n" +
                "            \"rqsj1\": \"\",\n" +
                "            \"asjdbjbmc\": \"\",\n" +
                "            \"zyzasd\": \"\",\n" +
                "            \"rqsj2\": \"\",\n" +
                "            \"ssxqdm\": \"\",\n" +
                "            \"shouldwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"shoucshjgmc\": \"\",\n" +
                "            \"psztdm\": \"\",\n" +
                "            \"byzd010\": \"\",\n" +
                "            \"zhjdm\": \"XZ06\",\n" +
                "            \"bmgxajbh\": \"\",\n" +
                "            \"blayymc\": \"\",\n" +
                "            \"lazhxgrjh\": \"\",\n" +
                "            \"gxyjztbrqsj\": \"\",\n" +
                "            \"zbdwdwmc\": \"九江派出所洛口社区民警中队\",\n" +
                "            \"fxxsdm\": \"\",\n" +
                "            \"xtbh\": \"c4edc0a26f6961f2016f6a7b81ee0b74\",\n" +
                "            \"shoucshjgdm\": \"\",\n" +
                "            \"baarylxdh\": \"\",\n" +
                "            \"blayydm\": \"\",\n" +
                "            \"whjzwy\": \"\",\n" +
                "            \"zbdwbh\": \"440605610800\",\n" +
                "            \"jjfsmc\": \"工作发现\",\n" +
                "            \"sqjcwhdm1\": \"\",\n" +
                "            \"larjh\": \"\",\n" +
                "            \"sqjcwhdm2\": \"\",\n" +
                "            \"anjlxmc\": \"行政\",\n" +
                "            \"xzwpmc\": \"\",\n" +
                "            \"sfcxlabsdm\": \"\",\n" +
                "            \"faddymc\": \"乡村\",\n" +
                "            \"zuihxgsj\": \"2020-01-08 11:28:55\",\n" +
                "            \"lalrsj\": \"\",\n" +
                "            \"mtzajrqsj\": \"\",\n" +
                "            \"anjlxdm\": \"02\",\n" +
                "            \"bsmc\": \"\",\n" +
                "            \"jyaq\": \"2020年01月3日下午15时许，我所民警在工作中发现，在九江镇下西木棉花美食店，有多人涉嫌用麻将牌进行赌博，于是进行查处。经查，当场在该住宅内，查获涉嫌用麻将牌进行赌博的杨正伟、翟顺增、罗志斌等三人，并缴获麻将台一张，麻将一副，胶凳四张，赌资共470元。\",\n" +
                "            \"sftgtjsjspbsdm\": \"\",\n" +
                "            \"ladwmc\": \"\",\n" +
                "            \"xzsjdm\": \"\",\n" +
                "            \"xzwpdm\": \"\",\n" +
                "            \"sftgtjsjspbsmc\": \"\",\n" +
                "            \"zars\": \"\",\n" +
                "            \"juzajwsbh\": \"c4edc0a26f6961f2016f6a7b81cf0b73\",\n" +
                "            \"swrs\": \"\",\n" +
                "            \"byzd07\": \"\",\n" +
                "            \"byzd09\": \"\",\n" +
                "            \"fxsj\": \"\",\n" +
                "            \"byzd05\": \"\",\n" +
                "            \"byzd06\": \"\",\n" +
                "            \"xzsjmc\": \"\",\n" +
                "            \"zyzasddm\": \"\",\n" +
                "            \"anjztdm\": \"60\",\n" +
                "            \"fadqhnxxdz\": \"广东省佛山市南海区九江镇下西木棉花美食店\",\n" +
                "            \"yusblajbsdm\": \"\",\n" +
                "            \"fadwdwmc\": \"\",\n" +
                "            \"xzcsmc\": \"\",\n" +
                "            \"fadssxqdm\": \"440605\",\n" +
                "            \"cxajrqsj\": \"\",\n" +
                "            \"aqsfswbsdm\": \"0\",\n" +
                "            \"fadxzjdmc\": \"-\",\n" +
                "            \"ysdwbgdh2\": \"\",\n" +
                "            \"zhuanabsdm\": \"\",\n" +
                "            \"aqsfswbsmc\": \"否\",\n" +
                "            \"anjztmc\": \"已处罚\",\n" +
                "            \"yusgtysajdwbh\": \"\",\n" +
                "            \"slrjh\": \"\",\n" +
                "            \"bjsj\": \"2020-01-03 16:15:56\",\n" +
                "            \"jjfsdm\": \"04\",\n" +
                "            \"bzksjgxsj\": \"2020-10-22 01:54:05\",\n" +
                "            \"ssjqdm\": \"440605610802\",\n" +
                "            \"xzdxdm\": \"\",\n" +
                "            \"bsdm\": \"\",\n" +
                "            \"sfcxlabsmc\": \"\",\n" +
                "            \"fadssxqmc\": \"广东省佛山市南海区\",\n" +
                "            \"shouldwbh\": \"440605610800\",\n" +
                "            \"zhuanabsmc\": \"\",\n" +
                "            \"sjuztdm\": \"\",\n" +
                "            \"fadxzjddm\": \"440605\",\n" +
                "            \"fadshcsdm\": \"10\",\n" +
                "            \"anjwybsh\": \"\",\n" +
                "            \"ssjqmc\": \"九江下西警区           \",\n" +
                "            \"jjdwbh\": \"\",\n" +
                "            \"zuihxgrjh\": \"185054\",\n" +
                "            \"yscbrxm2\": \"\",\n" +
                "            \"anjlydm\": \"\",\n" +
                "            \"shcbsdm\": \"0\",\n" +
                "            \"xbrjh\": \",185054,185099\",\n" +
                "            \"xiacbsdm\": \"\",\n" +
                "            \"dbxx\": \"\",\n" +
                "            \"shcbsmc\": \"否\",\n" +
                "            \"lapzrqsj\": \"\",\n" +
                "            \"zhuyajbh\": \"\",\n" +
                "            \"btglarqsj\": \"\",\n" +
                "            \"dccfzyzdshqrxm\": \"\",\n" +
                "            \"zagjmc\": \"A9908,A9907,其他橡胶塑料制品\",\n" +
                "            \"xiacbsmc\": \"\",\n" +
                "            \"faasjcz\": \"2020-01-03 16:16:00\",\n" +
                "            \"ladwbh\": \"\",\n" +
                "            \"ssjzrmby\": 0,\n" +
                "            \"afdpcsdm\": \"\",\n" +
                "            \"jarqsj\": \"\",\n" +
                "            \"zbzcyxm\": \"卢庆江\",\n" +
                "            \"sjuyzm\": \"\",\n" +
                "            \"zagjdm\": \"A9908,A9907,O9900\",\n" +
                "            \"dccfzyzdlxdm\": \"\",\n" +
                "            \"dccfzyzdlxmc\": \"\",\n" +
                "            \"xzjddm\": \"\",\n" +
                "            \"parqsj\": \"\",\n" +
                "            \"whcdmc\": \"\",\n" +
                "            \"ejgongzbmmc\": \"\",\n" +
                "            \"jutajly\": \"\",\n" +
                "            \"faddydm1\": \"\",\n" +
                "            \"byzd36\": \"\",\n" +
                "            \"faddydm2\": \"4\",\n" +
                "            \"ysdwdwbh\": \"\",\n" +
                "            \"yscbrxm\": \"\",\n" +
                "            \"tianbrqsj\": \"2020-01-03 16:13:36\",\n" +
                "            \"zjmc\": \"违法嫌疑人的陈述和申辩\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"mmdjdm\": \"\",\n" +
                "            \"ajbh\": \"A4406071011002020010004\",\n" +
                "            \"whcddm\": \"\",\n" +
                "            \"fzztlxmc\": \"\",\n" +
                "            \"lazuihxgsj\": \"\",\n" +
                "            \"byzd9\": \"error\",\n" +
                "            \"xzbwmc\": \"\",\n" +
                "            \"asjysrqsj\": \"\",\n" +
                "            \"sazongjjermby\": \"\",\n" +
                "            \"byzd6\": \"440607540601\",\n" +
                "            \"xzbwdm\": \"\",\n" +
                "            \"ysdwbgdh\": \"\",\n" +
                "            \"byzd2\": \"\",\n" +
                "            \"byzd1\": \"\",\n" +
                "            \"byzd4\": \"2335265\",\n" +
                "            \"bmmc\": \"交通警察大队芦苞中队\",\n" +
                "            \"byzd3\": \"112.89745\",\n" +
                "            \"sssqjcwhmc\": \"四联\",\n" +
                "            \"asjdbjbdm\": \"\",\n" +
                "            \"mmdjmc\": \"\",\n" +
                "            \"faasjzz\": \"2020-01-03 09:20:27\",\n" +
                "            \"ysdwdwbh2\": \"\",\n" +
                "            \"fzztlxdm\": \"\",\n" +
                "            \"zhuybaryjh\": \"187376\",\n" +
                "            \"fadxzqhdm\": \"\",\n" +
                "            \"sssqjcwhdm\": \"440783815015\",\n" +
                "            \"ab\": \"无驾驶证驾驶机动车辆\",\n" +
                "            \"ejgongzbmbh\": \"\",\n" +
                "            \"tbrxm\": \"\",\n" +
                "            \"shangcbsmc\": \"\",\n" +
                "            \"ysdwdwmc\": \"\",\n" +
                "            \"padwbh\": \"\",\n" +
                "            \"zyrbzksj\": \"2020-10-22 01:42:37\",\n" +
                "            \"yisrqsj\": \"\",\n" +
                "            \"chuangjrxm1\": \"187376\",\n" +
                "            \"gxsj\": \"2020-01-03 10:39:15\",\n" +
                "            \"fxxsmc\": \"\",\n" +
                "            \"lapzrxm\": \"\",\n" +
                "            \"slsj\": \"2020-01-03 01:00:00\",\n" +
                "            \"larq\": \"\",\n" +
                "            \"cjrqsj\": \"2020-01-03 10:27:56\",\n" +
                "            \"abdm\": \"360201\",\n" +
                "            \"zaztmc\": \"\",\n" +
                "            \"xbxcyxm\": \"邓伟池,禤居厚,陈志林,郭雄光,陈诗斌,\",\n" +
                "            \"jjdwmc\": \"\",\n" +
                "            \"xzcsdm\": \"\",\n" +
                "            \"ajmc\": \"蔡嘉伟无有效机动车驾驶证驾驶机动车\",\n" +
                "            \"aqshejgjhdqmc\": \"\",\n" +
                "            \"zaztdm\": \"\",\n" +
                "            \"shangcbsdm\": \"\",\n" +
                "            \"jzajajbh\": \"\",\n" +
                "            \"bz\": \"\",\n" +
                "            \"aqshejgjhdqdm\": \"\",\n" +
                "            \"mtzajdwbh\": \"\",\n" +
                "            \"lalrrjh\": \"\",\n" +
                "            \"jjshoulbh\": \"\",\n" +
                "            \"rqsj1\": \"\",\n" +
                "            \"asjdbjbmc\": \"\",\n" +
                "            \"zyzasd\": \"\",\n" +
                "            \"rqsj2\": \"\",\n" +
                "            \"ssxqdm\": \"\",\n" +
                "            \"shouldwmc\": \"交通警察大队芦苞中队\",\n" +
                "            \"shoucshjgmc\": \"\",\n" +
                "            \"psztdm\": \"\",\n" +
                "            \"byzd010\": \"\",\n" +
                "            \"zhjdm\": \"XZ02,XZ03,XZ06\",\n" +
                "            \"bmgxajbh\": \"\",\n" +
                "            \"blayymc\": \"\",\n" +
                "            \"lazhxgrjh\": \"\",\n" +
                "            \"gxyjztbrqsj\": \"\",\n" +
                "            \"zbdwdwmc\": \"交通警察大队芦苞中队\",\n" +
                "            \"fxxsdm\": \"\",\n" +
                "            \"xtbh\": \"c4edc0a26f54b444016f693b11ac7b6a\",\n" +
                "            \"shoucshjgdm\": \"\",\n" +
                "            \"baarylxdh\": \"\",\n" +
                "            \"blayydm\": \"\",\n" +
                "            \"whjzwy\": \"\",\n" +
                "            \"zbdwbh\": \"440607101100\",\n" +
                "            \"jjfsmc\": \"工作发现\",\n" +
                "            \"sqjcwhdm1\": \"\",\n" +
                "            \"larjh\": \"\",\n" +
                "            \"sqjcwhdm2\": \"\",\n" +
                "            \"anjlxmc\": \"行政\",\n" +
                "            \"xzwpmc\": \"\",\n" +
                "            \"sfcxlabsdm\": \"\",\n" +
                "            \"faddymc\": \"郊区\",\n" +
                "            \"zuihxgsj\": \"2020-01-17 11:31:59\",\n" +
                "            \"lalrsj\": \"\",\n" +
                "            \"mtzajrqsj\": \"\",\n" +
                "            \"anjlxdm\": \"02\",\n" +
                "            \"bsmc\": \"\",\n" +
                "            \"jyaq\": \"2020年1月03日，蔡嘉伟驾驶一辆无号牌（发动机号后六位数：103235、车架号后六位数：103235）二轮摩托车，沿三水区芦苞镇东海大道往成公路 （东往西）方向行驶，09时20分行驶至芦苞镇成公路芦苞牌坊前路段时被机动设卡点执勤民警查获，经核查，蔡嘉伟存在无有效机动车驾驶证驾驶机动车的违法行为，蔡嘉伟对其违法行为供认不讳。\",\n" +
                "            \"sftgtjsjspbsdm\": \"\",\n" +
                "            \"ladwmc\": \"\",\n" +
                "            \"xzsjdm\": \"\",\n" +
                "            \"xzwpdm\": \"\",\n" +
                "            \"sftgtjsjspbsmc\": \"\",\n" +
                "            \"zars\": \"\",\n" +
                "            \"juzajwsbh\": \"c4edc0a26f54b444016f693b119d7b69\",\n" +
                "            \"swrs\": \"\",\n" +
                "            \"byzd07\": \"\",\n" +
                "            \"byzd09\": \"\",\n" +
                "            \"fxsj\": \"\",\n" +
                "            \"byzd05\": \"\",\n" +
                "            \"byzd06\": \"\",\n" +
                "            \"xzsjmc\": \"\",\n" +
                "            \"zyzasddm\": \"\",\n" +
                "            \"anjztdm\": \"60\",\n" +
                "            \"fadqhnxxdz\": \"广东省佛山市三水区芦苞镇成公路芦苞牌坊前路段机动卡点\",\n" +
                "            \"yusblajbsdm\": \"\",\n" +
                "            \"fadwdwmc\": \"\",\n" +
                "            \"xzcsmc\": \"\",\n" +
                "            \"fadssxqdm\": \"440607\",\n" +
                "            \"cxajrqsj\": \"\",\n" +
                "            \"aqsfswbsdm\": \"0\",\n" +
                "            \"fadxzjdmc\": \"四联\",\n" +
                "            \"ysdwbgdh2\": \"\",\n" +
                "            \"zhuanabsdm\": \"\",\n" +
                "            \"aqsfswbsmc\": \"否\",\n" +
                "            \"anjztmc\": \"已处罚\",\n" +
                "            \"yusgtysajdwbh\": \"\",\n" +
                "            \"slrjh\": \"\",\n" +
                "            \"bjsj\": \"2020-01-03 10:20:42\",\n" +
                "            \"jjfsdm\": \"04\",\n" +
                "            \"bzksjgxsj\": \"2020-10-22 01:42:37\",\n" +
                "            \"ssjqdm\": \"440607540601\",\n" +
                "            \"xzdxdm\": \"\",\n" +
                "            \"bsdm\": \"\",\n" +
                "            \"sfcxlabsmc\": \"\",\n" +
                "            \"fadssxqmc\": \"广东省佛山市三水区\",\n" +
                "            \"shouldwbh\": \"440607101100\",\n" +
                "            \"zhuanabsmc\": \"\",\n" +
                "            \"sjuztdm\": \"\",\n" +
                "            \"fadxzjddm\": \"440607300966\",\n" +
                "            \"fadshcsdm\": \"13\",\n" +
                "            \"anjwybsh\": \"\",\n" +
                "            \"ssjqmc\": \"芦苞四联警区\",\n" +
                "            \"jjdwbh\": \"\",\n" +
                "            \"zuihxgrjh\": \"187376\",\n" +
                "            \"yscbrxm2\": \"\",\n" +
                "            \"anjlydm\": \"\",\n" +
                "            \"shcbsdm\": \"0\",\n" +
                "            \"xbrjh\": \"187472,187358,187279,187659,187541,\",\n" +
                "            \"xiacbsdm\": \"\",\n" +
                "            \"dbxx\": \"\",\n" +
                "            \"shcbsmc\": \"否\",\n" +
                "            \"lapzrqsj\": \"\",\n" +
                "            \"zhuyajbh\": \"\",\n" +
                "            \"btglarqsj\": \"\",\n" +
                "            \"dccfzyzdshqrxm\": \"\",\n" +
                "            \"zagjmc\": \"\",\n" +
                "            \"xiacbsmc\": \"\",\n" +
                "            \"faasjcz\": \"2020-01-03 09:18:19\",\n" +
                "            \"ladwbh\": \"\",\n" +
                "            \"ssjzrmby\": \"\",\n" +
                "            \"afdpcsdm\": \"\",\n" +
                "            \"jarqsj\": \"\",\n" +
                "            \"zbzcyxm\": \"罗德平\",\n" +
                "            \"sjuyzm\": \"\",\n" +
                "            \"zagjdm\": \"\",\n" +
                "            \"dccfzyzdlxdm\": \"\",\n" +
                "            \"dccfzyzdlxmc\": \"\",\n" +
                "            \"xzjddm\": \"\",\n" +
                "            \"parqsj\": \"\",\n" +
                "            \"whcdmc\": \"\",\n" +
                "            \"ejgongzbmmc\": \"\",\n" +
                "            \"jutajly\": \"\",\n" +
                "            \"faddydm1\": \"\",\n" +
                "            \"byzd36\": \"\",\n" +
                "            \"faddydm2\": \"2\",\n" +
                "            \"ysdwdwbh\": \"\",\n" +
                "            \"yscbrxm\": \"\",\n" +
                "            \"tianbrqsj\": \"2020-01-03 10:20:42\",\n" +
                "            \"zjmc\": \"物证,视听资料/电子数据,违法嫌疑人的陈述和申辩\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": \"成功\",\n" +
                "    \"seqid\": \"8f9a4464b7f84b239a4a42ac24c8b496\"\n" +
                "}";
    }

    @GetMapping("/fsga/distribute/jqxx")
    public String jqxx(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String,Object> param){
        log.info("param:{}",JSON.toJSONString(param));
        log.info("header:{}",request.getHeader("Content-Type"));
        return "{\n" +
                " \"success\": true,\n" +
                " \"code\": \"200\",\n" +
                " \"message\": \"OK\",\n" +
                " \"results\": {\n" +
                "  \"pageNum\": 0,\n" +
                "  \"pageSize\": 0,\n" +
                "  \"size\": 0,\n" +
                "  \"total\": 0,\n" +
                "  \"pages\": 0,\n" +
                "  \"list\": [{\n" +
                "            \"ajbh\": \"J440605590600202103000550\",\n" +
                "            \"tjjf\": null,\n" +
                "            \"reserver23\": null,\n" +
                "            \"reserver22\": null,\n" +
                "            \"reserver21\": null,\n" +
                "            \"reserver20\": \"1617202312000\",\n" +
                "            \"sl_cjcl\": 1,\n" +
                "            \"reserver29\": null,\n" +
                "            \"reserver28\": null,\n" +
                "            \"reserver27\": null,\n" +
                "            \"reserver26\": null,\n" +
                "            \"reserver25\": null,\n" +
                "            \"reserver24\": null,\n" +
                "            \"ab\": \"09000004\",\n" +
                "            \"sl_ajclqk\": \"[佛山市公安局-张愉敏 21/03/31 22:51:51]\\r\\n调度: 南海分局官窑派出所\\r\\n\\r\\n[南海分局官窑派出所-黄永康 21/03/31 22:51:54]\\r\\n反馈:已接收及打开警情\\r\\n\\r\\n[佛山市公安局-张愉敏 21/03/31 22:52:05]\\r\\n通传:佛山市公安局-佛山5(接警厅)\\r\\n\\r\\n[佛山市公安局-罗健茵 21/03/31 22:52:26]\\r\\n反馈:已接收及打开警情\\r\\n\\r\\n[佛山市公安局-罗健茵 21/03/31 22:52:38]\\r\\n请南海分局跟进处理，如有情况及时上报。\\r\\n\\r\\n[佛山市公安局南海分局-钟少梅 21/03/31 22:53:09]\\r\\n反馈:已接收及打开警情\\r\\n\\r\\n[佛山市公安局南海分局-钟少梅 21/03/31 22:53:50]\\r\\n地址不详\\r\\n\\r\\n[佛山市公安局南海分局-钟少梅 21/03/31 22:54:56]\\r\\n经听录音，报案人称在官窑七浦\\r\\n民警复:上址是施工纠纷，民警已现场调解处理。\",\n" +
                "            \"reserver12\": null,\n" +
                "            \"reserver11\": null,\n" +
                "            \"reserver10\": null,\n" +
                "            \"sljjsj_id\": null,\n" +
                "            \"slfxrq\": \"2021-03-31 22:49:17\",\n" +
                "            \"sl_cjry\": \"186505,186497\",\n" +
                "            \"sl_cljg_cn\": \"调解处理\",\n" +
                "            \"reserver19\": null,\n" +
                "            \"reserver18\": null,\n" +
                "            \"sazz\": null,\n" +
                "            \"reserver17\": \"03\",\n" +
                "            \"reserver16\": null,\n" +
                "            \"reserver15\": null,\n" +
                "            \"reserver14\": \"1617204211000\",\n" +
                "            \"reserver13\": null,\n" +
                "            \"reservation07\": \"[佛山市公安局-张愉敏 21/03/31 22:51:50]\\r\\n内容:事主报:其现在上址因他人未经其允许便在其土地位置施工的问题与对方发生纠纷，需要民警到场处理。\\r\\n\\r\\n\\r\\n[佛山市公安局-张愉敏 21/03/31 22:52:00]\\r\\n内容:现场有6人-7人(注：本警情接收于2021-03-31 22:48:48,由警号为186508的警员在2021-03-31 22:49:27确认接收.)\",\n" +
                "            \"reservation06\": \"4406052021033122005240241\",\n" +
                "            \"systemid\": \"PCS4406202103310000001112436795\",\n" +
                "            \"reservation05\": \"09000004\",\n" +
                "            \"reservation04\": \"黄雁玲先生/19924147895\",\n" +
                "            \"reservation09\": \"否\",\n" +
                "            \"reservation08\": \"潘其力\",\n" +
                "            \"fadd\": \"广东省佛山市南海区狮山镇官窑七浦（原报:官窑区浦大理工业园朗泰机械厂位置\",\n" +
                "            \"datastate\": null,\n" +
                "            \"bz\": null,\n" +
                "            \"departmentcode\": \"440605590600\",\n" +
                "            \"reservation03\": null,\n" +
                "            \"reservation02\": \"4406052021033122005240241\",\n" +
                "            \"reservation01\": null,\n" +
                "            \"reservation18\": null,\n" +
                "            \"reservation17\": null,\n" +
                "            \"reservation16\": null,\n" +
                "            \"reservation15\": null,\n" +
                "            \"sl_cjcz\": null,\n" +
                "            \"reservation19\": null,\n" +
                "            \"yscbrdh\": null,\n" +
                "            \"reservation08_cn\": \"潘其力\",\n" +
                "            \"sljsdw_cn\": null,\n" +
                "            \"sljjdw_cn\": \"官窑派出所官窑社区民警中队\",\n" +
                "            \"ysdw_cn\": null,\n" +
                "            \"reservation10\": \"15\",\n" +
                "            \"sl_bjslh\": \"4406052021033122005240241\",\n" +
                "            \"reservation14\": null,\n" +
                "            \"reservation13\": null,\n" +
                "            \"reservation12\": null,\n" +
                "            \"reservation11\": null,\n" +
                "            \"flmjdw\": \"440605590600\",\n" +
                "            \"sssq\": \"440605590604\",\n" +
                "            \"fasjzz\": \"2021-03-31 22:49:15\",\n" +
                "            \"wdw_bary\": null,\n" +
                "            \"sl_jzrs\": null,\n" +
                "            \"cq_scbz\": \"0\",\n" +
                "            \"ssrs\": 0,\n" +
                "            \"fadd_qx\": \"440605\",\n" +
                "            \"sl_lrr\": \"186508\",\n" +
                "            \"deleteflag\": \"0\",\n" +
                "            \"lastupdatedby_cn\": \"潘其力\",\n" +
                "            \"jqlb_cn\": \"其他警情\",\n" +
                "            \"sl_cljg\": \"08\",\n" +
                "            \"jqzbxx\": null,\n" +
                "            \"lastupdatedtime\": \"2021-03-31 23:25:25\",\n" +
                "            \"ajssjq\": \"440605590604\",\n" +
                "            \"yssj\": null,\n" +
                "            \"creator_py\": null,\n" +
                "            \"bdw_bary\": null,\n" +
                "            \"jqlb\": \"13\",\n" +
                "            \"ab_cn\": \":dict.AB\",\n" +
                "            \"cjsj\": null,\n" +
                "            \"departmentcode_cn\": null,\n" +
                "            \"securitygrade\": null,\n" +
                "            \"sl_ldqz\": \"潘其力,调解处理,2021-03-31 23:23:14\",\n" +
                "            \"bjdh\": null,\n" +
                "            \"bjdd\": null,\n" +
                "            \"queryid\": null,\n" +
                "            \"sl_cjhk\": null,\n" +
                "            \"ddsj\": null,\n" +
                "            \"sl_jjfnrs\": null,\n" +
                "            \"sljjry\": \"186508\",\n" +
                "            \"sl_jjetrs\": null,\n" +
                "            \"lastupdatedby_py\": null,\n" +
                "            \"flmjid\": \"186508\",\n" +
                "            \"sljjsj\": \"2021-03-31 22:49:17\",\n" +
                "            \"sljsdw\": null,\n" +
                "            \"datacheck\": null,\n" +
                "            \"cjdw\": null,\n" +
                "            \"ysdw\": null,\n" +
                "            \"reservation60\": null,\n" +
                "            \"sl_jjfs\": \"01\",\n" +
                "            \"lastupdatedby\": \"system_110\",\n" +
                "            \"fadd_qx_cn\": \"广东省佛山市南海区\",\n" +
                "            \"hbjqh\": null,\n" +
                "            \"lxdh\": null,\n" +
                "            \"reserver1\": null,\n" +
                "            \"cq_id\": 0,\n" +
                "            \"bjr\": null,\n" +
                "            \"reserver5\": null,\n" +
                "            \"reserver4\": \"23.114\",\n" +
                "            \"reserver3\": \"116.24\",\n" +
                "            \"reserver2\": null,\n" +
                "            \"sars\": null,\n" +
                "            \"sl_zhrs\": null,\n" +
                "            \"fasjcz_id\": null,\n" +
                "            \"reserver80\": null,\n" +
                "            \"reservation05_cn\": \"其它纠纷\",\n" +
                "            \"reserver9\": null,\n" +
                "            \"reserver8\": null,\n" +
                "            \"ajmc\": null,\n" +
                "            \"reserver7\": null,\n" +
                "            \"reserver6\": \"440605590604\",\n" +
                "            \"cljy\": null,\n" +
                "            \"ysdwcbr_cn\": null,\n" +
                "            \"ddxcsj\": null,\n" +
                "            \"creator\": \"110_system\",\n" +
                "            \"sl_slrxm\": null,\n" +
                "            \"ajssjq_cn\": \"官窑七甫警区\",\n" +
                "            \"uploadflag\": null,\n" +
                "            \"reserver70\": null,\n" +
                "            \"creator_cn\": null,\n" +
                "            \"ysdwcbr\": null,\n" +
                "            \"createdtime\": \"2021-03-31 22:48:48\",\n" +
                "            \"reserver78\": null,\n" +
                "            \"reserver77\": null,\n" +
                "            \"reserver76\": null,\n" +
                "            \"reserver75\": null,\n" +
                "            \"reserver74\": null,\n" +
                "            \"reserver73\": null,\n" +
                "            \"refreshtime\": null,\n" +
                "            \"reserver72\": null,\n" +
                "            \"reserver71\": null,\n" +
                "            \"sl_lrr_cn\": \"潘其力\",\n" +
                "            \"fxxs\": null,\n" +
                "            \"cq_gxsj\": \"2021-04-01 00:00:26\",\n" +
                "            \"reserver79\": null,\n" +
                "            \"ysyy\": null,\n" +
                "            \"sl_jjfs_cn\": \"110(120、122)接转\",\n" +
                "            \"ssjz\": null,\n" +
                "            \"section\": \"440605590000\",\n" +
                "            \"fadd_jd\": \"440605\",\n" +
                "            \"reserver67\": null,\n" +
                "            \"reserver66\": null,\n" +
                "            \"reserver65\": null,\n" +
                "            \"swrs\": 0,\n" +
                "            \"reserver64\": null,\n" +
                "            \"reserver63\": null,\n" +
                "            \"reserver62\": null,\n" +
                "            \"zyaq\": \"[佛山市公安局-张愉敏 21/03/31 22:51:50]\\r\\n内容:事主报:其现在上址因他人未经其允许便在其土地位置施工的问题与对方发生纠纷，需要民警到场处理。\\r\\n\\r\\n\\r\\n[佛山市公安局-张愉敏 21/03/31 22:52:00]\\r\\n内容:现场有6人-7人\",\n" +
                "            \"reserver61\": null,\n" +
                "            \"reserver60\": null,\n" +
                "            \"reservation21\": null,\n" +
                "            \"reservation20\": null,\n" +
                "            \"reservation25\": null,\n" +
                "            \"reservation24\": null,\n" +
                "            \"reserver69\": null,\n" +
                "            \"reservation23\": null,\n" +
                "            \"reserver68\": null,\n" +
                "            \"reservation22\": null,\n" +
                "            \"reservation39\": null,\n" +
                "            \"reservation38\": null,\n" +
                "            \"xckz\": null,\n" +
                "            \"sl_cjry_cn\": \"黄志初,何东华\",\n" +
                "            \"reservation37\": null,\n" +
                "            \"sl_lrsj\": \"2021-03-31 23:23:16\",\n" +
                "            \"reserver56\": null,\n" +
                "            \"reserver55\": null,\n" +
                "            \"reserver54\": null,\n" +
                "            \"reserver53\": null,\n" +
                "            \"reserver52\": null,\n" +
                "            \"reserver51\": null,\n" +
                "            \"reserver50\": null,\n" +
                "            \"reservation32\": null,\n" +
                "            \"reservation31\": null,\n" +
                "            \"reservation36\": null,\n" +
                "            \"reserver59\": null,\n" +
                "            \"reservation35\": null,\n" +
                "            \"sl_slsj\": \"2021-03-31 23:23:14\",\n" +
                "            \"reserver58\": null,\n" +
                "            \"reservation34\": null,\n" +
                "            \"reserver57\": null,\n" +
                "            \"sssq_cn\": \"官窑七甫村委\",\n" +
                "            \"reservation33\": null,\n" +
                "            \"reservation49\": null,\n" +
                "            \"reservation48\": null,\n" +
                "            \"cjjl\": null,\n" +
                "            \"sljjdw\": \"440605590600\",\n" +
                "            \"reservation09_cn\": \"否\",\n" +
                "            \"reserver45\": \"1\",\n" +
                "            \"sl_lrr_py\": null,\n" +
                "            \"reserver44\": null,\n" +
                "            \"fasjcz\": \"2021-03-31 22:49:15\",\n" +
                "            \"reserver43\": null,\n" +
                "            \"reserver42\": null,\n" +
                "            \"reserver41\": null,\n" +
                "            \"reserver40\": null,\n" +
                "            \"downloadflag\": null,\n" +
                "            \"reservation43\": null,\n" +
                "            \"reservation42\": null,\n" +
                "            \"reservation41\": null,\n" +
                "            \"sljjry_cn\": \"潘其力\",\n" +
                "            \"reservation40\": null,\n" +
                "            \"reserver49\": null,\n" +
                "            \"reservation47\": null,\n" +
                "            \"reserver48\": null,\n" +
                "            \"reservation10_cn\": \"其它场所\",\n" +
                "            \"reservation46\": null,\n" +
                "            \"reserver47\": null,\n" +
                "            \"reservation45\": null,\n" +
                "            \"sl_cjrc\": 2,\n" +
                "            \"reserver46\": null,\n" +
                "            \"reservation44\": null,\n" +
                "            \"reservation59\": null,\n" +
                "            \"pjsj\": null,\n" +
                "            \"reserver34\": null,\n" +
                "            \"reserver33\": null,\n" +
                "            \"reserver32\": null,\n" +
                "            \"reserver31\": null,\n" +
                "            \"reserver30\": null,\n" +
                "            \"reservation50\": null,\n" +
                "            \"reservation54\": null,\n" +
                "            \"reservation53\": null,\n" +
                "            \"fadd_jd_cn\": \"-\",\n" +
                "            \"reservation52\": null,\n" +
                "            \"reserver39\": null,\n" +
                "            \"bjly\": null,\n" +
                "            \"reservation51\": null,\n" +
                "            \"reserver38\": null,\n" +
                "            \"reservation58\": null,\n" +
                "            \"reserver37\": null,\n" +
                "            \"reservation57\": null,\n" +
                "            \"reserver36\": null,\n" +
                "            \"reservation56\": null,\n" +
                "            \"reserver35\": null,\n" +
                "            \"reservation55\": null\n" +
                "        }]\n" +
                " }\n" +
                "}";
    }
}
