package io.sam;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuweimu
 * @Classname MainTest
 * @Description
 * @Date 2020/8/7 10:28
 */
public class MainTest {

    @Test
    public void test01(){
        String xmlinfo ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
                "<root>"+
                "<callerinfo>"+
                "<ywxt_id>"+"ak"+"</ywxt_id>"+
                "<ywxt_pwd>"+"sk"+"</ywxt_pwd>"+
                "<user_id>745002</user_id>"+
                "<user_name>缪义平</user_name>"+
                "<user_sfzh>352229197211046031</user_sfzh>"+
                "<user_dept>350721000000</user_dept>"+
                "<user_deptname>顺昌县公安局</user_deptname>"+
                "</callerinfo>"+
                "<Requestinfo>"+
                //"<RYBH>20200723000000</RYBH>"+
                //"<SHBH>A35010000025220</SHBH>"+
                "<RYLX>25</RYLX>"+
                "<shbh>25</shbh>"+
                //"<AA>25</AA>"+
                //"<ZJHM>350881199202200358</ZJHM>"+
                "<zylx>B_ASJ_BAQ_RYJBXX</zylx>"+
                "<GJ>chian</GJ>"+
                "<LXDH>745845775</LXDH>"+
                "<XXDZMS>25252</XXDZMS>"+
                "<DNABH>20190830092201</DNABH>"+
                "<SG>170</SG>"+
                //"<DEPARTMENTCODE>3501000000002</DEPARTMENTCODE>"+
                //"<ZBRY>20190830092201</ZBRY>"+
                "<id>AA</id>"+
                "<AB>男</AB>"+
                "<AJMC>ASDSAD</AJMC>"+
                "<AJBH>20190830092201</AJBH>"+
                "<RSYYZW>CHIANA</RSYYZW>"+
                "<ZC>20</ZC>"+
                "<TZ>30</TZ>"+
                //"<JZRYBH>普陀山</JZRYBH>"+
                //"<SSDW></SSDW>"+
                //"<CSBH></CSBH>"+
                //  "<SSDS>低端</SSDS>"+
                //"<SSJG>170</SSJG>"+
                //"<DELETEFLAG>0</DELETEFLAG>"+
                //"<LASTUPDATEDBY>20190830092201</LASTUPDATEDBY>"+
                //"<CREATOR>AA</CREATOR>"+
                "<DNACYKH>QWEEWWEWE</DNACYKH>"+
                //"<ZWBH>DSFSDAFSADFSDF</ZWBH>"+
                "<HJDZ>aa</HJDZ>"+
                "<MZ>350240000000</MZ>"+
                //"<XB>男</XB>"+
                //"<XM>法sdf打发撒旦法第三方</XM>"+
                "<CSRQ>20190830</CSRQ>"+
                //"<RSSJ>20190905145000</RSSJ>"+
                //"<CREATEDTIME>20190830092201</CREATEDTIME>"+
                //"<LASTUPDATEDTIME>20190830092201</LASTUPDATEDTIME>"+
                "</Requestinfo>"+
                "</root>";
        System.out.println(xmlinfo);
        Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(xmlinfo);
        System.out.println("stringObjectMap:"+stringObjectMap);
        String mapToXmlStr = XmlUtil.mapToXmlStr(stringObjectMap,"root");
        System.out.println(mapToXmlStr);
        Map<String, Object> stringObjectMap1 = XmlUtil.xmlToMap(mapToXmlStr);
        System.out.println(stringObjectMap1);
    }

    private final static String STANDALONE = "standalone=\"no\"";
    @Test
    public void test02(){
        BaseInfoRequest.CallerInfo callerInfo = new BaseInfoRequest.CallerInfo();
        callerInfo.setYwxt_id("123");
        BAsjBaqRyrqxx bAsjBaqRyrqxx = new BAsjBaqRyrqxx();
        bAsjBaqRyrqxx.setHJDZ("647364");
        bAsjBaqRyrqxx.setRSSJ(new Date());

        BaseInfoRequest baseInfoRequest = BaseInfoRequest.builder().callerInfo(callerInfo).requestInfo(bAsjBaqRyrqxx).build();
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(baseInfoRequest);
        System.out.println(stringObjectMap);
        System.out.println(XmlUtil.mapToXmlStr(stringObjectMap,"root").replaceAll(STANDALONE,""));
    }

