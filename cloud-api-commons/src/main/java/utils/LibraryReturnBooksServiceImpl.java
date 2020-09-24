package utils;

import java.lang.reflect.Method;
import java.util.*;

public class LibraryReturnBooksServiceImpl {

    /**
     * 根据学号远程调用WebService接口查询学生图书馆还书情况
     *
     * @param xh     学号
     * @param params 参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static InterfaceVO getLxzt(String xh, Map<String, Object> params) {
        InterfaceVO resultMsg = new InterfaceVO();
        try {
            List<ClientField> clientFields = new ArrayList<>();
            // 设置参数
            ClientField field = new ClientField("strCardno", String.class, xh);
            clientFields.add(field);
            //图书馆还书
            ClientBean clientBean = new ClientBean(
                    "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx",
                    "ilasIII OpenAPI", "ilasIII OpenAPI/RdrLoanSrch",
                    "RdrLoanSrch", clientFields);
 
            String returnXml = NHWebServiceUtils.sendWebServiceRequest(clientBean);
            System.out.println("数据:"+returnXml);
            StringBuilder ddString = new StringBuilder("");
            /*if (returnXml != null && !returnXml.isEmpty()) {
                //解析返回的XML数据
                Map<String, String> fieldXmlPaths = new HashMap<>();
                fieldXmlPaths.put("Title", "//RdrLoanInfo/Title");
                fieldXmlPaths.put("Callno", "//RdrLoanInfo/Callno");
                fieldXmlPaths.put("Barcode", "//RdrLoanInfo/Barcode");
                fieldXmlPaths.put("Local", "//RdrLoanInfo/Local");
                fieldXmlPaths.put("Author", "//RdrLoanInfo/Author");
                fieldXmlPaths.put("Loandate", "//RdrLoanInfo/Loandate");
                fieldXmlPaths.put("Returndate", "//RdrLoanInfo/Returndate");
                List<JSXX> studentBooksList = (List<JSXX>) parserXmlToEntity(returnXml, JSXX.class, fieldXmlPaths);
                if (studentBooksList != null) {
                    String bookTitle;
                    for (JSXX jsxx : studentBooksList) {
                        bookTitle = jsxx.getTitle();
                        if (!ddString.toString().contains(bookTitle)) {
                            ddString.append("《").append(bookTitle).append("》");
                        }
                    }
                } else {
                }
            } else {
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMsg;
    }
 
/*    *//**
     * 解析XML文本映射到实体类
     *
     * @param returnXml     XML文本
     * @param cls           解析生成后映射的Class类对象
     * @param fieldXmlPaths XMLPaths集合(XML中的标签路径) 如:
     * @return
     * @throws DocumentException
     *//*
    public static List<?> parserXmlToEntity(String returnXml, Class cls, Map<String, String> fieldXmlPaths) throws DocumentException {
        Document document;
        document = DocumentHelper.parseText(returnXml);
        try {
            //单独用来存属性
            List<String> filedNames = new ArrayList<>();
            //存放<属性,values>
            Map<String, List<Node>> map = new HashMap<>();
            if (fieldXmlPaths != null && fieldXmlPaths.size() > 0) {
                Iterator it = fieldXmlPaths.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    List<Node> nodes = document.selectNodes(value.toString());
                    List<Node> list = new ArrayList<>();
                    for (Node node : nodes) {
                        list.add(node);
                    }
                    //循环放入属性-> 对应的节点
                    map.put(key.toString(), list);
                    filedNames.add(key.toString());
                }
            }
 
            List list = new ArrayList();
            //循环将节点的值放入到对象中，然后放入到list
            for (int i = 0; i < map.get(filedNames.get(0)).size(); i++) {
                Object instance = cls.newInstance();
                for (String fieldName : filedNames) {
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method method = cls.getMethod(methodName, String.class);
                    method.invoke(instance, map.get(fieldName).get(i).getText());
                }
                list.add(instance);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
 
    public static void main(String[] args) {
 
/*        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            InterfaceVO interfaceVO = getLxzt("book", null);
            System.out.println(interfaceVO);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);*/
//        System.out.println(getQQStuats("635436613"));
//        System.out.println("数据："+getSupportCityString());

        ClientBean clientBean = new ClientBean(
                "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx",
                "http://WebXml.com.cn/", "http://WebXml.com.cn/getSupportCityString",
                "getSupportCityString", null);
        System.out.println(NHWebServiceUtils.callWebserviceASMX(clientBean,"{\"theRegionCode\":31124}"));
    }

    public static String getRegionCountry(){
        //图书馆还书
        ClientBean clientBean = new ClientBean(
                "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx",
                "http://WebXml.com.cn/", "http://WebXml.com.cn/getRegionCountry",
                "getRegionCountry", null);

        String returnXml = NHWebServiceUtils.sendWebService(clientBean);
        return returnXml;
    }

    public static String getSupportCityString(){
        List<ClientField> clientFields = new ArrayList<>();
        // 设置参数
        ClientField field = new ClientField("theRegionCode", Integer.class, 31124);
        clientFields.add(field);

        ClientBean clientBean = new ClientBean(
                "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx",
                "http://WebXml.com.cn/", "http://WebXml.com.cn/getSupportCityString",
                "getSupportCityString", clientFields);

        String returnXml = NHWebServiceUtils.sendWebService(clientBean);
        return returnXml;
    }

    public static String getQQStuats(String qq){
        List<ClientField> clientFields = new ArrayList<>();
        // 设置参数
        ClientField field = new ClientField("qqCode", String.class, qq);
        clientFields.add(field);
        //图书馆还书
        ClientBean clientBean = new ClientBean(
                "http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx",
                "http://WebXml.com.cn/", "http://WebXml.com.cn/qqCheckOnline",
                "qqCheckOnline", clientFields);

        String returnXml = NHWebServiceUtils.sendWebService(clientBean);
        return returnXml;
    }

 
}
 
/**
 * 借书信息类
 */
class JSXX {
    private String Title;
    private String Callno;
    private String Barcode;
    private String Local;
    private String Author;
    private String Loandate;
    private String Returndate;
 
    public String getTitle() {
        return Title;
    }
 
    public void setTitle(String title) {
        Title = title;
    }
 
    public String getCallno() {
        return Callno;
    }
 
    public void setCallno(String callno) {
        Callno = callno;
    }
 
    public String getBarcode() {
        return Barcode;
    }
 
    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
 
    public String getLocal() {
        return Local;
    }
 
    public void setLocal(String local) {
        Local = local;
    }
 
    public String getAuthor() {
        return Author;
    }
 
    public void setAuthor(String author) {
        Author = author;
    }
 
    public String getLoandate() {
        return Loandate;
    }
 
    public void setLoandate(String loandate) {
        Loandate = loandate;
    }
 
    public String getReturndate() {
        return Returndate;
    }
 
    public void setReturndate(String returndate) {
        Returndate = returndate;
    }
 
    @Override
    public String toString() {
        return "JSXX{" +
                "Title='" + Title + '\'' +
                ", Callno='" + Callno + '\'' +
                ", Barcode='" + Barcode + '\'' +
                ", Local='" + Local + '\'' +
                ", Author='" + Author + '\'' +
                ", Loandate='" + Loandate + '\'' +
                ", Returndate='" + Returndate + '\'' +
                '}';
    }
}