    @Test
    public void test03(){
        BAsjBaqRyrqxx bAsjBaqRyrqxx = new BAsjBaqRyrqxx();
        bAsjBaqRyrqxx.setHJDZ("647364");
        bAsjBaqRyrqxx.setRSSJ(new Date());

        BaseInfoRequest baseInfoRequest = BaseInfoRequest.builder().requestInfo(bAsjBaqRyrqxx).build();
        Map<String, Object> beanToMap = BeanUtil.beanToMap(baseInfoRequest);
        System.out.println("beanToMap:"+beanToMap);
        BaseInfoRequest mapToBean = BeanUtil.mapToBean(beanToMap, BaseInfoRequest.class, false);
        System.out.println("mapToBean:"+ JSON.toJSONString(mapToBean));
    }

    @Test
    public void test04(){
        String str = "{\"xmlStr\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?>\n" +
                "\n" +
                "<root>\n" +
                "  <callerInfo>\n" +
                "    <ywxt_id>1df491ee71f347928bd15e1f02f45a97</ywxt_id>\n" +
                "    <ywxt_pwd>d512c5584bee4460ac1226f3c9596420</ywxt_pwd>\n" +
                "    <user_id>745163</user_id>\n" +
                "    <user_name>严章杰</user_name>\n" +
                "    <user_sfzh>35212119681106059X</user_sfzh>\n" +
                "    <user_dept>350721170000</user_dept>\n" +
                "    <user_deptname>顺昌县公安局法制大队</user_deptname>\n" +
                "  </callerInfo>\n" +
                "  <requestInfo>\n" +
                "    <RYBH>4af73e8bf4ab2dae38bd04a6f78511e6</RYBH>\n" +
                "    <SHBH>88301</SHBH>\n" +
                "    <XM>郑康水</XM>\n" +
                "    <SFZH>352121195103070813</SFZH>\n" +
                "    <BADW>350721000000</BADW>\n" +
                "    <ZBMJ>745037</ZBMJ>\n" +
                "    <XBMJ>745037</XBMJ>\n" +
                "    <SBQK>脸部外伤</SBQK>\n" +
                "    <ZSSQYY>打架</ZSSQYY>\n" +
                "    <SBCLQK></SBCLQK>\n" +
                "    <YWBS>[{\\\"label\\\":\\\"高血压\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick01\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"20W\\\"},{\\\"label\\\":\\\"糖尿病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick02\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"20X\\\"},{\\\"label\\\":\\\"心脏病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick03\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"20Y\\\"},{\\\"label\\\":\\\"肺结核\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick04\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"20Z\\\"},{\\\"label\\\":\\\"肝炎\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick05\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"210\\\"},{\\\"label\\\":\\\"艾滋病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick06\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"211\\\"},{\\\"label\\\":\\\"部位手术\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick07\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"212\\\"},{\\\"label\\\":\\\"流感\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick08\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"213\\\"},{\\\"label\\\":\\\"皮肤病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick09\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"214\\\"},{\\\"label\\\":\\\"哮喘\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick10\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"215\\\"},{\\\"label\\\":\\\"性病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick11\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"216\\\"},{\\\"label\\\":\\\"癌症\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick12\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"217\\\"},{\\\"label\\\":\\\"传染性疾病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick13\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"218\\\"},{\\\"label\\\":\\\"抑郁症\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick14\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"219\\\"},{\\\"label\\\":\\\"精神疾病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick15\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"21A\\\"},{\\\"label\\\":\\\"脉管炎\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick16\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"21B\\\"},{\\\"label\\\":\\\"其他疾病\\\",\\\"bool\\\":false,\\\"value\\\":\\\"sick17\\\",\\\"$checked\\\":false,\\\"$$hashKey\\\":\\\"21C\\\"}]</YWBS>\n" +
                "    <TBYWSQ>0</TBYWSQ>\n" +
                "    <SHWZ></SHWZ>\n" +
                "    <ID>350721000000||22ae63d0deeb8bd182f574b73d849ae7</ID>\n" +
                "    <LRSJ>20200430161117</LRSJ>\n" +
                "    <zylx>B_ASJ_BAQ_RSAQJC</zylx>\n" +
                "  </requestInfo>\n" +
                "</root>\n" +
                "\"}";
        System.out.println(str);
        System.out.println(JSON.toJSONString(JSONUtil.parseObj(str)));
    }



}
